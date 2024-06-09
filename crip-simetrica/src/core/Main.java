package core;
import utils.Matrix;

public class Main {

    public static void main(String[] args) throws Exception {
        byte [] block = {(byte) 0x32, (byte) 0x88, (byte) 0x31, (byte) 0xe0, (byte) 0x43, (byte) 0x5a, (byte) 0x31, (byte) 0x37, (byte) 0xf6, (byte) 0x30, (byte) 0x98, (byte) 0x07, (byte) 0xa8, (byte) 0x8d, (byte) 0xa2, (byte) 0x34};
        byte [][][] blocks = new byte[1][4][4];
        blocks[0] = Matrix.matrixInit(block);

        Crypt.criptBlocks(blocks);
    }
}