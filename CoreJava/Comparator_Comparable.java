package CoreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Cricketer implements Comparable<Cricketer>{
    int age;
    String name;
    Double avg;


    public Cricketer(int age, String name, Double avg) {
        this.age = age;
        this.name = name;
        this.avg = avg;
    }

    @Override
    public int compareTo(Cricketer o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", avg=" + avg +
                '}';
    }
}

class CrickerCompare implements Comparator<Cricketer>{
    @Override
    public int compare(Cricketer o1, Cricketer o2) {
        return Double.compare(o1.avg,o2.avg);
    }
}

public class Comparator_Comparable {

    public static void main(String[] args) {
        Cricketer c1 =new Cricketer(35,"Virat",88.8);
        Cricketer c2 =new Cricketer(44,"MS",78.56);
        Cricketer c3 =new Cricketer(36,"Rohit",78.89);

        ArrayList<Cricketer> list =new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
//        CrickerCompare c =new CrickerCompare();
//        Comparator c =new Comparator<Cricketer>() {
//            @Override
//            public int compare(Cricketer o1, Cricketer o2) {
//                return o1.age- o2.age;
//            }
//        };

//        Comparator<Cricketer> c =(Cricketer o1, Cricketer o2)-> {
//            return o1.age- o2.age;
//        };
        System.out.println(list);
//        Collections.sort(list,c);

        Collections.sort(list);
        System.out.println(list);
    }
}
