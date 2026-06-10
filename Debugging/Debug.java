package Debugging;

public class Debug {
    public static void main(String[] args) {
        System.out.println("This is the Entry point of the Main Thread");


        int a=20;
        int b=3;

        for(int i=0;i<3;i++){
            System.out.println("This is the Statement number : "+i+1);
        }

        int sum=a+b;
         sum*=sum;

        System.out.println("The Sum is now : "+sum);

        System.out.println("Here is the End of Main thread");
    }
}
