package FileHandling;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStream_ {
    /**
     * for primitive data type it handles the read/write for us
     *
     * **/

    public static void main(String[] args) {
        try(DataOutputStream dos =new DataOutputStream(new BufferedOutputStream(new FileOutputStream("output.txt")))){

            dos.writeInt(73);
            dos.writeChar('H');
            dos.writeDouble(88.88);
            dos.writeBoolean(true);



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
