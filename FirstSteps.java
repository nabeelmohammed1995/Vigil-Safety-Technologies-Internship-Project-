import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Formatter;

public class FirstSteps
{
public FirstSteps()
{
    super();
}

void connect ( String portName ) throws Exception
{
    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
    if ( portIdentifier.isCurrentlyOwned() )
    {
        System.out.println("Error: Port is currently in use");
    }
    else
    {
        System.out.println("Connect 1/2");
        CommPort commPort = portIdentifier.open(this.getClass().getName(),6000);

        if ( commPort instanceof SerialPort )
        {
            System.out.println("Connect 2/2");
            SerialPort serialPort = (SerialPort) commPort;
            System.out.println("BaudRate: " + serialPort.getBaudRate());
            System.out.println("DataBIts: " + serialPort.getDataBits());
            System.out.println("StopBits: " + serialPort.getStopBits());
            System.out.println("Parity: " + serialPort.getParity());
            System.out.println("FlowControl: " + serialPort.getFlowControlMode());
            serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_ODD);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            System.out.println("BaudRate: " + serialPort.getBaudRate());
            System.out.println("DataBIts: " + serialPort.getDataBits());
            System.out.println("StopBits: " + serialPort.getStopBits());
            System.out.println("Parity: " + serialPort.getParity());
            System.out.println("FlowControl: " + serialPort.getFlowControlMode());
            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();

            (new Thread(new SerialReader(in))).start();
            (new Thread(new SerialWriter(out))).start();

        }
        else
        {
            System.out.println("Error: Only serial ports are handled by this example.");
        }
    }     
}

/** */
public static class SerialReader implements Runnable 
{
    InputStream in;

    public SerialReader ( InputStream in )
    {
        this.in = in;
    }

    public void run ()
    {
        byte[] buffer = new byte[1024];
        int len = -1;
        String s;
        
        try
        {
             while( ( len = this.in.read(buffer)) > -1 )
            {
                //System.out.println("Received a signal.");
               // System.out.print(new String(buffer,0,len));
               // s = new String(buffer,0,len);
              //String HEX =DatatypeConverter.printHexBinary(buffer);
               //System.out.println(HEX);
               
                StringBuilder sb = new StringBuilder(buffer.length * 2);
 
    Formatter formatter = new Formatter(sb);
    for (byte b : buffer) {
        formatter.format("%02x", b);
    }
                System.out.println (sb.toString());
            } 
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }            
    }
}

/** */
public static class SerialWriter implements Runnable 
{
    OutputStream out;

    public SerialWriter ( OutputStream out )
    {
        this.out = out;
    }

    public void run ()
    {
        try
        {                
          // byte[] array= new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x0B,(byte)0x04,(byte)0x56,(byte)0x49,(byte)0x44,(byte)0x42,(byte)0x45,(byte)0x2D,(byte)0x33,(byte)0x33,(byte)0x30,(byte)0x34,(byte)0xC2,(byte)0x13};
            
         //  byte[] array= {(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x05,(byte)0x86,(byte)0x1D};
          //byte[] array = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x0b,(byte)0x04,(byte)0x56,(byte)0x57,(byte)0x49,(byte)0x44,(byte)0x56,(byte)0x57,(byte)0x44,(byte)0x2d,(byte)0x33,(byte)0x33,(byte)0x30,(byte)0x34,(byte)0xdf,(byte)0xd6};
         //  byte[] gain_range = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x0d,(byte)0x11,(byte)0x00,(byte)0x00,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x05,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x32,(byte)0xa6};
          //  byte[] get_range = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x12,(byte)0x86,(byte)0x6f};
           byte[] event_log = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x80,(byte)0x05,(byte)0x00};
           // byte[] event_log_info = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x02,(byte)0x81,(byte)0x30,(byte)0x86,(byte)0x81};
           // byte[] byte2 = new byte[]{(byte)0x55,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x82,(byte)0x85,(byte)0x0f};
            while ( true )
            {
              this.out.write(event_log);
              //Thread.sleep(10000);
              this.out.flush();
               Thread.sleep(1000);  
            }                
        }
        catch ( IOException | InterruptedException e )
        {
            e.printStackTrace();
        }            
    }
}

public static void main ( String[] args )
{
    try
    {
        (new FirstSteps()).connect("COM3");
    }
    catch ( Exception e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}