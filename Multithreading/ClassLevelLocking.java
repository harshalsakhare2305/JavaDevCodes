package Multithreading;

class SBIBank1{

    private static int accoundbalance=5000;

    public static synchronized  void getTheAccountBalance(){
        System.out.println("The Account Balance is : => "+accoundbalance);
    }

    public static synchronized void withdraw(int amt){
        if(amt<=accoundbalance){
            accoundbalance-=amt;
            System.out.println("You amt is been Withdrawn Successfully");
        }else{
            System.out.println("Insufficient Account Balance");
        }
    }

    public static synchronized  void deposit(int amt){
        accoundbalance+=amt;
        System.out.println("Your amt is been Successfully Deposited into Account");
    }
}

class PhonePe1 implements Runnable{

    int amt;

    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
        SBIBank1.withdraw(amt);
    }
}

class GPay1 implements  Runnable{

     int amt;

    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
        SBIBank1.withdraw(amt);
    }
}

class BHIM1 implements  Runnable{
    int amt;


    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
        SBIBank1.getTheAccountBalance();
    }
}


public class ClassLevelLocking {


    public static void main(String[] args) {
        SBIBank1 bank1=new SBIBank1();

        PhonePe1 p =new PhonePe1();
        GPay1 g =new GPay1();
        BHIM1 b =new BHIM1();

        Thread phpe =new Thread(p);
        Thread gpay =new Thread(g);
        Thread bhim =new Thread(b);

        p.setAmt(4000);
        g.setAmt(4000);

        phpe.start();
        gpay.start();
        bhim.start();







    }
}
