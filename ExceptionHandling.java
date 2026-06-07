import java.util.Scanner;

class  B{
    void calc() throws ArithmeticException{
        System.out.println("Entered the the method calc");

        Scanner sc =new Scanner(System.in);

      try{
          System.out.println("Enter the numerator number : ");

          int num =sc.nextInt();

          System.out.println("Enter the denoinatio number : ");

          int deno =sc.nextInt();

          int result = num/deno;   //Getting exception at this line

          System.out.println("Result is : "+result);

      }catch (ArithmeticException e){
          System.out.println("Plz enter the non zero number for the denominator");
          throw e;
      }finally {
          System.out.println("Exit from calc from the class B");
      }

        System.out.println("Exit from the outside the finally block code");


//        System.out.println("Enter the numerator number : ");
//
//          int num =sc.nextInt();
//
//          System.out.println("Enter the denoinatio number : ");
//
//          int deno =sc.nextInt();
//
//          int result = num/deno;   //Getting exception at this line
//
//         System.out.println("Result is : "+result);

    }
}



public class ExceptionHandling {
    public static void main(String[] args) {
        B obj =new B();
        try{
            obj.calc();
        }catch (ArithmeticException e){
            System.out.println("Plz enter the non zero number for the Denominator");
        }
    }
}
