package core;
import cipher.AddRoundKey;
import cipher.MixColumns;
import cipher.ShiftRows;
import cipher.SubBytes;

public class Crypt {

    public static byte [][][] criptBlocks(byte [][][] blocks, byte [][][] keysRound){

        byte [][][] blocksCrypt = new byte[blocks.length][4][4];
        int indice = 0;

        for(byte [][] block: blocks){
            blocksCrypt[indice] = cryptBlock(block, keysRound);
            indice ++;
        }
        return blocksCrypt;
    }

    private static byte [][] cryptBlock(byte [][] matrix, byte [][][] keysRound){
        
        AddRoundKey.addRoundKey(matrix, keysRound[0]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[1]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[2]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[3]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[4]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[5]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[6]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[7]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[8]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        MixColumns.mixColumns(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[9]);

        SubBytes.subBytes(matrix);
        ShiftRows.shiftRows(matrix);
        AddRoundKey.addRoundKey(matrix, keysRound[10]);

        return matrix;
    }
}
