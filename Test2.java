


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mohammed
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
public class Test2 extends javax.swing.JFrame {

    /**
     * Creates new form Test2
     */
    public Test2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        PORT_DETECT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setForeground(new java.awt.Color(204, 51, 255));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        PORT_DETECT.setText("LIST_PORTS");
        PORT_DETECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PORT_DETECTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PORT_DETECT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(PORT_DETECT)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      /* String s = jTextField1.getText();
       jTextField2.setText(s); */
            byte[] buffer = null;
            byte[] oppai = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x0B,(byte)0x04,(byte)0x56,(byte)0x57,(byte)0x49,(byte)0x44,(byte)0x42,(byte)0x45,(byte)0x2D,(byte)0x33,(byte)0x33,(byte)0x30,(byte)0x34,(byte)0xC2,(byte)0x13};
            SerialPort serialPort = new SerialPort("COM3");
            String mesg="E";
            String dataStream=null;
            
            
        try {
            System.out.println("Port open" + serialPort.openPort()); // opens the port COM3
            serialPort.setParams(9600, 8, 1, 0); // Set the params like bondrate for COM3
           // buffer = serialPort.readBytes(oppai); // Reads the no. of bytes sent by the board
            dataStream = new String(buffer); // to store the bytes in the form of strings
            System.out.println(dataStream); //  to display the bytes in "Output" 
            jTextField1.setText(dataStream);// to store bytes in form of text
           // serialPort.writeBytes(mesg.getBytes());// send bytes to arduino
            serialPort.writeBytes(oppai);
          //  serialPort.closePort();
            serialPort.closePort();            
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        } 
      
      
     /* File myfile = new File("C:\\Users\\mohammed\\Desktop\\excel.xls");
      String s = jTextField1.getText();
        try {
            WritableWorkbook excelfile = Workbook.createWorkbook(myfile);
            WritableSheet mysheet= excelfile.createSheet("mysheet", 0);
            Label l = new Label(0 ,0 ,"SYSTEM NAME");
            Label l2= new Label(1, 0, "SYSTEM ID");
            Label l3= new Label(2, 0, "TAG ID");
            Label l4=new Label(3, 0,dataStream);
            mysheet.addCell(l);
            mysheet.addCell(l2);
            mysheet.addCell(l3);
            excelfile.write();
            excelfile.close();
        } catch (IOException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        } */
      /*    
       File myf = new File("C:\\Users\\mohammed\\Desktop\\TEST.csv");
        FileWriter writer;
        try {
            writer = new FileWriter(myf, true);
            writer.write(dataStream);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);
        }
          */  
    
    
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void PORT_DETECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PORT_DETECTActionPerformed
         // To detect how many ports are connected to the computer
      String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
            System.out.println(portNames[i]);
        } 
        
        
    }//GEN-LAST:event_PORT_DETECTActionPerformed

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
            java.util.logging.Logger.getLogger(Test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PORT_DETECT;
    private javax.swing.JButton jButton1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}