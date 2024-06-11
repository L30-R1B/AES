package utils;

public class BlocksConvert {

    private static String adjustStringLength(String str, int length, char paddingChar) {
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < length) {
            sb.append(paddingChar);
        }
        if (sb.length() > length) {
            sb.setLength(length);
        }
        return sb.toString();
    }

    public static byte [][][] blocksConverter(String text){
        int len = text.length();
        int numBlocks = len / 16;
        if(len % 16 != 0){
            numBlocks ++;
        }

        byte [][][] blocks = new byte[numBlocks][4][4];
        int blocoAtual = 0;
        int indice;
        String subText;

        for(indice = 0; indice < len - 16; indice += 16){
            subText = text.substring(indice, indice + 16);
            blocks[blocoAtual] = blockConverter(subText);
            blocoAtual ++;
        }

        if(len % 16 != 0){
            subText = text.substring(indice, len);
            blocks[blocoAtual] = blockConverter(subText);
        }

        return blocks;
    }

    public static byte [][] blockConverter(String blockStr){

        String blockStrLenAdjust = adjustStringLength(blockStr, 16, '\0');
        byte [] arrayBytes = blockStrLenAdjust.getBytes();
        return Matrix.matrixInit(arrayBytes);
    }
}
