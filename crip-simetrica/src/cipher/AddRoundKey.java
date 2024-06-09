package cipher;

public class AddRoundKey {
    public static void addRoundKey(byte [][] bloco, byte [][] roundKey){
        bloco[0][0] ^= roundKey[0][0];
        bloco[0][1] ^= roundKey[0][1];
        bloco[0][2] ^= roundKey[0][2];
        bloco[0][3] ^= roundKey[0][3];
        bloco[1][0] ^= roundKey[1][0];
        bloco[1][1] ^= roundKey[1][1];
        bloco[1][2] ^= roundKey[1][2];
        bloco[1][3] ^= roundKey[1][3];
        bloco[2][0] ^= roundKey[2][0];
        bloco[2][1] ^= roundKey[2][1];
        bloco[2][2] ^= roundKey[2][2];
        bloco[2][3] ^= roundKey[2][3];
        bloco[3][0] ^= roundKey[3][0];
        bloco[3][1] ^= roundKey[3][1];
        bloco[3][2] ^= roundKey[3][2];
        bloco[3][3] ^= roundKey[3][3];    
    }
}
