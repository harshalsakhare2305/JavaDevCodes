package FileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferOutputStream_ {
    public static void main(String[] args) {

        try (BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("output.txt"))){

            for(int i=0;i<10;i++){
                bos.write(("Line "+ i + "\n").getBytes());

            }
/*
  Output:
            Line 0
            Line 1
            Line 2
            Line 3
            Line 4
            Line 5
            Line 6
            Line 7
            Line 8
            Line 9
*/

            // Internally it stored as

            /*
            * L ->76
            * i -> 106
            * n -> 110
            * e -> 101 ...
            *
            * All are single byte valuees
            * */

            System.out.println("File is successfully written by bos");

            // This method will close the stream and also flushes the data from internal buffer to disk
            // bos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
