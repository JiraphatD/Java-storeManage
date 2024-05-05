
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RE_Evolution Gaming
 */
public class StoreView extends javax.swing.JFrame {
    public ArrayList<MyProduct> productList() {
        ArrayList<MyProduct> productList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDataBase", "myJDB", "myJDB01");
            String query = "SELECT * FROM product";
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(query);
            MyProduct md;
            while(rs.next()) {
                md = new MyProduct(rs.getString("name"), rs.getString("type"), rs.getDouble("price"), rs.getInt("quantity"));
                productList.add(md);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return productList;
    }
    public StoreView() {
        initComponents();
        this.ShopView.setVisible(true);
        this.MyCartView.setVisible(false);
        this.CheckBillView.setVisible(false);
        this.CashMethodView.setVisible(false);
        this.CreditMethodView.setVisible(false);
        this.UpdateCart.setVisible(false);
        ShopBTN.setBackground(new java.awt.Color(255, 102, 255));
        jTextField1.setText("1");
    }
    void AddToCart() {
        ArrayList<MyProduct> list = productList();
        DefaultTableModel model = (DefaultTableModel)CartTable.getModel();
//        model.setRowCount(0);
        int count=0;
        Object[] row = new Object[4];
        for(int i=0; i<list.size(); i++) {
            if(jComboBox1.getSelectedItem().equals(list.get(i).getName())){
                row[0]=list.get(i).getName();
                row[1]=list.get(i).getType();
                row[2]=list.get(i).getPrice();
                row[3]=Integer.parseInt(jTextField1.getText());
                try{
                    System.out.println("maicheck");
                    if(CartTable.getRowCount()==0){
                        if(Integer.parseInt(jTextField1.getText())>list.get(i).getQuantity()){
                            count =1;
                        }
                        
                        System.out.println("check");
                    }
                    for(int o=0; o<CartTable.getRowCount();o++){
                        System.out.println("koufor");
                        if(CartTable.getValueAt(o, 0).toString().equals(jComboBox1.getSelectedItem())){
                            System.out.println("if");
                            if(Integer.parseInt(CartTable.getValueAt(o, 3).toString())+Integer.parseInt(jTextField1.getText())>list.get(i).getQuantity()){
                                System.out.println("ranout");
                            }
                            else {
                                CartTable.setValueAt(Integer.parseInt(CartTable.getValueAt(o, 3).toString())+Integer.parseInt(jTextField1.getText()),o,3);
//                                count=1;
                                System.out.println("empty");
                            }
//                            CartTable.setValueAt(Integer.parseInt(CartTable.getValueAt(i, 3).toString())+Integer.parseInt(jTextField1.getText()),i,3);
                            count=1;
//                            System.out.println("succ");
                        }
                        else{
                            System.out.println("else2");
                            if(Integer.parseInt(jTextField1.getText())>list.get(i).getQuantity()){
                                System.out.println("ranout");
                                count=1;
                            }
                            else {
                                
//                                
                                System.out.println("empty");
                            }
                        }
                    }
                    if(count==1){
                        count=0;
                    }
                    else{
                        model.addRow(row);
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
                
               
            }
//            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UpdateCart = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        UpdateBtn = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ShopBTN = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        CartBTN = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        PaymentBTN = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ExitBTN = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ShopView = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        AddCartBTN = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        MyCartView = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        EditProductBTN1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        CheckBillView = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        CashPayBTN = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        OkeyBTN = new javax.swing.JButton();
        CashMethodView = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CalBTN = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        CreditMethodView = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        CalBTN1 = new javax.swing.JButton();
        RegisterBTN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(958, 592));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        UpdateCart.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 0, 204));
        jLabel38.setText("Name :");

        jLabel39.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 0, 204));
        jLabel39.setText("Update Your Cart");

        jTextField9.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(153, 0, 153));
        jTextField9.setSelectedTextColor(new java.awt.Color(255, 153, 255));
        jTextField9.setSelectionColor(new java.awt.Color(255, 0, 255));

        jLabel40.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 0, 204));
        jLabel40.setText("Type :");

        jTextField10.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(153, 0, 153));
        jTextField10.setSelectedTextColor(new java.awt.Color(255, 153, 255));
        jTextField10.setSelectionColor(new java.awt.Color(255, 0, 255));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(204, 0, 204));
        jLabel41.setText("Price  :");

        jTextField11.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(153, 0, 153));
        jTextField11.setSelectedTextColor(new java.awt.Color(255, 153, 255));
        jTextField11.setSelectionColor(new java.awt.Color(255, 0, 255));

        UpdateBtn.setBackground(new java.awt.Color(255, 102, 255));
        UpdateBtn.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(204, 0, 204));
        jLabel42.setText("Quantity : ");

        jTextField12.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(153, 0, 153));
        jTextField12.setSelectedTextColor(new java.awt.Color(255, 153, 255));
        jTextField12.setSelectionColor(new java.awt.Color(255, 0, 255));

        javax.swing.GroupLayout UpdateCartLayout = new javax.swing.GroupLayout(UpdateCart);
        UpdateCart.setLayout(UpdateCartLayout);
        UpdateCartLayout.setHorizontalGroup(
            UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateCartLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42))
                .addGap(18, 18, 18)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateCartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateCartLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateCartLayout.createSequentialGroup()
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))))
        );
        UpdateCartLayout.setVerticalGroup(
            UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateCartLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(UpdateCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(333, 697));

        jPanel3.setBackground(new java.awt.Color(153, 0, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shop2.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Store View");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))))
        );

        ShopBTN.setBackground(new java.awt.Color(102, 0, 102));
        ShopBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShopBTN.setPreferredSize(new java.awt.Dimension(0, 80));
        ShopBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShopBTNMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Our Shop");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopping-bag2.png"))); // NOI18N

        javax.swing.GroupLayout ShopBTNLayout = new javax.swing.GroupLayout(ShopBTN);
        ShopBTN.setLayout(ShopBTNLayout);
        ShopBTNLayout.setHorizontalGroup(
            ShopBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        ShopBTNLayout.setVerticalGroup(
            ShopBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopBTNLayout.createSequentialGroup()
                .addGroup(ShopBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopBTNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ShopBTNLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CartBTN.setBackground(new java.awt.Color(102, 0, 102));
        CartBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CartBTN.setPreferredSize(new java.awt.Dimension(0, 80));
        CartBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CartBTNMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("My Cart");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopping-cart2.png"))); // NOI18N

        javax.swing.GroupLayout CartBTNLayout = new javax.swing.GroupLayout(CartBTN);
        CartBTN.setLayout(CartBTNLayout);
        CartBTNLayout.setHorizontalGroup(
            CartBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CartBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        CartBTNLayout.setVerticalGroup(
            CartBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CartBTNLayout.createSequentialGroup()
                .addGroup(CartBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CartBTNLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CartBTNLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PaymentBTN.setBackground(new java.awt.Color(102, 0, 102));
        PaymentBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PaymentBTN.setPreferredSize(new java.awt.Dimension(0, 80));
        PaymentBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaymentBTNMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Payment");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/credit-card2.png"))); // NOI18N

        javax.swing.GroupLayout PaymentBTNLayout = new javax.swing.GroupLayout(PaymentBTN);
        PaymentBTN.setLayout(PaymentBTNLayout);
        PaymentBTNLayout.setHorizontalGroup(
            PaymentBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        PaymentBTNLayout.setVerticalGroup(
            PaymentBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentBTNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaymentBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaymentBTNLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ExitBTN.setBackground(new java.awt.Color(102, 0, 102));
        ExitBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitBTN.setPreferredSize(new java.awt.Dimension(0, 80));
        ExitBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBTNMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Exit To Home");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout2.png"))); // NOI18N

        javax.swing.GroupLayout ExitBTNLayout = new javax.swing.GroupLayout(ExitBTN);
        ExitBTN.setLayout(ExitBTNLayout);
        ExitBTNLayout.setHorizontalGroup(
            ExitBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        ExitBTNLayout.setVerticalGroup(
            ExitBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExitBTNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExitBTNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CartBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(PaymentBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(ShopBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(ExitBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShopBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PaymentBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ShopView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 204));
        jLabel5.setText("Popular Product");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/milkBox.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/snack.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vodka.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(204, 0, 204));
        jLabel11.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 204));
        jLabel11.setText("Milk");

        jLabel12.setBackground(new java.awt.Color(204, 0, 204));
        jLabel12.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 204));
        jLabel12.setText("Tashkent Vodka");

        jLabel13.setBackground(new java.awt.Color(204, 0, 204));
        jLabel13.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 204));
        jLabel13.setText("Lay's Classic");

        jLabel14.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 204));
        jLabel14.setText("Choose Product Here!");

        jLabel15.setBackground(new java.awt.Color(204, 0, 204));
        jLabel15.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 204));
        jLabel15.setText("Quantity :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        AddCartBTN.setBackground(new java.awt.Color(255, 102, 255));
        AddCartBTN.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        AddCartBTN.setForeground(new java.awt.Color(255, 255, 255));
        AddCartBTN.setText("Add to cart");
        AddCartBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartBTNActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(204, 0, 204));
        jLabel17.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 204));
        jLabel17.setText("Name :");

        jTextField1.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout ShopViewLayout = new javax.swing.GroupLayout(ShopView);
        ShopView.setLayout(ShopViewLayout);
        ShopViewLayout.setHorizontalGroup(
            ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopViewLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShopViewLayout.createSequentialGroup()
                        .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(ShopViewLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopViewLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopViewLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(27, 27, 27)))
                        .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ShopViewLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel10)
                                .addGap(83, 83, 83))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopViewLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(44, 44, 44))))
                    .addGroup(ShopViewLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addGap(119, 119, 119))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ShopViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(164, 164, 164))
            .addGroup(ShopViewLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ShopViewLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(AddCartBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ShopViewLayout.setVerticalGroup(
            ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShopViewLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(ShopViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(AddCartBTN)
                .addGap(79, 79, 79))
        );

        MyCartView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 204));
        jLabel18.setText("My Cart");

        EditProductBTN1.setBackground(new java.awt.Color(255, 102, 255));
        EditProductBTN1.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        EditProductBTN1.setForeground(new java.awt.Color(255, 255, 255));
        EditProductBTN1.setText("Edit");
        EditProductBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductBTN1ActionPerformed(evt);
            }
        });

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Price", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(CartTable);

        javax.swing.GroupLayout MyCartViewLayout = new javax.swing.GroupLayout(MyCartView);
        MyCartView.setLayout(MyCartViewLayout);
        MyCartViewLayout.setHorizontalGroup(
            MyCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyCartViewLayout.createSequentialGroup()
                .addGroup(MyCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyCartViewLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MyCartViewLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel18))
                    .addGroup(MyCartViewLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(EditProductBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        MyCartViewLayout.setVerticalGroup(
            MyCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyCartViewLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(EditProductBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        CheckBillView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Leelawadee", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 204));
        jLabel19.setText("Check Bill");

        CashPayBTN.setBackground(new java.awt.Color(255, 255, 255));
        CashPayBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CashPayBTN.setPreferredSize(new java.awt.Dimension(150, 150));
        CashPayBTN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CashPayBTNMouseMoved(evt);
            }
        });
        CashPayBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CashPayBTNMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CashPayBTNMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 204));
        jLabel22.setText("Return");

        jTextField4.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 0, 204));

        javax.swing.GroupLayout CashPayBTNLayout = new javax.swing.GroupLayout(CashPayBTN);
        CashPayBTN.setLayout(CashPayBTNLayout);
        CashPayBTNLayout.setHorizontalGroup(
            CashPayBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CashPayBTNLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        CashPayBTNLayout.setVerticalGroup(
            CashPayBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CashPayBTNLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(CashPayBTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        OkeyBTN.setBackground(new java.awt.Color(255, 102, 255));
        OkeyBTN.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        OkeyBTN.setForeground(new java.awt.Color(255, 255, 255));
        OkeyBTN.setText("Okay");
        OkeyBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkeyBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CheckBillViewLayout = new javax.swing.GroupLayout(CheckBillView);
        CheckBillView.setLayout(CheckBillViewLayout);
        CheckBillViewLayout.setHorizontalGroup(
            CheckBillViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckBillViewLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(CashPayBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(CheckBillViewLayout.createSequentialGroup()
                .addGroup(CheckBillViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CheckBillViewLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel19))
                    .addGroup(CheckBillViewLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(OkeyBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CheckBillViewLayout.setVerticalGroup(
            CheckBillViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CheckBillViewLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(CashPayBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(OkeyBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        CashMethodView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 204));
        jLabel27.setText("Baht.");

        jLabel28.setFont(new java.awt.Font("Leelawadee", 1, 48)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 204));
        jLabel28.setText("Cash Method");

        jTextField2.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 0, 204));
        jTextField2.setText("0");

        jLabel29.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 204));
        jLabel29.setText("Summary :");

        jLabel30.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 0, 204));
        jLabel30.setText("Recieve :");

        jTextField3.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 0, 204));
        jTextField3.setText("0");

        jLabel31.setFont(new java.awt.Font("Leelawadee", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 204));
        jLabel31.setText("Baht.");

        CalBTN.setBackground(new java.awt.Color(255, 102, 255));
        CalBTN.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        CalBTN.setForeground(new java.awt.Color(255, 255, 255));
        CalBTN.setText("Check Bill");
        CalBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBTNActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.red);
        jLabel20.setText("Not Enough Money.");

        javax.swing.GroupLayout CashMethodViewLayout = new javax.swing.GroupLayout(CashMethodView);
        CashMethodView.setLayout(CashMethodViewLayout);
        CashMethodViewLayout.setHorizontalGroup(
            CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CashMethodViewLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(161, 161, 161))
            .addGroup(CashMethodViewLayout.createSequentialGroup()
                .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CashMethodViewLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(27, 27, 27)
                        .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(CashMethodViewLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CalBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        CashMethodViewLayout.setVerticalGroup(
            CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CashMethodViewLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(CashMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(CalBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        CreditMethodView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Leelawadee", 1, 48)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 0, 204));
        jLabel34.setText("Credit Method");

        jLabel35.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 0, 204));
        jLabel35.setText("ID :");

        jTextField5.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(204, 0, 204));

        jLabel36.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 0, 204));
        jLabel36.setText("Name :");

        jTextField6.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(204, 0, 204));

        jLabel37.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(204, 0, 204));
        jLabel37.setText("Summary :");

        jTextField7.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(204, 0, 204));

        CalBTN1.setBackground(new java.awt.Color(255, 102, 255));
        CalBTN1.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        CalBTN1.setForeground(new java.awt.Color(255, 255, 255));
        CalBTN1.setText("Calculate");
        CalBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBTN1ActionPerformed(evt);
            }
        });

        RegisterBTN.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        RegisterBTN.setForeground(new java.awt.Color(204, 0, 204));
        RegisterBTN.setText("Register for member?");
        RegisterBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CreditMethodViewLayout = new javax.swing.GroupLayout(CreditMethodView);
        CreditMethodView.setLayout(CreditMethodViewLayout);
        CreditMethodViewLayout.setHorizontalGroup(
            CreditMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreditMethodViewLayout.createSequentialGroup()
                .addGroup(CreditMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreditMethodViewLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel34))
                    .addGroup(CreditMethodViewLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(CalBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CreditMethodViewLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(RegisterBTN))
                    .addGroup(CreditMethodViewLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        CreditMethodViewLayout.setVerticalGroup(
            CreditMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreditMethodViewLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(CreditMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(CreditMethodViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalBTN1))
                .addGap(77, 77, 77)
                .addComponent(RegisterBTN)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShopView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 361, Short.MAX_VALUE)
                    .addComponent(MyCartView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 349, Short.MAX_VALUE)
                    .addComponent(CheckBillView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 334, Short.MAX_VALUE)
                    .addComponent(CashMethodView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 324, Short.MAX_VALUE)
                    .addComponent(CreditMethodView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(351, Short.MAX_VALUE)
                    .addComponent(UpdateCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
            .addComponent(ShopView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MyCartView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CheckBillView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CashMethodView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(CreditMethodView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UpdateCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddCartBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartBTNActionPerformed
        // TODO add your handling code here:
        AddToCart();
        
    }//GEN-LAST:event_AddCartBTNActionPerformed

    private void ShopBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopBTNMouseClicked
        // TODO add your handling code here:
        ShopView.setVisible(true);
        MyCartView.setVisible(false);
        CheckBillView.setVisible(false);
        CashMethodView.setVisible(false);
        CreditMethodView.setVisible(false);
        UpdateCart.setVisible(false);
        ShopBTN.setBackground(new java.awt.Color(255, 102, 255));
        CartBTN.setBackground(new java.awt.Color(102, 0, 102));
        PaymentBTN.setBackground(new java.awt.Color(102, 0, 102));
    }//GEN-LAST:event_ShopBTNMouseClicked

    private void CartBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartBTNMouseClicked
        // TODO add your handling code here:
        ShopView.setVisible(false);
        MyCartView.setVisible(true);
        CheckBillView.setVisible(false);
        CashMethodView.setVisible(false);
        CreditMethodView.setVisible(false);
        UpdateCart.setVisible(false);
        ShopBTN.setBackground(new java.awt.Color(102, 0, 102));
        CartBTN.setBackground(new java.awt.Color(255, 102, 255));
        PaymentBTN.setBackground(new java.awt.Color(102, 0, 102));
    }//GEN-LAST:event_CartBTNMouseClicked

    private void PaymentBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentBTNMouseClicked
        // TODO add your handling code here:
        double sum=0;
        jLabel20.setVisible(false);
        ShopView.setVisible(false);
        MyCartView.setVisible(false);
        CheckBillView.setVisible(false);
        CashMethodView.setVisible(true);
        CreditMethodView.setVisible(false);
        UpdateCart.setVisible(false);
        ShopBTN.setBackground(new java.awt.Color(102, 0, 102));
        CartBTN.setBackground(new java.awt.Color(102, 0, 102));
        PaymentBTN.setBackground(new java.awt.Color(255, 102, 255));
        jTextField2.setEditable(false);
        jTextField4.setEditable(false);
        for(int i=0; i<CartTable.getRowCount();i++){
            sum += Double.parseDouble(CartTable.getValueAt(i, 3).toString())*Double.parseDouble(CartTable.getValueAt(i, 2).toString());
        }
        jTextField2.setText(Double.toString(sum));
    }//GEN-LAST:event_PaymentBTNMouseClicked

    private void ExitBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBTNMouseClicked
        // TODO add your handling code here:
        new GUIView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitBTNMouseClicked

    private void CalBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBTNActionPerformed
        double a = Double.parseDouble(jTextField3.getText());
        double b = Double.parseDouble(jTextField2.getText());
        String su2  = String.format("%.2f", a-b);
        if(b>a){
            jLabel20.setVisible(true);
        }
        else{
             jTextField4.setText(su2);
             ShopView.setVisible(false);
            MyCartView.setVisible(false);
            CheckBillView.setVisible(false);
            CashMethodView.setVisible(false);
            CreditMethodView.setVisible(false);
            UpdateCart.setVisible(false);
            CheckBillView.setVisible(true);
        }     
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDataBase", "myJDB", "myJDB01");
//            String query = "SELECT * FROM product";
//            Statement st= con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StoreView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StoreView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_CalBTNActionPerformed

    private void CalBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBTN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalBTN1ActionPerformed

    private void CashPayBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashPayBTNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CashPayBTNMouseClicked

    private void RegisterBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterBTNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterBTNMouseClicked

    private void CashPayBTNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashPayBTNMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_CashPayBTNMouseMoved

    private void CashPayBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashPayBTNMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CashPayBTNMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDataBase", "myJDB", "myJDB01");
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select name from PRODUCT");
            jComboBox1.removeAllItems();
            while(rs.next()){
                String name = rs.getString("name");
                jComboBox1.addItem(name);
            }
            con.close();
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_formWindowActivated

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        ShopView.setVisible(false);
        MyCartView.setVisible(true);
        CheckBillView.setVisible(false);
        CashMethodView.setVisible(false);
        CreditMethodView.setVisible(false);
        UpdateCart.setVisible(false);
        int row1 = CartTable.getSelectedRow();
        ArrayList<MyProduct> list = productList();
        DefaultTableModel model = (DefaultTableModel)CartTable.getModel();
        String key = model.getValueAt(row1, 0).toString();
        Object[] row = new Object[4];
        int count=0;
        for(int i=0; i<list.size(); i++) {
            if(key.equals(list.get(i).getName())){
                row[0]=list.get(i).getName();
                row[1]=list.get(i).getType();
                row[2]=list.get(i).getPrice();
                row[3]=Integer.parseInt(jTextField1.getText());    
                for(int o=0; o<CartTable.getRowCount();o++){
                        System.out.println("koufor");
                        if(CartTable.getValueAt(o, 0).toString().equals(key)){
                            System.out.println("if");
                            if(Integer.parseInt(jTextField12.getText())>list.get(i).getQuantity()){
                                System.out.println("ranout");
                            }
                            else if(jTextField12.getText().equals("0")){
                                model.removeRow(row1);
                                System.out.println("");
                            }
                            else {
                                CartTable.setValueAt(Integer.parseInt(jTextField12.getText()),row1,3);
//                                count=1;
                                System.out.println("empty");
                            }
//                            CartTable.setValueAt(Integer.parseInt(CartTable.getValueAt(i, 3).toString())+Integer.parseInt(jTextField1.getText()),i,3);
//                            System.out.println("succ");
                        }
                        
                    }
            }
            
            System.out.println("Update Success");
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void EditProductBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductBTN1ActionPerformed
        int row = CartTable.getSelectedRow();
         if(row==-1) {
            JOptionPane.showMessageDialog(null, "Please select row", "NO ROW SELECTED", 0);
        }else{
            ShopView.setVisible(false);
            MyCartView.setVisible(false);
            CheckBillView.setVisible(false);
            CashMethodView.setVisible(false);
            CreditMethodView.setVisible(false);
            UpdateCart.setVisible(true);
            DefaultTableModel model = (DefaultTableModel)CartTable.getModel();
            jTextField10.setText(model.getValueAt(row, 0).toString());
            jTextField10.setEditable(false);
            jTextField11.setText(model.getValueAt(row, 1).toString());
            jTextField11.setEditable(false);
            jTextField9.setText(model.getValueAt(row, 2).toString());
            jTextField9.setEditable(false);
            jTextField12.setText(model.getValueAt(row, 3).toString());
         }
    }//GEN-LAST:event_EditProductBTN1ActionPerformed

    private void OkeyBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkeyBTNActionPerformed
        ArrayList<MyProduct> list = productList();
        String sname = "";
        double sprice = 0;
        String stype = "";
        int squantity = 0;
        try{
            for(int i = 0;i< CartTable.getRowCount();i++){
                String key = (String) CartTable.getValueAt(i,0);
                sname = (String) CartTable.getValueAt(i,0);
                double test1 = (double) CartTable.getValueAt(i,2);
                sprice = test1;
                stype = (String) CartTable.getValueAt(i,1);
                int test2 = (int) CartTable.getValueAt(i,3);
                for(int o = 0;o < list.size();o++){
                    int Qu =list.get(o).getQuantity();
                    String Na = list.get(o).getName();
                    if(Na.equals(key)){
                        squantity = Qu - test2;
                    }
                }
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/myDataBase", "myJDB", "myJDB01");
                String query = "DELETE FROM product where name = ?";
                PreparedStatement prepstmt = con.prepareStatement(query);
                prepstmt.setString(1, key);
                prepstmt.executeUpdate();

                String query2 = "insert into PRODUCT(name, type, price, quantity) VALUES (?, ?, ?, ?)";
                PreparedStatement prepstmt2 = con.prepareStatement(query2);
                prepstmt2.setString(1, sname);
                prepstmt2.setString(2, stype);
                prepstmt2.setDouble(3, sprice);
                prepstmt2.setInt(4, squantity);

                prepstmt2.execute();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        this.dispose();
        new GUIView().setVisible(true);
    }//GEN-LAST:event_OkeyBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StoreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCartBTN;
    private javax.swing.JButton CalBTN;
    private javax.swing.JButton CalBTN1;
    private javax.swing.JPanel CartBTN;
    private javax.swing.JTable CartTable;
    private javax.swing.JPanel CashMethodView;
    private javax.swing.JPanel CashPayBTN;
    private javax.swing.JPanel CheckBillView;
    private javax.swing.JPanel CreditMethodView;
    private javax.swing.JButton EditProductBTN1;
    private javax.swing.JPanel ExitBTN;
    private javax.swing.JPanel MyCartView;
    private javax.swing.JButton OkeyBTN;
    private javax.swing.JPanel PaymentBTN;
    private javax.swing.JLabel RegisterBTN;
    private javax.swing.JPanel ShopBTN;
    private javax.swing.JPanel ShopView;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JPanel UpdateCart;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
