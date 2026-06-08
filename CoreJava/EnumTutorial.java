package CoreJava;



enum Result{

   /**
    * used to represent a fixed set of constants.
    * enum is actually a class we can define method in the enum as well
    * Interview Question: Can Enum Have Constructors? -> Yes But the constructor is always private (implicitly). You cannot create enum objects using new.
    * Interview Question: Can Enum Extend a Class? -> ❌ No Because every enum already extends Java's built-in Enum class.
    *
    *
    *
    * **/

    PASS,FAIL;
    // Background representation
    // public static final Result PASS =new Result();
    // public static final Result FAIL=new Result();

   private int mark;
    Result(){
        System.out.println("This is the constructor of the result class");
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Result{" +
                "mark=" + mark +
                '}';
    }
}

enum Day{
    MONDAY(1),
    TUE(2);

    private int value;

    Day(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}

public class EnumTutorial {

    public static void main(String[] args) {

        Day day =Day.MONDAY;
        System.out.println(day.getValue());

       Result result =Result.PASS;
       result.setMark(40);
  //      System.out.println(result.getMark());
    //    System.out.println(result.ordinal()); // used to get the index of the constant in the group of enum

        Result[] resuarr=Result.values();
        System.out.println(resuarr.length);


        Result result1 =Result.FAIL;



         resuarr=Result.values();
        System.out.println(resuarr.length);



        System.out.println(result1.getMark());
    }
}
