import com.fazecast.jSerialComm.*;
import java.util.*;
import java.io.*;

public class PortRead 
{

public static SerialPort userPort;
static InputStream in;
String  mesg = "S";
public PortRead(){
       Settings st = new Settings();
      Scanner input = new Scanner(System.in);

    /*
     * This returns an array of commport addresses, not useful for the client 
     * but useful for iterating through to get an actual list of com parts available 
     */

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
            byte[] buffer = null;
            byte[] newData = new byte[userPort.bytesAvailable()];
            int numRead = userPort.readBytes(newData, newData.length);
          //  int numWrite;
           // numWrite = userPort.writeBytes(buffer, mesg);
           String res = new String(newData);
           String res2 = String.valueOf(numRead);
           System.out.print(res);
          // System.out.println(res2);
          // st.STORED_IN_EXCEL(res);
        }
    });

    

}
public static void main(String args[]) 
{   
    PortRead pr = new PortRead();
    Settings st = new Settings(); 
    
}
}
