import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;
public class FileMetadata {

    private File file;
    private byte[] bytes;

    public FileMetadata(File file) {

        this.file = file;
        bytes = fileToBytes();

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

    public byte[] getBytes(){
        return bytes;
    }

    public File getFile(){
        return file;
    }

}
