package FileHandling;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {

    public static void main(String[] args) throws IOException {
        System.out.println("Program Started....");

        System.out.println(System.getProperty("user.dir"));


        FileInputStream fis=null;

        try{
          fis =new FileInputStream("input.txt");  // JVM always searches the file in your current working directory
            // so check the current working direction before creating the file

            //  System.out.println(System.getProperty("user.dir"));


           int byteValue;   //returns byte value btw 0-255

           while((byteValue=fis.read())!=-1) {
               System.out.println((char) byteValue);
           }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {

            if(fis != null ){
                fis.close();
            }
        }
    }
}
