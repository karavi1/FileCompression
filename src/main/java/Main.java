import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;

public class Main {


    public static void main (String [] args){
        Huffman h = new Huffman(new File("abcdef.txt"));
        h.run();
        for (Character c : h.getEncodings().keySet()){
            System.out.println("Character: " + c + ", Frequency: " + h.getFrequencies().get(c) + ", Encoding: " + h.getEncodings().get(c));
        }
        
    }
}
