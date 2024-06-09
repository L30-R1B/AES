package cipher;

public class ShiftRows {
    private static void swap(byte[] array, int i, int j) {
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void shiftRows(byte [][]bloco){
        swap(bloco[1], 0, 1);
        swap(bloco[1], 1, 2);
        swap(bloco[1], 2, 3);

        swap(bloco[2], 0, 2);
        swap(bloco[2], 1, 3);

        swap(bloco[3], 0, 1);
        swap(bloco[3], 0, 2);
        swap(bloco[3], 0, 3);
    }
}
