package cipher;
import utils.GaloisMultiplication;

public class MixColumns {

    public static void mixColumns(byte[][] bloco) {
        byte[] tempColumn = new byte[4];
        for (int c = 0; c < 4; c++) {
            tempColumn[0] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x02, bloco[0][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x03, bloco[1][c]) ^
                                    bloco[2][c] ^
                                    bloco[3][c]);

            tempColumn[1] = (byte) (bloco[0][c] ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x02, bloco[1][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x03, bloco[2][c]) ^
                                    bloco[3][c]);

            tempColumn[2] = (byte) (bloco[0][c] ^
                                    bloco[1][c] ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x02, bloco[2][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x03, bloco[3][c]));

            tempColumn[3] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x03, bloco[0][c]) ^
                                    bloco[1][c] ^
                                    bloco[2][c] ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x02, bloco[3][c]));

            for (int i = 0; i < 4; i++) {
                bloco[i][c] = tempColumn[i];
            }
        }
    }
}
