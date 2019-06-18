
import java.io.*;
import java.util.*;

public class Huffman {

    private Map<Character, Integer> frequencies;
    private FileMetadata fm;
    private byte[] bytes;

    public Huffman(){

        this.frequencies = new HashMap<>();
        File file = new File("abcdef.txt");
        this.fm = new FileMetadata(file);
        this.bytes = fm.getBytes();

    }

    public void buildFrequencies(){

    }

    public void buildMinHeap(){

    }

    public void buildHuffmanTree(){

    }

    public void buildEncodings(){

    }

    // Getters
    public Map<Character, Integer> getFrequencies(){
        return this.frequencies;
    }

    public FileMetadata getFileMetadata(){
        return this.fm;
    }

    public byte[] getFileBytes(){
        return this.bytes;
    }

    public File getFile(){
        return this.fm.getFile();
    }


    // Setters
    public void setFrequencies(Map<Character, Integer> newFrequencies){
        this.frequencies = newFrequencies;
    }

    public void setFileMetadata(FileMetadata newFm){
        this.fm = newFm;
    }

    public void setFileBytes(byte[] newBytes){
        this.bytes = newBytes;
    }


    // Main Method (temporary before writing tests)
    public static void main (String [] args){
        Huffman h = new Huffman();
    }

}
