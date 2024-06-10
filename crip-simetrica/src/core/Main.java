package core;
import utils.BlocksConvert;
import utils.Matrix;

public class Main {

    public static void main(String[] args) throws Exception {
        String text = "abcdee";

        byte [][][] blocks = BlocksConvert.blocksConverter(text);
    
        for(byte[][] block : blocks){
            Matrix.printMatrix(block);
        }
    }
}