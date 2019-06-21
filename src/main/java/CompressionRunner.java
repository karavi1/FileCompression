import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class CompressionRunner {

    private File originalFile;

    public CompressionRunner(File file){
        this.originalFile = file;
    }

    public void compression(){
        try {
            // Fix the file type later (make more general)
            File compressedFile = new File("compressed.txt");
            FileOutputStream fos = new FileOutputStream(compressedFile);

            Huffman h = new Huffman(originalFile);
            h.run();
            Map<Character, String> encodings = h.getEncodings();
            // Bytes to Concatenated String, then call strToBytes

            String content = "";
            for (Byte b : h.getFileBytes()){
                content += encodings.get((char) (int) b);
            }
            System.out.println();
            fos.write(content.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound!");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IOException due to writing with FileOutputStream!");
        }
    }


    public static void main (String [] args){

        File abcde = new File("abcdef.txt");
        CompressionRunner cr = new CompressionRunner(abcde);
        cr.compression();
    }




}
