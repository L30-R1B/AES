package cipher;

public class MixColumns {
    public final byte[][] MIX_COLUMNS_MATRIX = {
        {(byte)0x02, (byte)0x03, (byte)0x01, (byte)0x01},
        {(byte)0x01, (byte)0x02, (byte)0x03, (byte)0x01},
        {(byte)0x01, (byte)0x01, (byte)0x02, (byte)0x03},
        {(byte)0x03, (byte)0x01, (byte)0x01, (byte)0x02}
    };
    private static byte galoisMultiplication(byte a, byte b) {
        byte p = 0;
        byte hiBitSet;
        for (int counter = 0; counter < 8; counter++) {
            if ((b & 1) != 0) {
                p ^= a;
            }
            hiBitSet = (byte) (a & 0x80);
            a <<= 1;
            if (hiBitSet != 0) {
                a ^= 0x1B;
            }
            b >>= 1;
        }
        return p;
    }
    public static void mixColumns(byte[][] bloco) {
        byte[] tempColumn = new byte[4];
        for (int c = 0; c < 4; c++) {
            tempColumn[0] = (byte) (galoisMultiplication((byte) 0x02, bloco[0][c]) ^
                                    galoisMultiplication((byte) 0x03, bloco[1][c]) ^
                                    bloco[2][c] ^
                                    bloco[3][c]);

            tempColumn[1] = (byte) (bloco[0][c] ^
                                    galoisMultiplication((byte) 0x02, bloco[1][c]) ^
                                    galoisMultiplication((byte) 0x03, bloco[2][c]) ^
                                    bloco[3][c]);

            tempColumn[2] = (byte) (bloco[0][c] ^
                                    bloco[1][c] ^
                                    galoisMultiplication((byte) 0x02, bloco[2][c]) ^
                                    galoisMultiplication((byte) 0x03, bloco[3][c]));

            tempColumn[3] = (byte) (galoisMultiplication((byte) 0x03, bloco[0][c]) ^
                                    bloco[1][c] ^
                                    bloco[2][c] ^
                                    galoisMultiplication((byte) 0x02, bloco[3][c]));

            for (int i = 0; i < 4; i++) {
                bloco[i][c] = tempColumn[i];
            }
        }
    }
}
