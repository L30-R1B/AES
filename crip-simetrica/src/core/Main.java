package core;

import org.w3c.dom.Text;
import text.TextEncoding;
import text.TextDecoding;
import utils.FileManipulation;
import utils.BlocksConvert;

public class Main {
    public static final byte [][] KEY = {
        {(byte) 0x01, (byte) 0xb2, (byte) 0x04, (byte) 0x36},
        {(byte) 0xc2, (byte) 0x56, (byte) 0xa0, (byte) 0x10},
        {(byte) 0x3b, (byte) 0x03, (byte) 0x01, (byte) 0x01},
        {(byte) 0x35, (byte) 0x2f, (byte) 0xb2, (byte) 0x10}
    };

    public static void main(String[] args) throws Exception {
        if (args.length != 5) {
            System.out.println("Número de argumentos inválidos ! ! !");
            return;
        }
    
        String command = args[0];
        String fileName = args[2];
        byte[][] key = BlocksConvert.blockConverter(args[1]);
    
        boolean result = false;
    
        switch (command) {
            case "CRIPT":
                result = TextEncoding.textEncoding(fileName, args[3], key);
                break;
            case "DCRIP":
                result = TextDecoding.textDecoding(fileName, args[3], key);
                break;
            default:
                System.out.println("Comando inválido");
                return;
        }
    
        if (args[4].equals("n") && !result) {
            FileManipulation.deleteFileIfExists(fileName);
        }
    }
    
}