package text;

import core.Crypt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import utils.BlocksConvert;
import utils.FileManipulation;
import utils.RoundKeyGenerate;

public class TextEncoding {

    public static void textEncoding(String initFile, String destFile, byte[][] key) {

        String arqInitLines;

        try (BufferedReader reader = new BufferedReader(new FileReader(initFile))) {
            arqInitLines = FileManipulation.readFileAsString(reader);
        } catch (IOException e) {
            System.out.println("ERRO");
            return;
        }

        System.out.print(arqInitLines);

        byte[][][] keysRound = RoundKeyGenerate.roundKeyGenerate(key);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destFile, true))) {
            byte[][][] blocks = BlocksConvert.blocksConverter(arqInitLines);
            byte[][][] blocksCript = Crypt.criptBlocks(blocks, keysRound);
            FileManipulation.writeByteMatrixToFile(blocksCript, writer);
        } catch (IOException e) {
        }
    }
}
