package Store;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import Store.Customers.Customer;
import Store.Database.CustomerDAO;

import Store.Inventories.InventoryItem;
import Store.Database.InventoryDAO;
import Store.Employees.Employee;
import Store.Employees.EmployeeTitle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CashRegister extends JPanel {
    Employee emp; 
    ArrayList<InventoryItem> inventory;
    Map<Integer, InventoryItem> inventoryMap;

    // Variables declaration - do not modify                     
    private javax.swing.JLabel MainPanel_OrderLabel;
    private javax.swing.JPanel finalPricePanel;
    private javax.swing.JLabel finalPricePanel_ILSLabel;
    private javax.swing.JLabel finalPricePanel_PriceAfterDiscountDataLabel;
    private javax.swing.JLabel finalPricePanel_PriceAfterDiscountLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel mainPanel_CartLabel;
    private javax.swing.JTable mainPanel_CartTable;
    private javax.swing.JLabel mainPanel_SupplyLabel;
    private javax.swing.JTable mainPanel_SupplyTable;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JLabel orderPanel_CustomerTypeDataLabel;
    private javax.swing.JLabel orderPanel_CustomerTypeLabel;
    private javax.swing.JLabel orderPanel_DiscountLabel;
    private javax.swing.JLabel orderPanel_DiscountPercentageDataLabel;
    private javax.swing.JLabel orderPanel_DiscountPercentageLabel;
    private javax.swing.JSeparator orderPanel_FooterSeparator;
    private javax.swing.JLabel orderPanel_FullNameDataLabel;
    private javax.swing.JLabel orderPanel_FullNameLabel;
    private javax.swing.JSeparator orderPanel_HeaderSeparator;
    private javax.swing.JLabel orderPanel_PersonalInfoLabel;
    private javax.swing.JLabel orderPanel_PhoneDataLabel;
    private javax.swing.JLabel orderPanel_PhoneLabel;
    private javax.swing.JButton orderPanel_SubmitOrderButton;
    private javax.swing.JPanel pricePanel;
    private javax.swing.JLabel pricePanel_ILSLabel;
    private javax.swing.JLabel pricePanel_PriceLabel;
    private javax.swing.JLabel pricePanel_PriceNumber;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel searchPanel_IdLabel;
    private javax.swing.JTextField searchPanel_IdTextField;
    private javax.swing.JButton searchPanel_StartButton;
    
    public CashRegister(Employee emp) {
        this.emp = emp;
        //this.inventoryMap = new HashMap<Integer, inventoryItem>();
        this.inventoryMap = new HashMap<Integer, InventoryItem>();
        initComponents();
    }

    private void initComponents() {

        searchPanel = new javax.swing.JPanel();
        searchPanel_IdLabel = new javax.swing.JLabel();
        searchPanel_IdTextField = new javax.swing.JTextField();
        searchPanel_StartButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanel_CartTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        mainPanel_SupplyTable = new javax.swing.JTable();
        MainPanel_OrderLabel = new javax.swing.JLabel();
        mainPanel_SupplyLabel = new javax.swing.JLabel();
        pricePanel = new javax.swing.JPanel();
        pricePanel_PriceLabel = new javax.swing.JLabel();
        pricePanel_PriceNumber = new javax.swing.JLabel();
        pricePanel_ILSLabel = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        orderPanel_HeaderSeparator = new javax.swing.JSeparator();
        orderPanel_FullNameLabel = new javax.swing.JLabel();
        orderPanel_PhoneLabel = new javax.swing.JLabel();
        orderPanel_CustomerTypeLabel = new javax.swing.JLabel();
        orderPanel_CustomerTypeDataLabel = new javax.swing.JLabel();
        orderPanel_FullNameDataLabel = new javax.swing.JLabel();
        orderPanel_PhoneDataLabel = new javax.swing.JLabel();
        orderPanel_PersonalInfoLabel = new javax.swing.JLabel();
        orderPanel_DiscountLabel = new javax.swing.JLabel();
        orderPanel_FooterSeparator = new javax.swing.JSeparator();
        orderPanel_DiscountPercentageLabel = new javax.swing.JLabel();
        orderPanel_DiscountPercentageDataLabel = new javax.swing.JLabel();
        orderPanel_SubmitOrderButton = new javax.swing.JButton();
        finalPricePanel = new javax.swing.JPanel();
        finalPricePanel_PriceAfterDiscountLabel = new javax.swing.JLabel();
        finalPricePanel_PriceAfterDiscountDataLabel = new javax.swing.JLabel();
        finalPricePanel_ILSLabel = new javax.swing.JLabel();
        mainPanel_CartLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMinimumSize(new java.awt.Dimension(1044, 670));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1044, 670));

        searchPanel.setBackground(new java.awt.Color(250, 250, 250));
        searchPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchPanel_IdLabel.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        searchPanel_IdLabel.setText("ת\"ז של הלקוח");

        searchPanel_IdTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        searchPanel_IdTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        searchPanel_IdTextField.setMargin(new java.awt.Insets(6, 6, 2, 6));

        searchPanel_StartButton.setBackground(new java.awt.Color(0, 147, 250));
        searchPanel_StartButton.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        searchPanel_StartButton.setText("התחל בקנייה");
        searchPanel_StartButton.setMargin(new java.awt.Insets(5, 14, 3, 14));
        searchPanel_StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPanel_StartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchPanel_IdLabel)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(searchPanel_StartButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchPanel_IdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(searchPanel_IdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel_StartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPanel_IdTextField))
                .addGap(26, 26, 26))
        );

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mainPanel_CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "הסר מוצר", "מחיר ליח'", "שם"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(mainPanel_CartTable);
        if (mainPanel_CartTable.getColumnModel().getColumnCount() > 0) {
            mainPanel_CartTable.getColumnModel().getColumn(0).setResizable(false);
            mainPanel_CartTable.getColumnModel().getColumn(1).setResizable(false);
            mainPanel_CartTable.getColumnModel().getColumn(2).setResizable(false);
        }

        mainPanel_SupplyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "הוסף", "כמות במלאי", "מחיר ליח'", "שם"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(mainPanel_SupplyTable);
        if (mainPanel_SupplyTable.getColumnModel().getColumnCount() > 0) {
            mainPanel_SupplyTable.getColumnModel().getColumn(0).setResizable(false);
            mainPanel_SupplyTable.getColumnModel().getColumn(1).setResizable(false);
            mainPanel_SupplyTable.getColumnModel().getColumn(2).setResizable(false);
            mainPanel_SupplyTable.getColumnModel().getColumn(3).setResizable(false);
        }

        MainPanel_OrderLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        MainPanel_OrderLabel.setText("סיכום הזמנה");

        mainPanel_SupplyLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        mainPanel_SupplyLabel.setText("מלאי מוצרים בסניף");

        pricePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pricePanel_PriceLabel.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        pricePanel_PriceLabel.setText("מחיר כולל");

        pricePanel_PriceNumber.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        pricePanel_PriceNumber.setForeground(new java.awt.Color(0, 102, 0));
        pricePanel_PriceNumber.setText("0");

        pricePanel_ILSLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        pricePanel_ILSLabel.setForeground(new java.awt.Color(0, 102, 0));
        pricePanel_ILSLabel.setText("₪");

        javax.swing.GroupLayout pricePanelLayout = new javax.swing.GroupLayout(pricePanel);
        pricePanel.setLayout(pricePanelLayout);
        pricePanelLayout.setHorizontalGroup(
            pricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pricePanelLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(pricePanel_ILSLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pricePanel_PriceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(pricePanel_PriceLabel)
                .addGap(16, 16, 16))
        );
        pricePanelLayout.setVerticalGroup(
            pricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pricePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricePanel_PriceLabel)
                    .addComponent(pricePanel_PriceNumber)
                    .addComponent(pricePanel_ILSLabel))
                .addContainerGap())
        );

        orderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        orderPanel_HeaderSeparator.setForeground(new java.awt.Color(205, 205, 205));

        orderPanel_FullNameLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_FullNameLabel.setText("שם מלא:");

        orderPanel_PhoneLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_PhoneLabel.setText("מס' טלפון:");

        orderPanel_CustomerTypeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_CustomerTypeLabel.setText("סוג לקוח:");

        orderPanel_CustomerTypeDataLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_CustomerTypeDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        orderPanel_CustomerTypeDataLabel.setText("----------------------");

        orderPanel_FullNameDataLabel.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        orderPanel_FullNameDataLabel.setForeground(new java.awt.Color(0, 102, 255));
        orderPanel_FullNameDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        orderPanel_FullNameDataLabel.setText("----------------------");

        orderPanel_PhoneDataLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_PhoneDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        orderPanel_PhoneDataLabel.setText("----------------------");

        orderPanel_PersonalInfoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_PersonalInfoLabel.setText("פרטים אישיים");

        orderPanel_DiscountLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_DiscountLabel.setText("הנחה");

        orderPanel_FooterSeparator.setForeground(new java.awt.Color(205, 205, 205));

        orderPanel_DiscountPercentageLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_DiscountPercentageLabel.setText("אחוז הנחה:");

        orderPanel_DiscountPercentageDataLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        orderPanel_DiscountPercentageDataLabel.setForeground(new java.awt.Color(51, 102, 0));
        orderPanel_DiscountPercentageDataLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        orderPanel_DiscountPercentageDataLabel.setText("-------------------");

        orderPanel_SubmitOrderButton.setBackground(new java.awt.Color(102, 153, 0));
        orderPanel_SubmitOrderButton.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        orderPanel_SubmitOrderButton.setText("בצע הזמנה");
        orderPanel_SubmitOrderButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        finalPricePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        finalPricePanel_PriceAfterDiscountLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        finalPricePanel_PriceAfterDiscountLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        finalPricePanel_PriceAfterDiscountLabel.setText("מחיר סופי לאחר הנחה");

        finalPricePanel_PriceAfterDiscountDataLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        finalPricePanel_PriceAfterDiscountDataLabel.setForeground(new java.awt.Color(0, 102, 0));
        finalPricePanel_PriceAfterDiscountDataLabel.setText("0");

        finalPricePanel_ILSLabel.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        finalPricePanel_ILSLabel.setForeground(new java.awt.Color(0, 102, 0));
        finalPricePanel_ILSLabel.setText("₪");

        javax.swing.GroupLayout finalPricePanelLayout = new javax.swing.GroupLayout(finalPricePanel);
        finalPricePanel.setLayout(finalPricePanelLayout);
        finalPricePanelLayout.setHorizontalGroup(
            finalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finalPricePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalPricePanel_ILSLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalPricePanel_PriceAfterDiscountDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalPricePanel_PriceAfterDiscountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        finalPricePanelLayout.setVerticalGroup(
            finalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finalPricePanelLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(finalPricePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalPricePanel_PriceAfterDiscountDataLabel)
                    .addComponent(finalPricePanel_ILSLabel)
                    .addComponent(finalPricePanel_PriceAfterDiscountLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(orderPanel_FooterSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(orderPanelLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(orderPanel_DiscountPercentageDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderPanel_DiscountPercentageLabel))
                                .addComponent(orderPanel_HeaderSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(orderPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orderPanel_FullNameDataLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderPanel_PhoneDataLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderPanel_CustomerTypeDataLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(26, 26, 26)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(orderPanel_PhoneLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(orderPanel_FullNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(orderPanel_CustomerTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderPanel_SubmitOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalPricePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                                .addComponent(orderPanel_PersonalInfoLabel)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                                .addComponent(orderPanel_DiscountLabel)
                                .addGap(138, 138, 138))))))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(orderPanel_PersonalInfoLabel)
                .addGap(2, 2, 2)
                .addComponent(orderPanel_HeaderSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addComponent(orderPanel_FullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderPanel_PhoneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderPanel_CustomerTypeLabel))
                    .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(orderPanelLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(orderPanel_PhoneDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(orderPanel_CustomerTypeDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(orderPanelLayout.createSequentialGroup()
                            .addComponent(orderPanel_FullNameDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64))))
                .addGap(41, 41, 41)
                .addComponent(orderPanel_DiscountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orderPanel_FooterSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderPanel_DiscountPercentageLabel)
                    .addComponent(orderPanel_DiscountPercentageDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalPricePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderPanel_SubmitOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel_CartLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        mainPanel_CartLabel.setText("סל קניות");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(MainPanel_OrderLabel)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(mainPanel_CartLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPanel_SupplyLabel)
                        .addGap(113, 113, 113))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pricePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainPanel_CartLabel)
                    .addComponent(mainPanel_SupplyLabel)
                    .addComponent(MainPanel_OrderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pricePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>                        
                                                    
    
    // searchPanel_StartButton Methods
    private void searchPanel_StartButtonActionPerformed(java.awt.event.ActionEvent evt) {   
        
        if( Utilities.isNumeric(searchPanel_IdTextField.getText())) {
            ClearTablesCells();
            int customerId = Integer.parseInt(searchPanel_IdTextField.getText());
            CustomerDAO customerDao = new CustomerDAO(); //TODO: DAO Needs to be on the Server-Side!            
            Customer customer = customerDao.getCustomerByID(customerId);

            InventoryDAO inventoryDAO = new InventoryDAO(); //TODO: DAO Needs to be on the Server-Side! 
            inventory = inventoryDAO.getInventoryItemsByBranch(emp.getBranch());
 
            for(int i=0; i < inventory.size(); i++) {
                InventoryItem temp = inventory.get(i);
                addRowWithButtonToSupplyTable(temp.getProductID(), temp.getName(), temp.getPrice(), temp.getQuantity());

                inventoryMap.put(temp.getProductID(), temp);
            }

            orderPanel_FullNameDataLabel.setText(customer.getFullName());
            orderPanel_PhoneDataLabel.setText(customer.getPhoneNumber());
            orderPanel_CustomerTypeDataLabel.setText(customer.getType());
            orderPanel_DiscountPercentageDataLabel.setText(customer.getDiscountPercentage() + "%");
            CenterTablesCells();
        }                                               
        else
            Utilities.MessageBox("תעודת הזהות חייבת להכיל רק מספרים"); //TODO: Add Exception here
    }   

    // mainPanel_SupplyTable & mainPanel_CartTable Methods
    private void ClearTablesCells() {
        DefaultTableModel dmSupplyTable = (DefaultTableModel)mainPanel_SupplyTable.getModel();
        DefaultTableModel dmCartTable = (DefaultTableModel)mainPanel_CartTable.getModel();
        dmSupplyTable.getDataVector().removeAllElements();
        dmCartTable.getDataVector().removeAllElements();
        dmSupplyTable.fireTableDataChanged();
        dmCartTable.fireTableDataChanged(); 
    }
    private void CenterTablesCells() {
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for (int columnIndex = 0; columnIndex < mainPanel_SupplyTable.getColumnCount(); columnIndex++) {
            mainPanel_SupplyTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        for (int columnIndex = 0; columnIndex < mainPanel_CartTable.getColumnCount(); columnIndex++) {
            mainPanel_CartTable.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

        mainPanel_SupplyTable.getColumn("הוסף").setCellRenderer(new ButtonRenderer("images/icon-plus.png"));
        mainPanel_SupplyTable.getColumn("הוסף").setCellEditor(new ButtonEditor(new JCheckBox(), "images/icon-plus.png", "add"));

        mainPanel_CartTable.getColumn("הסר מוצר").setCellRenderer(new ButtonRenderer("images/icon-remove.png"));
        mainPanel_CartTable.getColumn("הסר מוצר").setCellEditor(new ButtonEditor(new JCheckBox(), "images/icon-remove.png", "remove"));
    }

    public void addRowWithButtonToSupplyTable(int productId, String name, double price, int quantity) {
        Object[] rowData = { productId, quantity, price, name};

        ((DefaultTableModel)mainPanel_SupplyTable.getModel()).addRow(rowData);
    }
    public void addRowWithButtonToCartTable(int productId, String name, double price) {
        Object[] rowData = { productId, price, name};

        ((DefaultTableModel)mainPanel_CartTable.getModel()).addRow(rowData);
    }
    public void removeRowFromCartTableByProductID(String name) {
        for (int i = 0; i < mainPanel_CartTable.getRowCount(); i++) {
            if (((String)mainPanel_CartTable.getValueAt(i, 2)).equals(name)) {
                DefaultTableModel dmCartTable = (DefaultTableModel)mainPanel_CartTable.getModel();
                dmCartTable.removeRow(i);
                break;
            }//end of if block
        }
    }
    class ButtonRenderer extends JButton implements TableCellRenderer {
        private String iconLocation;
        public ButtonRenderer(String iconLocation) {
            this.iconLocation = iconLocation;
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionForeground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getForeground());
            }

            setHorizontalAlignment(SwingConstants.CENTER);

            // Load and set the image icon
            ImageIcon icon = new ImageIcon(getClass().getResource(iconLocation));
            Image scaledImage = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private int productId;
        private boolean isPushed;
        private String buttonAction;
        private String iconLocation;
      
        public ButtonEditor(JCheckBox checkBox, String iconLocation, String buttonAction) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });

            this.buttonAction = buttonAction;
            this.iconLocation = iconLocation;
        }
      
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionForeground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getForeground());
            }

            ImageIcon icon = new ImageIcon(getClass().getResource(iconLocation));
            Image scaledImage = icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage));
            
            productId = (value == null || value == "") ? -1 : Integer.parseInt(value.toString());
            isPushed = true;

            return button;
        }
      
        public Object getCellEditorValue() {
            if (isPushed) {
                if(buttonAction.equals("add")) {
                    InventoryItem temp = inventoryMap.get(productId);
                    addRowWithButtonToCartTable(temp.getProductID(), temp.getName(), temp.getPrice());
                    //JOptionPane.showMessageDialog(button, "המוצר " + productId + " נוסף לסל הקניות!");
                    
                }  
                else if(buttonAction.equals("remove")) {
                    InventoryItem temp = inventoryMap.get(productId);
                    System.out.println(productId);
                    removeRowFromCartTableByProductID(temp.getName());
                    Utilities.MessageBox("המוצר " + temp.getName() + " הוסר מסל הקניות!");
                    //JOptionPane.showMessageDialog(button, "המוצר " + productId + " הוסר מסל הקניות!");
                }    
            }
            
            isPushed = false;
            return productId;
        }
      
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
      
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cash Register"); // Create a JFrame
            Employee emp = new Employee("ישראל ישראלי", "0528921319", 123456789, 212444, "חולון", "1111", EmployeeTitle.CASHIER);
            CashRegister cashRegister = new CashRegister(emp); // Create your CashRegister JPanel

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(cashRegister); // Add your CashRegister panel to the frame's content pane
            frame.pack(); // Pack the frame to fit its contents
            frame.setVisible(true); // Make the frame visible
        });
    }
}
