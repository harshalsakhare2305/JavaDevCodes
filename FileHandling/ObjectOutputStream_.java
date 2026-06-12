package FileHandling;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Using the DataIO Stream we can store the primitive type field by field but what if we have store the whole object of 10 field
 * Storing each object field by field is not simple
 * So here is solution is using ObjectIO stream along serializable interface
 * Serialization means Converting the object into the byte
 * and deserialization means bytes to Object
 *
 *  Seriazable is marker interface with no method it simply tell the JVM this class is allowed for serilization
 * **/

class Student implements Serializable {

    String name;
    int age;
    int markspercentage;
    String username;
    transient String pass;  // transient fields are not saved in the file they are skiped
    // also static field as well because the they class member not the object memeber


    public Student(String name, int age, int markspercentage, String username, String pass) {
        this.name = name;
        this.age = age;
        this.markspercentage = markspercentage;
        this.username = username;
        this.pass = pass;
    }
}
public class ObjectOutputStream_ {


    public static void main(String[] args) {

        try(ObjectOutputStream oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("output.txt")))){

            Student s1 =new Student("Harshal",22,99,"sss","dd");

            oos.writeObject(s1);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
