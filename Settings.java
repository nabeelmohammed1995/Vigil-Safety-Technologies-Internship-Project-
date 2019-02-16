
import com.sun.prism.paint.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import jssc.*;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.net.*;
import javax.comm.SerialPortEvent;
import javax.swing.JFileChooser;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;





/**
 *
 * @author Nabeel Mohammed Asim Khan
 */
public class Settings extends javax.swing.JFrame {

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        setTitle("Vigil Safety Site");
         getContentPane().preferredSize();
        //getContentPane().setPreferredSize(new Dimension(500,500));
      //  getContentPane().setBackground(java.awt.Color.PINK);
       // jPanel1.setBackground(java.awt.Color.getHSBColor(255, 204, 204));
        setResizable(false);
        LABEL_CONNECT();
        MAC_ADDRESS();
    }

    public void LABEL_CONNECT(){
    SerialPort serialPort = new SerialPort("COM3");
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            if(serialPort.getPortName().equals("COM3")){
            String s ="USB: CONNECTED";
            CONNECTION_STATUS.setText(s);}
            else {System.out.println("usb not connected");}
            serialPort.closePort();
        } catch (SerialPortException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
            System.out.println(portNames[i]);
        } */
    }
    
    public void MAC_ADDRESS(){
        // MAC Address of the GUI Application Host
        InetAddress ip;
        try{
        ip = InetAddress.getLocalHost();
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        byte[] mac = network.getHardwareAddress();
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
		}
		jLabel16.setText("MAC Address:"+sb.toString());
        }catch (UnknownHostException e) {

		e.printStackTrace();

	} catch (SocketException e){

		e.printStackTrace();

	}
    }
    
    public void STORED_IN_EXCEL(String data){
    String DATA = data;
    System.out.print(DATA);
    
    File myf = new File("C:\\Users\\mohammed\\Desktop\\TEST.csv");// A new file "TEST" is created
        FileWriter writer; // To store the data from the system into the "TEST" file
        try {
            writer = new FileWriter(myf, true);
            writer.write(DATA); // Data from the system is stored in the "TEST" file
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    JOptionPane.showMessageDialog(rootPane, "TEST file has been created!");
    
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton3 = new javax.swing.JRadioButton();
        Config_File_ButtonGroup = new javax.swing.ButtonGroup();
        DOWNLOAD_ERASE_BUTTONGROUP = new javax.swing.ButtonGroup();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        SET_SYSTEM_NAME = new javax.swing.JButton();
        SET_DATE_BUTTON = new javax.swing.JButton();
        SET_TIME_BUTTON = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        DOWNLOAD_ERASE_BTN = new javax.swing.JButton();
        CONFIG_FILE_BUTTON = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        SET_SYSTEM_ID = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        REFRESH = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        CONNECTION_STATUS = new javax.swing.JLabel();
        CURRENT_DATE = new javax.swing.JLabel();
        CURRENT_TIME = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jRadioButton3.setText("jRadioButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 239, 234));
        jPanel1.setPreferredSize(new java.awt.Dimension(439, 705));

        SET_SYSTEM_NAME.setBackground(new java.awt.Color(204, 204, 204));
        SET_SYSTEM_NAME.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        SET_SYSTEM_NAME.setText("Set");
        SET_SYSTEM_NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET_SYSTEM_NAMEActionPerformed(evt);
            }
        });

        SET_DATE_BUTTON.setBackground(new java.awt.Color(204, 204, 204));
        SET_DATE_BUTTON.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        SET_DATE_BUTTON.setText("Set");
        SET_DATE_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET_DATE_BUTTONActionPerformed(evt);
            }
        });

        SET_TIME_BUTTON.setBackground(new java.awt.Color(204, 204, 204));
        SET_TIME_BUTTON.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        SET_TIME_BUTTON.setText("Set");
        SET_TIME_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET_TIME_BUTTONActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton4.setText("Set");

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton5.setText("Set");

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton6.setText("Set");

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton7.setText("Set");

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton8.setText("Set");

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton9.setText("Set");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel2.setText("Set System Time :");

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton10.setText("Set");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel4.setText("Set NTags :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel10.setText("Set Gain(Range) :");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Level 8", "Level 7", "Level 6", "Level 5", "Level 4", "Level 3", "Level 2", "Level 1" }));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel11.setText("On Board Gain Switch :");

        jRadioButton1.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton1.setText("Enable");

        jRadioButton2.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton2.setText("Disable");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel1.setText("Set System name:");

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField3.setText("Enter New System Name");
        jTextField3.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel3.setText("Set System Date :");

        jTextField15.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField16.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField17.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField18.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField19.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField20.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField21.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField2.setText("Enter Tag ID");

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField5.setText("Enter Tag ID");

        jTextField22.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField23.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField24.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField6.setText("Enter Tag ID");

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField7.setText("Enter Tag ID");

        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField8.setText("Enter Tag ID");

        jTextField12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField12.setText("Enter Current New Password");

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton11.setText("Set");

        DOWNLOAD_ERASE_BTN.setBackground(new java.awt.Color(204, 204, 204));
        DOWNLOAD_ERASE_BTN.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        DOWNLOAD_ERASE_BTN.setText("OK");
        DOWNLOAD_ERASE_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOWNLOAD_ERASE_BTNActionPerformed(evt);
            }
        });

        CONFIG_FILE_BUTTON.setBackground(new java.awt.Color(204, 204, 204));
        CONFIG_FILE_BUTTON.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        CONFIG_FILE_BUTTON.setText("OK");
        CONFIG_FILE_BUTTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONFIG_FILE_BUTTONActionPerformed(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField13.setText("Enter New Password");

        jTextField14.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField14.setText("Confirm New Password");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel12.setText("Set Mode :");

        jRadioButton4.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton4.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton4.setText("Auto");

        jButton14.setBackground(new java.awt.Color(204, 204, 204));
        jButton14.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton14.setText("OK");

        jButton15.setBackground(new java.awt.Color(204, 204, 204));
        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton15.setText("EXIT");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jRadioButton5.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton5.setText("Manual");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel13.setText("Data Log :");

        jRadioButton6.setBackground(new java.awt.Color(255, 239, 234));
        DOWNLOAD_ERASE_BUTTONGROUP.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton6.setText("Erase");

        jRadioButton7.setBackground(new java.awt.Color(255, 239, 234));
        DOWNLOAD_ERASE_BUTTONGROUP.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton7.setText("Download");

        jRadioButton8.setBackground(new java.awt.Color(255, 239, 234));
        DOWNLOAD_ERASE_BUTTONGROUP.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton8.setText("Download and Erase");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel14.setText("Config File :");

        jRadioButton9.setBackground(new java.awt.Color(255, 239, 234));
        Config_File_ButtonGroup.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton9.setText("Load");

        jRadioButton10.setBackground(new java.awt.Color(255, 239, 234));
        Config_File_ButtonGroup.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton10.setText("Create");

        jTextField25.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField26.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField27.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        SET_SYSTEM_ID.setBackground(new java.awt.Color(204, 204, 204));
        SET_SYSTEM_ID.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        SET_SYSTEM_ID.setText("Set");
        SET_SYSTEM_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SET_SYSTEM_IDActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel5.setLabelFor(jTextField9);
        jLabel5.setText("    Set System ID:");

        jButton17.setBackground(new java.awt.Color(204, 204, 204));
        jButton17.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton17.setText("Set");

        jTextField9.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField9.setText("Enter SYSID");

        jButton18.setBackground(new java.awt.Color(204, 204, 204));
        jButton18.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton18.setText("Set");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel6.setText("Set Bluetooth ID :");

        jButton19.setBackground(new java.awt.Color(204, 204, 204));
        jButton19.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jButton19.setText("Set");

        jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField10.setText("Enter BTID");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel7.setText("Enable/Disable BT :");

        jRadioButton11.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton11.setText("Enable ");

        jRadioButton12.setBackground(new java.awt.Color(255, 239, 234));
        jRadioButton12.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jRadioButton12.setText("Disable");

        jTextField28.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField29.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField30.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jTextField31.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel8.setText("Set BT Pin :");

        REFRESH.setBackground(new java.awt.Color(204, 204, 204));
        REFRESH.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        REFRESH.setText("REFRESH");
        REFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REFRESHActionPerformed(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jTextField11.setText("Enter BT Pin");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jLabel9.setText("     Change Password : ");

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CONNECTION_STATUS.setText("Jlabel0");

        CURRENT_DATE.setText("Jlabel1");

        CURRENT_TIME.setText("Jlabel2");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton8)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                .addComponent(jTextField1))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jRadioButton1)
                                                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRadioButton2)
                                                    .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton7))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton9)
                                                .addGap(8, 8, 8)
                                                .addComponent(jRadioButton10))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(REFRESH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(CONFIG_FILE_BUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DOWNLOAD_ERASE_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(SET_SYSTEM_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(SET_TIME_BUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(SET_DATE_BUTTON, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                            .addComponent(SET_SYSTEM_NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 16, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField27, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextField28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jRadioButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(CONNECTION_STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CURRENT_DATE)))
                                .addGap(37, 37, 37)
                                .addComponent(CURRENT_TIME)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SET_SYSTEM_NAME)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SET_DATE_BUTTON))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SET_TIME_BUTTON)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButton7)
                    .addComponent(DOWNLOAD_ERASE_BTN)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jRadioButton8)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton9)
                    .addComponent(jRadioButton10)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CONFIG_FILE_BUTTON)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SET_SYSTEM_ID)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton12)
                    .addComponent(jButton18)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(REFRESH)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CONNECTION_STATUS)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CURRENT_DATE)
                        .addComponent(CURRENT_TIME)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(35, 35, 35))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SET_DATE_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET_DATE_BUTTONActionPerformed
        // Set Date Manually
        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String d = sdf.format(jDateChooser1.getDate());
        CURRENT_DATE.setText(d); 
        jTextField16.setText(d);
        // Set Date Automatically
       /*  DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        if(SET_DATE_BUTTON.isEnabled()){
        CURRENT_DATE.setText(df.format(dateobj));} */ 
       
    }//GEN-LAST:event_SET_DATE_BUTTONActionPerformed

    private void SET_TIME_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET_TIME_BUTTONActionPerformed
        // Set Time
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date dateobj = new Date();
        jTextField1.setText(df.format(dateobj));
        String s = jTextField1.getText();
        jTextField17.setText(s);  
        CURRENT_TIME.setText(df.format(dateobj.getTime()));


        
    }//GEN-LAST:event_SET_TIME_BUTTONActionPerformed

    private void REFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REFRESHActionPerformed
        // REFRESH THE GUI LABELS
        SYSTEM_ID();
    }//GEN-LAST:event_REFRESHActionPerformed

    private void CONFIG_FILE_BUTTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONFIG_FILE_BUTTONActionPerformed
        // Creating an excel file if the "create" button is chosen
        String keep="";
        if(jRadioButton10.isSelected()){
         File myfile = new File(System.getProperty("user.home"), "Desktop\\excel.xls");
      String s = CURRENT_DATE.getText();
      String p = CURRENT_TIME.getText();
        try {
            WritableWorkbook excelfile = Workbook.createWorkbook(myfile);
            WritableSheet mysheet= excelfile.createSheet("mysheet", 0);
            Label l = new Label(0 ,0 ,"SYSTEM NAME");
            Label l2= new Label(1, 0, s);
            Label l3= new Label(2, 0, p);
            mysheet.addCell(l);
            mysheet.addCell(l2);
            mysheet.addCell(l3);
            excelfile.write();
            excelfile.close();
            // FILE CHOOSER
         JFileChooser fc = new JFileChooser();
         fc.setCurrentDirectory(new java.io.File(System.getProperty("user.home"), "Desktop"));
         fc.setDialogTitle("Vigil Safety Site");
         fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         if(fc.showOpenDialog(CONFIG_FILE_BUTTON)== JFileChooser.APPROVE_OPTION)
         {
           File selectedFile = fc.getSelectedFile();
           java.awt.Desktop.getDesktop().open(selectedFile);
           
         } 
        } catch (IOException | WriteException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
        }
        
        //Load the file
        
        
    }//GEN-LAST:event_CONFIG_FILE_BUTTONActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // EXIT THE GUI APPLICATION
        System.exit(0);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void SET_SYSTEM_NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET_SYSTEM_NAMEActionPerformed
        // Set System Name
        String s = jTextField3.getText();
        jTextField15.setText(s);
    }//GEN-LAST:event_SET_SYSTEM_NAMEActionPerformed

    private void SET_SYSTEM_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SET_SYSTEM_IDActionPerformed
        // Set System ID
       
        String s = jTextField9.getText();
        jTextField28.setText(s); 
        
        String stt = "VD-0202";
        byte[] SYS_ID = stt.getBytes();
       Integer crs = calculate_crc(SYS_ID);
        
    }//GEN-LAST:event_SET_SYSTEM_IDActionPerformed

     public  int calculate_crc( byte[] bytes) {
         char i = 0;
         int crc_value = 0;
         for (int len = 0; len < bytes.length; len++) {
        for (i = 0x80; i != 0; i >>= 1) {
            if ((crc_value & 0x8000) != 0) {
                crc_value = (crc_value << 1) ^ 0x8005;
            } else {
                crc_value = crc_value << 1;
            }
            if ((bytes[len]&i)!=0) {
                crc_value ^= 0x8005;
            } 
        }
    }
       
         return (crc_value) ;
}
   
     
    private void DOWNLOAD_ERASE_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOWNLOAD_ERASE_BTNActionPerformed
        // Downloading and erasing the data log
        //If Download Option is selected
        if(jRadioButton7.isSelected()){
      /*   byte[] buffer=null; // To get the data from the system
         SerialPort serialPort = new SerialPort("COM3");
         String dataStream=null;
       
           
        try {
            System.out.println("Port open" + serialPort.openPort()); // opens the port COM3
            serialPort.setParams(9600, 8, 1, 0); // Set the params like bondrate for COM3
            buffer = serialPort.readBytes(200); // Reads the no. of bytes sent by the board
            dataStream = new String(buffer); // to store the bytes in the form of strings
            System.out.println(dataStream); //  to display the bytes in "Output" 
            System.out.println( serialPort.closePort());
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
        /*
        File myf = new File("C:\\Users\\mohammed\\Desktop\\TEST.csv");// A new file "TEST" is created
        FileWriter writer; // To store the data from the system into the "TEST" file
        try {
            writer = new FileWriter(myf, true);
            writer.write(dataStream); // Data from the system is stored in the "TEST" file
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        PortRead poo = new PortRead();
        
        } 
        
           
        //If Erase Option is selected
        if(jRadioButton6.isSelected()){
            Test2 t2 = new Test2();
            
            
        }
        
        
        
        
    }//GEN-LAST:event_DOWNLOAD_ERASE_BTNActionPerformed
    public void SYSTEM_ID(){
        String p = jTextField28.getText();
        jLabel15.setText(p);
    }
   
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CONFIG_FILE_BUTTON;
    public javax.swing.JLabel CONNECTION_STATUS;
    private javax.swing.JLabel CURRENT_DATE;
    private javax.swing.JLabel CURRENT_TIME;
    private javax.swing.ButtonGroup Config_File_ButtonGroup;
    private javax.swing.JButton DOWNLOAD_ERASE_BTN;
    private javax.swing.ButtonGroup DOWNLOAD_ERASE_BUTTONGROUP;
    private javax.swing.JButton REFRESH;
    private javax.swing.JButton SET_DATE_BUTTON;
    private javax.swing.JButton SET_SYSTEM_ID;
    private javax.swing.JButton SET_SYSTEM_NAME;
    private javax.swing.JButton SET_TIME_BUTTON;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
