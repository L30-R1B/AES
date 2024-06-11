package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManipulation {

    public static void deleteFileIfExists(String filePath) {
        File file = new File(filePath);

        if (file.exists()) { // Verifica se o arquivo existe
            if (file.delete()) { // Exclui o arquivo
                System.out.println("Arquivo excluído com sucesso: " + filePath);
            } else {
                System.err.println("Falha ao excluir o arquivo: " + filePath);
            }
        } else {
            System.out.println("O arquivo não existe: " + filePath);
        }
    }

    public static void appendStringsToFile(String[] data, BufferedWriter writer) {
        try {
            int len = data.length;
            for (int i = 0; i < len - 1; i ++) {
                writer.write(data[i]);
            }
            for(int i = 0; i < 16; i ++){
                char c = data[len - 1].charAt(i);
                if (c != '\0') {
                    writer.write(c);
                }
            }
        } catch (IOException e) {
        }
    }
    

    public static byte[][][] readMatricesFromFile(BufferedReader reader) {
        List<byte[][]> matrices = new ArrayList<>();
        try {
            String line;
            List<byte[]> currentMatrix = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (!currentMatrix.isEmpty()) {
                        matrices.add(currentMatrix.toArray(new byte[4][4]));
                        currentMatrix.clear();
                    }
                } else {
                    String[] hexValues = line.split("\\s+");
                    byte[] row = new byte[4];
                    for (int i = 0; i < 4; i++) {
                        row[i] = (byte) Integer.parseInt(hexValues[i], 16);
                    }
                    currentMatrix.add(row);
                }
            }

            // Add the last matrix if there is no empty line at the end of the file
            if (!currentMatrix.isEmpty()) {
                matrices.add(currentMatrix.toArray(new byte[4][4]));
            }

        } catch (IOException e) {
        }

        return matrices.toArray(new byte[matrices.size()][4][4]);
    }
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

    public static String readFileAsString(BufferedReader reader) {
        StringBuilder content = new StringBuilder();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Adiciona uma nova linha após cada linha lida
            }
        } catch (IOException e) {
            return null;
        }

        return content.toString();
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
