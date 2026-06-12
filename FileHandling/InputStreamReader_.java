package FileHandling;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamReader_ {

    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("output.txt"), StandardCharsets.UTF_8)) {

            int byteValue;

            while((byteValue=isr.read())!=-1){
                System.out.print((char)byteValue);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
