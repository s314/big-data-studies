public class Car {
  int id;
  String brand;
  String model;
  int year;
  String color;
  int price;
  String number;

  public void setId(int id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setNumber(String number) {
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
}
