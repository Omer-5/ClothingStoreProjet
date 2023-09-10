package Store.Database;

import java.io.*;
import java.net.*;
import java.util.*;

import Store.Client.ServerCommunication.Format;
import Store.AppForms.Chats;
import Store.Client.ServerCommunication.ClassType;
import Store.Client.ServerCommunication.DecodeExecuteCommand;
import Store.Client.ServerCommunication.EncodeCommandChat;
import Store.Employees.Employee;
import Store.Employees.EmployeeTitle;
import Store.Inventories.InventoryItem;

public class Server {
    private static final int PORT = 7000;
    private static Map<Employee, SocketData> connections = new HashMap<Employee, SocketData>();
    private static ChatHandler chatHandler = new ChatHandler();

    public static void main(String[] args) {
        System.out.println("--> Server is running...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                //TODO: Getting Employee When Client-Login Here
                //Employee emp = new Employee("ישראל ישראלי", "0528921319", 123456789, 212444, "חולון", "1111", EmployeeTitle.CASHIER);
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SocketData getSocketDataByEmployee(Employee emp) {
        for(Map.Entry<Employee, SocketData> entry : connections.entrySet()) {
            Employee temp = entry.getKey();
            if(temp.getId() == emp.getId())
                return entry.getValue();
        }
        return null;
    }

    public static Employee getEmployeeBySocketData(SocketData socketData) {
        for(Map.Entry<Employee, SocketData> entry : connections.entrySet()) {
            SocketData temp = entry.getValue(); 

            if(temp.equals(socketData))
                return entry.getKey();
        } 

        return null;
    }

    public static Map<Employee, SocketData> getConnections() {
        return connections;
    }
    public static ChatHandler getChatHandler(){
        return chatHandler;
    }
    public static class ClientHandler extends Thread {
        private SocketData socketData;

        public ClientHandler(Socket socket) {
            this.socketData = new SocketData(socket);
        }

        public void run() {
            try {
                String inputString;
                while ((inputString = socketData.getInputStream().readLine()) != null) {
                    //TODO: Separate Chat, DAO & other Server functions here
                    System.out.println(inputString);
                    String res = DecodeExecuteCommand.decode_and_execute(inputString);

                    if(res.equals("SUCCESS")) {
                        EmployeeDAO DAO = new EmployeeDAO();
                        Employee emp = DAO.getEmployeeByID(Integer.parseInt(Format.getFirstParam(inputString)));

                        synchronized(connections) {
                            connections.put(emp, socketData);
                        }
                    }
                    System.out.println("SERVER: SocketData Response: " + socketData);
                    socketData.getOutputStream().println(res);
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println(getEmployeeBySocketData(socketData).getFullName() + " התנתק מהמערכת.");
            } finally {
                try {
                    socketData.getOutputStream().close();
                    socketData.getSocket().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (connections) {
                    connections.remove(getEmployeeBySocketData(socketData));
                }

                if(chatHandler.getChattingEmployees().containsKey(socketData)) {
                    ChatSession chat = chatHandler.getChatSessionBySocketData(socketData);
                    chat.removeListener(socketData);
                    chatHandler.getAvailableEmployees().remove(socketData);
                }
                else {
                    synchronized(chatHandler.getAvailableEmployees()) {
                        chatHandler.getAvailableEmployees().remove(socketData);
                    }
                }
            }
        }
    }

    public static class ChatHandler {
        private static Map<SocketData, ChatSession> chattingEmployees = new HashMap<SocketData, ChatSession>();
        private static Map<SocketData, Employee> availableEmployees = new HashMap<SocketData, Employee>();

        public static Map<SocketData, ChatSession> getChattingEmployees() {
            return chattingEmployees;
        }
        public static Map<SocketData, Employee> getAvailableEmployees() {
            return availableEmployees;
        }
        
        public void createChatSession(SocketData socketEmp, SocketData socketEmp2) {
            ChatSession chat = new ChatSession(getEmployeeBySocketData(socketEmp), getEmployeeBySocketData(socketEmp2));
            chat.addListener(socketEmp, getEmployeeBySocketData(socketEmp));
            chat.addListener(socketEmp2, getEmployeeBySocketData(socketEmp2));

            chattingEmployees.put(socketEmp, chat);
            chattingEmployees.put(socketEmp2, chat);
        }

        public ChatSession getChatSessionByID(int sessionID) {
            for (Map.Entry<SocketData, ChatSession> entry : chattingEmployees.entrySet()) {
                ChatSession chat = entry.getValue();

                if(chat.getSessionID() == sessionID)
                    return chat;
            }

            return null;
        }
        public static void endChatSession(ChatSession chat) {
            for (Map.Entry<SocketData, ChatSession> entry : chattingEmployees.entrySet()) {
                if (entry.getValue() == chat) {
                    SocketData socketData = entry.getKey();
                    chat.removeListener(socketData);
                    chattingEmployees.remove(socketData);

                    String command = "CHAT@@@abortCurrentChat###";
                    socketData.getOutputStream().println(command);
                }
            }
        }

        public static Set<String> getAvailableBranches(String branch) {
            Set<String> branches = new HashSet<>();
            for (Map.Entry<SocketData, Employee> entry : availableEmployees.entrySet()) {
                Employee emp = entry.getValue();

                if(!emp.getBranch().equals(branch))
                    branches.add(emp.getBranch());
            }
            return branches;
        }

        public static Set<ChatSession> getAvailableChats(String branch) {
            Set<ChatSession> chats = new HashSet<>();
            for (Map.Entry<SocketData, ChatSession> entry : chattingEmployees.entrySet()) {
                //ChatSession chat = entry.getValue();
                //Employee emp = chat.getCreatorEmployee();
                Employee emp = Server.getEmployeeBySocketData(entry.getKey());

                if(emp.getBranch().equals(branch))
                    chats.add(entry.getValue());
            }
            return chats;
        }

        public static SocketData getFirstAvailableEmployeByBranch(String branch) {
            for (Map.Entry<SocketData, Employee> entry : availableEmployees.entrySet()) {
                Employee emp = entry.getValue();

                if(emp.getBranch().equals(branch)) 
                    return entry.getKey();
                    
            }

            return null;
        }

        public static void validateChatSession(ChatSession chat) {
            int chattingCount = 0;
            for (Map.Entry<SocketData, ChatSession> entry : chattingEmployees.entrySet()) {
                int tempSessionID = entry.getValue().getSessionID();
                int sessionID = chat.getSessionID();

                if(tempSessionID == sessionID)
                    chattingCount++;
            }

            if(chattingCount < 2) { // Close chat because not enough employees for chat
                endChatSession(chat);
            }        
        }

        public static ChatSession getChatSessionBySocketData(SocketData socketData) {
            System.out.println(chattingEmployees);
            return chattingEmployees.get(socketData);
        }
    }
}
