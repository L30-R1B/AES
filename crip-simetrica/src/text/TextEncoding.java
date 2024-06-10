package text;

import core.Crypt;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import utils.BlocksConvert;
import utils.FileManipulation;
import utils.RoundKeyGenerate;

public class TextEncoding {

    public static void textEncoding(String initFile, String destFile, byte [][] key){
        String [] arqInitLines = FileManipulation.readFileAsLines(initFile);
        if(arqInitLines == null){
            return;
        }

        byte [][][] keysRound = RoundKeyGenerate.roundKeyGenerate(key);

        for(String line : arqInitLines){
            byte [][][] blocks = BlocksConvert.blocksConverter(line);
            byte [][][] blocksCript = Crypt.criptBlocks(blocks, keysRound);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(destFile, true))) {
                FileManipulation.writeByteMatrixToFile(blocksCript, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
