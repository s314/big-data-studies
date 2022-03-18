public class Client {
  boolean status = true;
  int balance = 0;
  int number;

  public Bill bill = new Bill();

  public Client(int number) {
    this.number = number;
  }

  public void SwitchStatus() {
    status = !status;
  }

  public void SetNumber(int number) {
    this.number = number;
  }

  public void Pay(int amount) {
    balance += amount;
  }

  public int GetBalance() {
    return balance;
  }

  public boolean CheckPayment() {
    boolean result = true;
    if (balance >= bill.sum) {
      balance -= bill.sum;
    } else {
      result = false;
    } 

    status = result;
    return result;
  }
}
