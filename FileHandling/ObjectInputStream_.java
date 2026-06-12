package FileHandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) {
        try(ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream("output.txt")))){

            Student st =(Student) ois.readObject();

            System.out.println(st.name);
            System.out.println(st.age);
            System.out.println(st.markspercentage);
            System.out.println(st.username);
            System.out.println(st.pass);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
