package Multithreading;

class SBIBank{

    private int accoundbalance=5000;

    public synchronized  void getTheAccountBalance(){
        System.out.println("The Account Balance is : => "+accoundbalance);
    }

    public synchronized void withdraw(int amt){
        if(amt<=accoundbalance){
            accoundbalance-=amt;
            System.out.println("You amt is been Withdrawn Successfully");
        }else{
            System.out.println("Insufficient Account Balance");
        }
    }

    public synchronized  void deposit(int amt){
        accoundbalance+=amt;
        System.out.println("Your amt is been Successfully Deposited into Account");
    }
}

class PhonePe implements Runnable{

    SBIBank bank;
    int amt;

    PhonePe(SBIBank bank){
       this.bank=bank;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
        bank.withdraw(amt);
    }
}

class GPay implements  Runnable{
    SBIBank bank;
    int amt;

    GPay(SBIBank bank){
        this.bank=bank;
    }


    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
        bank.withdraw(amt);
    }
}

class BHIM implements  Runnable{
    SBIBank bank;
    int amt;

    BHIM(SBIBank bank){
        this.bank=bank;
    }


    public void setAmt(int amt) {
        this.amt = amt;
    }

    @Override
    public void run() {
       bank.getTheAccountBalance();
    }
}


public class ObjectLevelLocking {


    public static void main(String[] args) {
        SBIBank bank1=new SBIBank();

        PhonePe p =new PhonePe(bank1);
        GPay g =new GPay(bank1);
        BHIM b =new BHIM(bank1);

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
