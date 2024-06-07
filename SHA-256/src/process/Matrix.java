package process;

public class Matrix {
    public static byte[][] matrixInit(byte [] vetor) {
        byte [][] bloco = {
            {vetor[0], vetor[1], vetor[2], vetor[3]},
            {vetor[4], vetor[5], vetor[6], vetor[7]},
            {vetor[8], vetor[9], vetor[10], vetor[11]},
            {vetor[12], vetor[13], vetor[14], vetor[15]},
        };
        return bloco;
    } 

    public static void printMatrix(byte [][] matriz) {
        System.out.println("-----------------------");
        for (byte[] row : matriz) {
            for (byte b : row) {
                System.out.printf("%02x ", b);
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }  
}
