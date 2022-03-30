public class Fraction {
  int m, n;

  public Fraction() {
    m = 0;
    n = 1;
  }

  public Fraction(int m) {
    this.m = m;
    n = 1;
  }

  public Fraction(int m, int n) {
    this.m = m;
    this.n = n;

    if (n == 0) throw new ArithmeticException("denominator == 0");
  }

  public Fraction(Fraction a) {
    m = a.m;
    n = a.n;

    if (n == 0) throw new ArithmeticException("denominator == 0");
  }

  // Сложение
  public Fraction Add(Fraction addee) {
    // Создаем новый объект класса Fraction
    Fraction sum = new Fraction();
    // Находим общий знаменатель
    int new_n = this.n * addee.n;
    // Присваиваем его новому объекту-сумме
    sum.n = new_n;
    // Получаем сумму числителей
    int new_m = m * addee.n + addee.m * n;
    // Присваиваем её новому объекту-сумме
    sum.m = new_m;

    if (sum.n == 0) throw new ArithmeticException("denominator == 0");

    return sum;
  }

  // Умножение
  public Fraction Multiply(Fraction multiplee) {
    // Создаем новый объект класса Fraction
    // Сразу с умножением
    Fraction product = new Fraction(
      m * multiplee.m,
      n * multiplee.n
    );

    if (product.n == 0) throw new ArithmeticException("denominator == 0");

    return product;
  }

  // Инверсия знака
  public Fraction Invert() {
    // Создаем новый объект класса Fraction
    Fraction inverted = new Fraction(-m, n);

    return inverted;
  }

  // Вычитание
  public Fraction Subtract(Fraction subtractee) {
    // Инвертируем вычитаемое, чтобы провести это как сложение
    Fraction inverted_subtractee = new Fraction(subtractee.Invert());

    // Складываем две дроби
    Fraction sub = this.Add(inverted_subtractee);

    return sub;
  }

  // Переворачивание дроби
  public Fraction Switch() {
    // Создаем новый объект класса Fraction
    // Переворачиваем дробь
    Fraction switched = new Fraction(n, m);

    if (switched.n == 0) throw new ArithmeticException("denominator == 0");

    return switched;
  }

  // Деление
  public Fraction Divide(Fraction dividee) {
    // Переворачиваем множитель для выполнения деления
    Fraction switched_multiplicator = this.Switch();

    // Умножаем на перевернутую дробь
    Fraction product = this.Multiply(switched_multiplicator);

    return product;
  }

  // Вывод дроби
  public String toString() {
    String fraction = m + "/" + n;
    return fraction;
  }
}
