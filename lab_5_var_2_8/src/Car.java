import java.util.regex.Pattern;

public class Car {
  int id;
  String brand;
  String model;
  int year;
  String color;
  int price;
  String number;

  public void setId(int id) throws Exception {
    if (id <= 0) throw new Exception("ID can't be 0 or negative");
    this.id = id;
  }

  public void setBrand(String brand) throws Exception {
    checkStringCorrectness(brand);
    this.brand = brand;
  }

  public void setModel(String model) throws Exception {
    checkStringCorrectness(model);
    this.model = model;
  }

  public void setColor(String color) throws Exception {
    checkStringCorrectness(color);
    this.color = color;
  }

  public void setPrice(int price) throws Exception {
    if (price < 0) throw new Exception("Price can't be negative");
    this.price = price;
  }

  public void setNumber(String number) throws Exception {
    if (!Pattern.matches("\\D{1}\\d{3}\\D{2}", number)) throw new Exception("Invalid car number format");;
    this.number = number;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public String getNumber() {
    return number;
  }

  public int getPrice() {
    return price;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    String result = "{ " +
      "ID: " + this.id + "\n" +
      "Brand: " + this.brand + "\n" +
      "Model: " + this.model + "\n" +
      "Year: " + this.year + "\n" +
      "Color: " + this.color + "\n" +
      "Price: " + this.price + "\n" +
      "Number: " + this.number + "\n" +
      "}";
    return result;
  }


  private void checkStringCorrectness(String value) throws Exception {
    if (value.equals("")) throw new Exception("Invalid value");
  }
}
