
import java.io.*;
import java.util.*;


public class HuffmanCompressionRunner {

    private File originalFile;

    public HuffmanCompressionRunner(File file){
        this.originalFile = file;
    }

    public void compression(){
        try {
            // Fix the file type later (make more general)
            File compressedFile = new File("compressed.txt");
            FileOutputStream fos = new FileOutputStream(compressedFile);
            OutputStream writer = new BufferedOutputStream(fos);
            Huffman h = new Huffman(originalFile);
            h.run();
            Map<Character, String> encodings = h.getEncodings();
            // Bytes to Concatenated String, then call strToBytes

            String content = "";
            for (Byte b : h.getFileBytes()){
                content += encodings.get((char) (int) b);
            }
            System.out.println();
            writer.write(content.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound!");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IOException due to writing with FileOutputStream!");
            e.printStackTrace();
        }
    }

    public void decompression(){

    }

}
