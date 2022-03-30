public class Phone {
  int id;
  String first_name, last_name, patronymic;
  String address;
  long card_number;
  double debit, credit;
  int intercity_calls, intracity_calls; // Междугородние звонки и внутригородские соотв.

  public int getId() {
    return id;
  }

  public String getLastName() {
    return last_name;
  }

  public String getFirstName() {
    return first_name;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public String getAddress() {
    return address;
  }

  public long getCardNumber() {
    return card_number;
  }

  public double getDebit() {
    return debit;
  }

  public double getCredit() {
    return credit;
  }

  public int getIntercityCalls() {
    return intercity_calls;
  }

  public int getIntracityCalls() {
    return intracity_calls;
  }

  public void setAddress(String address) throws Exception {
    checkStringCorrectness(address);
    this.address = address;
  }

  public void setCardNumber(long card_number) throws Exception {
    if (card_number == 0) throw new Exception("Card Number can't be zero");

    int length = (int) (Math.log10(card_number) + 1);
    if (length != 16) throw new Exception("Invalid card number format");

    this.card_number = card_number;
  }

  public void setCredit(double credit) {
    this.credit = credit;
  }

  public void setDebit(double debit) {
    this.debit = debit;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setIntercityCalls(int intercity_calls) {
    this.intercity_calls = intercity_calls;
  }

  public void setIntracityCalls(int intracity_calls) {
    this.intracity_calls = intracity_calls;
  }

  public void setLastName(String last_name) throws Exception {
    checkStringCorrectness(last_name);
    this.last_name = last_name;
  }

  public void setFirstName(String name) throws Exception {
    checkStringCorrectness(name);
    this.first_name = name;
  }

  public void setPatronymic(String patronymic) throws Exception {
    checkStringCorrectness(patronymic);
    this.patronymic = patronymic;
  }

  @Override
  public String toString() {
    String result = "{ " +
      "ID: " + this.id + "\n" +
      "Last Name: " + this.last_name + "\n" +
      "First Name: " + this.first_name + "\n" +
      "Patronymic: " + this.patronymic + "\n" +
      "Address: " + this.address + "\n" +
      "Card Number: " + this.card_number + "\n" +
      "Debit: " + this.debit + "\n" +
      "Credit: " + this.credit + "\n" +
      "Intercity Calls: " + this.intercity_calls + " min. \n" +
      "Intracity Calls: " + this.intracity_calls + " min. " +
      "}";
      return result;
  }


  private void checkStringCorrectness(String value) throws Exception {
    if (value.equals("")) throw new Exception("Invalid value");
  }
}
