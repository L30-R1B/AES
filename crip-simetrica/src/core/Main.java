package core;
import utils.Matrix;

public class Main {

    public static void main(String[] args) throws Exception {
        byte [] block = {(byte) 0x39, (byte) 0x02, (byte) 0xdc, (byte) 0x19, (byte) 0x25, (byte) 0xdc, (byte) 0x11, (byte) 0x6a, (byte) 0x84, (byte) 0x89, (byte) 0x85, (byte) 0x0b, (byte) 0x1d, (byte) 0xfb, (byte) 0x97, (byte) 0x32};
        
        
        byte [][][] blocks = new byte[1][4][4];
        blocks[0] = Matrix.matrixInit(block);

        Matrix.printMatrix(blocks[0]);

        Crypt.criptBlocks(blocks);
    }
}