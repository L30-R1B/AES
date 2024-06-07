package cipher;

public class MixColumns {
    public final byte[][] MIX_COLUMNS_MATRIX = {
        {(byte)0x02, (byte)0x03, (byte)0x01, (byte)0x01},
        {(byte)0x01, (byte)0x02, (byte)0x03, (byte)0x01},
        {(byte)0x01, (byte)0x01, (byte)0x02, (byte)0x03},
        {(byte)0x03, (byte)0x01, (byte)0x01, (byte)0x02}
    };
    public static void mixColumns(byte [][] bloco){
        
    }
}
