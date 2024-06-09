package core;
import cipher.AddRoundKey;
import cipher.InvMixColumns;
import cipher.InvShiftRows;
import cipher.InvSubBytes;
import utils.Matrix;
import utils.RoundKeyGenerate;

public class Dcrypt {

    static byte [][] key = {
        {(byte) 0x2b, (byte) 0x28, (byte) 0xab, (byte) 0x09},
        {(byte) 0x7e, (byte) 0xae, (byte) 0xf7, (byte) 0xcf},
        {(byte) 0x15, (byte) 0xd2, (byte) 0x15, (byte) 0x4f},
        {(byte) 0x16, (byte) 0xa6, (byte) 0x88, (byte) 0x3c},
    };

    public static void dcriptBlocks(byte [][][] blocks){
        byte [][][] keysRound = new byte[11][4][4];

        keysRound[0] = key;
        keysRound[1] = RoundKeyGenerate.roundKeyGenerate(keysRound[0], (byte) 0);
        keysRound[2] = RoundKeyGenerate.roundKeyGenerate(keysRound[1], (byte) 1);
        keysRound[3] = RoundKeyGenerate.roundKeyGenerate(keysRound[2], (byte) 2);
        keysRound[4] = RoundKeyGenerate.roundKeyGenerate(keysRound[3], (byte) 3);
        keysRound[5] = RoundKeyGenerate.roundKeyGenerate(keysRound[4], (byte) 4);
        keysRound[6] = RoundKeyGenerate.roundKeyGenerate(keysRound[5], (byte) 5);
        keysRound[7] = RoundKeyGenerate.roundKeyGenerate(keysRound[6], (byte) 6);
        keysRound[8] = RoundKeyGenerate.roundKeyGenerate(keysRound[7], (byte) 7);
        keysRound[9] = RoundKeyGenerate.roundKeyGenerate(keysRound[8], (byte) 8);
        keysRound[10] = RoundKeyGenerate.roundKeyGenerate(keysRound[9], (byte) 9);

        byte [][] blockCrypt;
        
        for(byte [][] block: blocks){
            blockCrypt = dcryptBlock(block, keysRound);
            Matrix.printMatrix(blockCrypt);
        }

    }

    public static byte [][] dcryptBlock(byte [][] matrix, byte [][][] keysRound){
        
        AddRoundKey.addRoundKey(matrix, keysRound[10]);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[9]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[8]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[7]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[6]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[5]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[4]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[3]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[2]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);

        AddRoundKey.addRoundKey(matrix, keysRound[1]);
        InvMixColumns.invMixColumns(matrix);
        InvShiftRows.invShiftRows(matrix);
        InvSubBytes.invSubBytes(matrix);
        
        AddRoundKey.addRoundKey(matrix, keysRound[0]);

        return matrix;
    }
}
