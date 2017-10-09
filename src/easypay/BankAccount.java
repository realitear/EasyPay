package easypay;

public class BankAccount 
{
    double balance;
    double interest;
    String accountName;
    
    
    void deposit (double inAmount)
    {
        balance = balance + inAmount;
    }
    
    void withdraw (double outAmount)
    {
        if( balance >= outAmount)
        {
            balance  = balance - outAmount;
        }
        else
        {
            System.out.println("not enough");
        }
    } 
    
    double getBalance()
    {
        return balance;
    }
          
    void setBalance(double myBal)
    {
        balance = myBal;
    }
    
    void transfer(double myTran, BankAccount myXX)
    {
        balance = balance - myTran;
        myXX.deposit(myTran);
    }
}
