

/**
 *
 * @author unknown
 */
public class CRC {
    
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

   @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        CRC  cc = new CRC();
       // Settings st = new Settings();
   
// byte[] bytes = new byte[]{(byte)0x00,(byte)0x00,(byte)0x0d,(byte)0x11,(byte)0x00,(byte)0x00,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x07,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};  
//byte[] bytes = new byte[]{(byte)0x00,(byte)0x00,(byte)0x0d,(byte)0x11,(byte)0x00,(byte)0x00,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x05,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
byte[] bytes= new byte[]{(byte)0x01,(byte)0x58};
String s = new String(bytes);
System.out.println(s);
Integer crcRes = cc.calculate_crc(bytes);
         System.out.println(Integer.toHexString(crcRes)); 
        
    }
    
}
