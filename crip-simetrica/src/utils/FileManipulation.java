package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManipulation {

    public static String[] readFileAsLines(BufferedReader reader) {
        List<String> lines = new ArrayList<>();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            return null;
        }

        return lines.toArray(new String[0]);
    }

    public static void writeByteMatrixToFile(byte[][][] data, BufferedWriter writer) {
        try {
            for (byte[][] matrix : data) {
                for (byte[] row : matrix) {
                    for (byte b : row) {
                        writer.write(String.format("%02x", b));
                        writer.write(" ");  
                    }
                    writer.newLine();  
                }
                writer.newLine();  
            }
        } catch (IOException e) {

        }
    }
}
