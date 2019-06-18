import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
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

//    public char[] fileToChars(){
//        FileInputStream fis = new FileInputStream()
//    }



    public byte[] getBytes(){
        return bytes;
    }

    public File getFile(){
        return file;
    }
}
