package utils;

public class GaloisMultiplication {
    public static byte galoisMultiplication(byte a, byte b) {
        byte p = 0;
        byte hiBitSet;
        for (int counter = 0; counter < 8; counter++) {
            if ((b & 1) != 0) {
                p ^= a;
            }
            hiBitSet = (byte) (a & 0x80);
            a <<= 1;
            if (hiBitSet != 0) {
                a ^= 0x1B;
            }
            b >>= 1;
        }
        return p;
    }
}
