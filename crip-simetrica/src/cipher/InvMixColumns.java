package cipher;
import utils.GaloisMultiplication;

public class InvMixColumns {    
    public static void invMixColumns(byte[][] bloco) {
        byte[] tempColumn = new byte[4];
        for (int c = 0; c < 4; c++) {
            tempColumn[0] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x0E, bloco[0][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0B, bloco[1][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0D, bloco[2][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x09, bloco[3][c]));
    
            tempColumn[1] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x09, bloco[0][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0E, bloco[1][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0B, bloco[2][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0D, bloco[3][c]));
    
            tempColumn[2] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x0D, bloco[0][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x09, bloco[1][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0E, bloco[2][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0B, bloco[3][c]));
    
            tempColumn[3] = (byte) (GaloisMultiplication.galoisMultiplication((byte) 0x0B, bloco[0][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0D, bloco[1][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x09, bloco[2][c]) ^
                                    GaloisMultiplication.galoisMultiplication((byte) 0x0E, bloco[3][c]));
    
            for (int i = 0; i < 4; i++) {
                bloco[i][c] = tempColumn[i];
            }
        }
    }
    
}
