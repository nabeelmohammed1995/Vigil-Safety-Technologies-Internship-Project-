
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.InputStream;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nabeel Mohammed Asim Khan
 */
public class PortErase {
    public static SerialPort userPort;
    static InputStream in;
    int i;
    String mesg = "S";
    
    public PortErase(){
    Scanner input = new Scanner(System.in);
    
    SerialPort ports[] = SerialPort.getCommPorts();
    int i = 1;

    //User port selection
    System.out.println("COM Ports available on machine");
    for(SerialPort port : ports) //iterator to pass through port array
    {
        System.out.println(i++ + ": " + port.getSystemPortName()); //print windows COM ports
    }
    System.out.println("Please select COM PORT: 'COM#'");
    SerialPort userPort = SerialPort.getCommPort(input.nextLine());

    //Initializing port 
    userPort.openPort();
    if(userPort.isOpen())
    {
        System.out.println("Port initialized!"); 
        //timeout not needed for event based reading

        //userPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
    }
    else
    {
        System.out.println("Port not available");
        return;
    }
    
    userPort.addDataListener(new SerialPortDataListener(){
        @Override
        public int getListeningEvents(){return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;}
        
        public void serialEvent(SerialPortEvent event)
        {
            if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
            return;
          /* byte[] newData = new byte[userPort.bytesAvailable()];
           int numRead = userPort.readBytes(newData, newData.length);  
           String res = new String(newData);
           System.out.print(res); */
          byte[] removeData = new byte[userPort.bytesAvailable()];
          byte[] storage = new byte[removeData.length];
          removeData= null; 
        /* for(byte boo: removeData ){
             
         } 
         removeData = storage; */
         
         // String res = new String(removeData);
          //System.out.println(res);
        
        }
    });
    
    
    }
    public static void main(String[] args) {
        PortErase erase = new PortErase();
        
    }
    
}
