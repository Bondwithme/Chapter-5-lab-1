
//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************
public class Account
{
  private double balance;
  private String name;
  private int acctNum;
  private static int numOfAccts;
  private static int withdrawalNum;
  private static int depositNum;
  private static double totalWithdrawal;
  private static double totalDeposit;
  //----------------------------------------------
  //Constructor -- initializes balance, owner, and account number
  //----------------------------------------------
  public Account(double initBal, String owner, int number){
    balance = initBal;
    name = owner;
    acctNum = number;
    numOfAccts+=1;
  }
  //----------------------------------------------
  // Checks to see if balance is sufficient for withdrawal.
  // If so, decrements balance by amount; if not, prints message.
  //----------------------------------------------
  public void withdraw(double amount){
    if (balance >= amount) {
       balance -= amount;
       totalWithdrawal+=amount;
       withdrawalNum+=1;
    }
    else {
       System.out.println("Insufficient funds");
  }
}
  //----------------------------------------------
  // Adds deposit amount to balance.
  //----------------------------------------------
  public void deposit(double amount){
    balance += amount;
    totalDeposit+=amount;
    depositNum+=1;
  }
  //----------------------------------------------
  // Returns balance.
  //----------------------------------------------
  public double getBalance(){
    return balance;
  }
  
  public static int getNumAccounts() {
      return numOfAccts;
  }
  //----------------------------------------------
  // Returns a string containing the name, account number, and balance.
  //----------------------------------------------
  public String toString(){
      String statement= "";
      statement = "Name: " + this.name + "\tAccount Number: " + this.acctNum + "\tBalance: " + this.balance;
      return statement;
  }
  //----------------------------------------------
  // Deducts $10 service fee
  //----------------------------------------------
  public double chargeFee(){
      return this.balance -= 10;
  }
  //----------------------------------------------
  // Changes the name on the account
  //----------------------------------------------
  public void changeName(String newName) {
      this.name = newName;
  }
  public void close() {
      name = name + " CLOSED";
      balance = 0;
      numOfAccts-=1;
  }
  public static int getNumWithdrawals() {
      return withdrawalNum;
  }
  public static int getNumDeposit() {
      return depositNum;
    }
  public static double getTotalDeposit() {
      return totalDeposit;
    }
  public static double getTotalWithdrawal() {
      return totalWithdrawal;
  }
  public int getAcctNumber() {
      return acctNum;
  }
}