
import java.io.*;
import java.nio.file.Files;

public class FileIO {

    private File file;
    private byte[] bytes;

    public FileIO(File file){

        this.file = file;
        bytes = fileToBytes(file);

    }

    public byte[] fileToBytes(File file){
        byte[] byteArray;
        try{
            byteArray = Files.readAllBytes(file.toPath());

        } catch (Exception e){
            e.printStackTrace();
            byteArray = null;
        }
        return byteArray;
    }


    public void serialize(){

    }

}
