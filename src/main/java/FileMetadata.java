import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
public class FileMetadata {

    private File file;
    private byte[] bytes;
    private FileChannel fn;
    private FileInputStream fis;
    private long originalLength;
    private long compressedLength;


    public FileMetadata(File file) {

        try {
            this.file = file;
            bytes = fileToBytes(file);
            fis = new FileInputStream(file);
            originalLength = file.length();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public byte[] fileToBytes(File file) {
        byte[] byteArray;
        try {
            byteArray = Files.readAllBytes(file.toPath());
        } catch (Exception e) {
            e.printStackTrace();
            byteArray = null;
        }
        return byteArray;
    }

    public byte[] getBytes(){
        return bytes;
    }

    public File getFile(){
        return file;
    }
}
