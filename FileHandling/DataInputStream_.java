package FileHandling;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStream_ {

    public static void main(String[] args) {
        try(DataInputStream dis =new DataInputStream(new BufferedInputStream(new FileInputStream("output.txt")))){


            int x = dis.readInt();
            char c =dis.readChar();
            double y = dis.readDouble();
            boolean z = dis.readBoolean();

            System.out.println(x);
            System.out.println(c);
            System.out.println(y);
            System.out.println(z);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
