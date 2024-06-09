package utils;
import cipher.SubBytes;

public class RoundKeyGenerate {

    public static final byte [][] RCON_MATRIX = {
        {(byte) 0x01, (byte) 0x02, (byte) 0x04, (byte) 0x08, (byte) 0x10, (byte) 0x20, (byte) 0x40, (byte) 0x80, (byte) 0x1b, (byte) 0x36},
        {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00},
        {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00},
        {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00}
    };

    public static byte[][] roundKeyGenerate(byte [][]roundKey, byte idRconMatrix){
        byte [][]newRoundKey = new byte[4][4];

        byte [] lastColumn = {
                            SubBytes.S_BOX_MATRIX[(roundKey[1][3] & 0xF0) >> 4][roundKey[1][3] & 0x0F],
                            SubBytes.S_BOX_MATRIX[(roundKey[2][3] & 0xF0) >> 4][roundKey[2][3] & 0x0F],
                            SubBytes.S_BOX_MATRIX[(roundKey[3][3] & 0xF0) >> 4][roundKey[3][3] & 0x0F],
                            SubBytes.S_BOX_MATRIX[(roundKey[0][3] & 0xF0) >> 4][roundKey[0][3] & 0x0F]
                            };

        newRoundKey[0][0] = (byte) (roundKey[0][0] ^ lastColumn[0] ^ RCON_MATRIX[0][idRconMatrix]);
        newRoundKey[1][0] = (byte) (roundKey[1][0] ^ lastColumn[1] ^ RCON_MATRIX[1][idRconMatrix]);
        newRoundKey[2][0] = (byte) (roundKey[2][0] ^ lastColumn[2] ^ RCON_MATRIX[2][idRconMatrix]);
        newRoundKey[3][0] = (byte) (roundKey[3][0] ^ lastColumn[3] ^ RCON_MATRIX[3][idRconMatrix]);

        newRoundKey[0][1] = (byte) (newRoundKey[0][0] ^ roundKey[0][1]);
        newRoundKey[1][1] = (byte) (newRoundKey[1][0] ^ roundKey[1][1]);
        newRoundKey[2][1] = (byte) (newRoundKey[2][0] ^ roundKey[2][1]);
        newRoundKey[3][1] = (byte) (newRoundKey[3][0] ^ roundKey[3][1]);
        
        newRoundKey[0][2] = (byte) (newRoundKey[0][1] ^ roundKey[0][2]);
        newRoundKey[1][2] = (byte) (newRoundKey[1][1] ^ roundKey[1][2]);
        newRoundKey[2][2] = (byte) (newRoundKey[2][1] ^ roundKey[2][2]);
        newRoundKey[3][2] = (byte) (newRoundKey[3][1] ^ roundKey[3][2]);

        newRoundKey[0][3] = (byte) (newRoundKey[0][2] ^ roundKey[0][3]);
        newRoundKey[1][3] = (byte) (newRoundKey[1][2] ^ roundKey[1][3]);
        newRoundKey[2][3] = (byte) (newRoundKey[2][2] ^ roundKey[2][3]);
        newRoundKey[3][3] = (byte) (newRoundKey[3][2] ^ roundKey[3][3]);

        return newRoundKey;
    }
}
