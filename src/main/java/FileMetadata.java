import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;
public class FileMetadata {

    private File file;
    private byte[] bytes;
    private long originalLength;
    private long compressedLength;


    public FileMetadata(File file) {

        this.file = file;
        bytes = fileToBytes();
        originalLength = file.length();

    }

    public byte[] fileToBytes() {
        byte[] byteArray;
        try {
            byteArray = Files.readAllBytes(this.file.toPath());
        } catch (Exception e) {
            e.printStackTrace();
            byteArray = null;
        }
        return byteArray;
    }



    public void writeCompressedFile(File file){
        try {
            FileOutputStream fos = new FileOutputStream(file);

            Huffman h = new Huffman();
            h.run();
            Map <Character, String> encodings = h.getEncodings();
            // Bytes to Concatenated String, then call strToBytes

            String content = "";
            for (Byte b : h.getFileBytes()){
                content += encodings.get((char) (int) b);
            }
            fos.write(content.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound!");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("IOException due to writing with FileOutputStream!");
        }
    }



    public byte[] getBytes(){
        return bytes;
    }

    public File getFile(){
        return file;
    }
}
