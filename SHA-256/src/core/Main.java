package core;
import cipher.SubBytes;
import utils.Matrix;

public class Main {

    public static void main(String[] args) throws Exception {
        


        byte [] vetor = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        byte [][] bloco = Matrix.matrixInit(vetor);

        Matrix.printMatrix(bloco);

        SubBytes.SBoxSubBytesSwap(bloco);

        Matrix.printMatrix(bloco);
    }
}
