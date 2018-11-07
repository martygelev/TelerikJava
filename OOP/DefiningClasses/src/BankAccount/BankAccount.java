package BankAccount;
public class BankAccount {

    private int id;
    private double balance;

    public void setId (int id)
    {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void Deposit (double amount)
    {
        if (amount<0)
        {
            throw new IllegalArgumentException("Negative amount");
        }
        this.balance+=amount;
    }

    public void Withdraw (double amount)
    {
        if (amount>balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance-=amount;
    }

    @Override
    public String toString()
    {
        return  String.format("Account ID%s, balance %.2f",this.getId(), this.getBalance());
    }

}
