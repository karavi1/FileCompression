
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class FileIO {

    private File file;
    private byte[] bytes;
    private FileChannel fn;
    private FileInputStream fis;



    public FileIO(File file){

        try{
            this.file = file;
            bytes = fileToBytes(file);
            fis = new FileInputStream(file);
            fn = fis.getChannel();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
