package core;
import cipher.AddRoundKey;
import cipher.InvMixColumns;
import cipher.InvShiftRows;
import cipher.InvSubBytes;

public class Dcrypt {

    public static byte [][][] dcriptBlocks(byte [][][] blocks, byte [][][] keysRound){

        byte [][][] blocksDcrypt = new byte[blocks.length][4][4];
        int indice = 0;
        
        for(byte [][] block: blocks){
            blocksDcrypt[indice] = dcryptBlock(block, keysRound);
            indice ++;
        }
        return blocksDcrypt;
    }

    private static byte [][] dcryptBlock(byte [][] matrix, byte [][][] keysRound){
        
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
