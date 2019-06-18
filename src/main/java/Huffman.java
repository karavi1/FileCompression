
import java.io.*;
import java.nio.*;
import java.util.*;

public class Huffman {

    Map<Character, Integer> frequencies;

    public Huffman(){

        frequencies = new HashMap<>();
        File file = new File("abcdef.txt");
        FileMetadata fm = new FileMetadata(file);

    }

    public static void main (String [] args){
        Huffman h = new Huffman();

    }

}
