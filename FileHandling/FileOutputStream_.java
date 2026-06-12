package FileHandling;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStream_ {

    public static void main(String[] args) {

        try(FileOutputStream fos =new FileOutputStream("output.txt")){  // This is make the open system call to the os to open the file with truncate option
            // means all the previous data from the file is been trucated and new data is been added

            // if file exists -> content is deleted
            // file doesnot exist -> new file is created


            // To avoid the truncate we have the same method with diff constructor
           // FileOutputStream fos =new FileOutputStream("output.txt",true);

            fos.write(72); // H in ASCII
            fos.write('\n');



         String str ="Hello this is Harshal";

         byte[] bytes =str.getBytes();

         fos.write(bytes);

            System.out.println("Thee file is been written succesfully");



        }catch (Exception e){
            System.out.println(e.getMessage());
    }
//        finally {

         /*
         Make sure that you close the stream after the work done becuase
         * fos stream works with OS and OS donot directly write to the disk instead it also maintain one buffer (Kernel Buffer)
           so changes need to be flushed to the disk


         * Make stream unusable once it is closed it can be reused for any read orc write operation
         *
         * */


//            fos.close()
//        }
    }
}
