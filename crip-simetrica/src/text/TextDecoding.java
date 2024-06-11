package text;

import core.Dcrypt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import utils.FileManipulation;
import utils.RoundKeyGenerate;

public class TextDecoding {
    private static String[] convertMatricesToStringArray(byte[][][] matrices) {
        String[] result = new String[matrices.length];

        for (int i = 0; i < matrices.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrices[i].length; j++) {
                for (int k = 0; k < matrices[i][j].length; k++) {
                    sb.append((char) matrices[i][j][k]);
                }
            }
            result[i] = sb.toString();
        }

        return result;
    }
    public static void textDecoding(String initFile, String destFile, byte [][] key){
        byte [][][] blocks;
        try(BufferedReader reader = new BufferedReader(new FileReader(initFile))){
            blocks = FileManipulation.readMatricesFromFile(reader);
        }catch(IOException e){
            System.out.println("Erro");
            return;
        }

        byte [][][] keysRound = RoundKeyGenerate.roundKeyGenerate(key);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destFile, true))) {
            byte [][][] blocksDcript = Dcrypt.dcriptBlocks(blocks, keysRound);
            String [] text = convertMatricesToStringArray(blocksDcript);
            FileManipulation.appendStringsToFile(text, writer);
            
        } catch (IOException e) {
        }
    }
}
