package FileHandling;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OutputStreamWrite_ {
    public static void main(String[] args) {

        try(OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream("output.txt"),StandardCharsets.UTF_8)) {

            osw.write("नमस्कार");


        }catch (Exception e){

        }


    }
}
