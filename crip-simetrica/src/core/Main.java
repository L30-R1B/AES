package core;

import text.TextEncoding;
import text.TextDecoding;
import utils.FileManipulation;

public class Main {
    public static final byte [][] KEY = {
        {(byte) 0x01, (byte) 0xb2, (byte) 0x04, (byte) 0x36},
        {(byte) 0xc2, (byte) 0x56, (byte) 0xa0, (byte) 0x10},
        {(byte) 0x3b, (byte) 0x03, (byte) 0x01, (byte) 0x01},
        {(byte) 0x35, (byte) 0x2f, (byte) 0xb2, (byte) 0x10}
    };

    public static void main(String[] args) throws Exception {
        FileManipulation.deleteFileIfExists("saida.txt");
        FileManipulation.deleteFileIfExists("entradaD.txt");

        TextEncoding.textEncoding("entrada.txt", "saida.txt", KEY);
        TextDecoding.textDecoding("saida.txt", "entradaD.txt", KEY);
    }
}