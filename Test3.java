
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import gnu.io.*; //RXTX LIBRARY 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author unknown
 */
public class Test3 implements Runnable, SerialPortEventListener{
    
static CommPortIdentifier portId;
static Enumeration portList;
InputStream inputStream;
SerialPort serialPort;
Thread readThread;
byte[] readBuffer;
    
        public Test3(){
         try {
        System.out.println("In SimpleRead() contructor");
        serialPort = (SerialPort) portId.open("SimpleReadApp1111",500);
        System.out.println(" Serial Port.. " + serialPort);
    } catch (PortInUseException e) {
        System.out.println("Port in use Exception");
    }
      try {
        inputStream = serialPort.getInputStream();
        System.out.println(" Input Stream... " + inputStream);
    } catch (IOException e) {
        System.out.println("IO Exception");
    }
      try {
        serialPort.addEventListener(this);

    } catch (TooManyListenersException e) {
        System.out.println("Tooo many Listener exception");
    }
       serialPort.notifyOnDataAvailable(true);     
      
       try {
        serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        // no handshaking or other flow control
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        // timer on any read of the serial port
        serialPort.enableReceiveTimeout(500);
    } catch (UnsupportedCommOperationException e) {
        System.out.println("UnSupported comm operation");
    }
    readThread = new Thread(this);
    readThread.start();     
       
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        portList = CommPortIdentifier.getPortIdentifiers();
        System.out.println(portList);
        while(portList.hasMoreElements()){
        portId = (CommPortIdentifier)portList.nextElement();
        if(portId.getPortType() == CommPortIdentifier.PORT_SERIAL){
            System.out.println(portId.getPortType());
        if(portId.getName().equals("COM3")){
        Test3 t = new Test3();
        }
        else {
                System.out.println("unable to open port");
            }
            
        }
        
    }
    }
        
       

    @Override
    public void run() {
 
    try {
        System.out.println("In run() function ");
        Thread.sleep(500);
        // System.out.println();
    } catch (InterruptedException e) {
        System.out.println("Interrupted Exception in run() method");
    }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        
        switch(spe.getEventType()){
            case SerialPortEvent.DATA_AVAILABLE: 
                    readBuffer = new byte[8];
            try {
            while(inputStream.available()>0){
            int numbytes = inputStream.read(readBuffer);
            System.out.println(new String(readBuffer));
            
            }
            
            
            } catch (IOException ex) {
            Logger.getLogger(Test3.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
        } 
    }
    
}
