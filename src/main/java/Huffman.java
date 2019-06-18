
import java.io.*;
import java.util.*;

public class Huffman {

    private Map<Character, Integer> frequencies;
    private FileMetadata fm;
    private byte[] bytes;
    private PriorityQueue<Node> minHeap;


    Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.frequency - o2.frequency;
        }
    };

    public class Node{
        private char character;
        private int frequency;
        public Node(char c, int f){
            this.character = c;
            this.frequency = f;
        }

        public void toStringOutput(){
            System.out.println("Node: " + character + ", Frequency: " + frequency);
        }
    }

    public Huffman(){

        this.frequencies = new HashMap<>();
        File file = new File("abcdef.txt");
        this.fm = new FileMetadata(file);
        this.bytes = fm.getBytes();
        this.minHeap = new PriorityQueue<>(comparator);


    }



    public void buildFrequenciesAndMinHeap() {

        for (Byte b : bytes){
            char c = (char)(int) b;
            if (frequencies.get(c) == null){
                frequencies.put(c, 1);
            }
            else {
                frequencies.put(c,frequencies.get(c) + 1);
            }
        }

        for (Character ch : frequencies.keySet()){
            Node node = new Node(ch, frequencies.get(ch));
            minHeap.add(node);
        }
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

    public PriorityQueue<Node> getMinHeap(){
        return minHeap;
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
        h.buildFrequenciesAndMinHeap();

    }

}
