
import java.io.*;
import java.util.*;

public class Huffman {

    private Map<Character, Integer> frequencies;
    private FileMetadata fm;
    private byte[] bytes;
    private PriorityQueue<Node> minHeap;
    private Node root;
    private Map<Character, String> encodings;

    Comparator<Node> comparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.frequency - o2.frequency;
        }
    };

    public class Node{
        private char character;
        private int frequency;
        private Node left;
        private Node right;
        public Node(char c, int f){
            this.character = c;
            this.frequency = f;
        }

        public void toStringOutput(){
            System.out.println("Node: " + character + ", Frequency: " + frequency);
        }
    }

    public Huffman(File file){

        this.frequencies = new HashMap<>();
        this.fm = new FileMetadata(file);
        this.bytes = fm.getBytes();
        this.minHeap = new PriorityQueue<>(comparator);
        this.encodings = new HashMap<>();

    }

    public void buildFrequenciesAndMinHeap() {

        for (Byte b : bytes){
            char c = (char)(int) b;
            if (frequencies.containsKey(c)){
                frequencies.put(c,frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }
        for (Character ch : frequencies.keySet()){
            Node node = new Node(ch, frequencies.get(ch));
            minHeap.add(node);
        }
    }

    public void buildHuffmanTree(){
        while (!minHeap.isEmpty()){
            Node first = minHeap.poll();
            Node second = minHeap.poll();
            if (second != null) {
                Node internal = new Node('\u0000', first.frequency + second.frequency);
                internal.left = first;
                internal.right = second;
                root = internal;
                minHeap.add(internal);
            }
        }
    }

    public void buildEncodings(Node current, String prefix){
        if (current.left == null && current.right == null && current.character != '\u0000'){
            encodings.put(current.character, prefix);
        }
        else{
            buildEncodings(current.left, prefix + "0");
            buildEncodings(current.right, prefix + "1");
        }
    }

    public void run(){
        buildFrequenciesAndMinHeap();
        buildHuffmanTree();
        buildEncodings(root, "");
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

    public Map<Character, String> getEncodings() {
        return encodings;
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
        File file = new File("abcdef.txt");

        Huffman h = new Huffman(file);
        h.run();
        for (Character c : h.encodings.keySet()){
            System.out.println("Character: " + c + ", Frequency: " + h.frequencies.get(c) + ", Encoding: " + h.encodings.get(c));
        }
    }

}
