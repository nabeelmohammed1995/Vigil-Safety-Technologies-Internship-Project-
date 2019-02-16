public class Crc_16 {
public static void main(String... a) {
    byte[] bytes = new byte[] {(byte)0x00,(byte)0x00,(byte)0x0b,(byte)0x04,(byte)0x56,(byte)0x57,(byte)0x49,(byte)0x44,(byte)0x56,(byte)0x57,(byte)0x44,(byte)0x2d,(byte)0x30,(byte)0x32,(byte)0x30,(byte)0x32};
    byte[] byteStr = new byte[4];
    Integer crcRes = new Crc_16().calculate_crc(bytes);
    System.out.println(Integer.toHexString(crcRes));

    byteStr[0] = (byte) ((crcRes & 0x000000ff));
    byteStr[1] = (byte) ((crcRes & 0x0000ff00) >>> 8);

    System.out.printf("%02X\n%02X", byteStr[0],byteStr[1]);
} 

int calculate_crc(byte[] bytes) {
    int i;
    int crc_value = 0;
    for (int len = 0; len < bytes.length; len++) {
        for (i = 0x80; i != 0; i >>= 1) {
            if ((crc_value & 0x8000) != 0) {
                crc_value = (crc_value << 1) ^ 0x8005;
            } else {
                crc_value = crc_value << 1;
            }
            if ((bytes[len] & i) != 0) {
                crc_value ^= 0x8005;
            }
        }
    }
    return crc_value;
}

}