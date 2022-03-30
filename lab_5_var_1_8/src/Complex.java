public class Complex {
  int re, im;

  public Complex() {
    this.re = 0;
    this.im = 0;
  }

  public Complex(int re) {
    this.re = re;
    this.im = 0;
  }

  public Complex(int re, int im) {
    this.re = re;
    this.im = im;
  }

  public Complex(Complex complex) {
    this.re = complex.re;
    this.im = complex.im;
  }


  // Сложение
  public Complex Add(Complex addee) {
    // Создаем новый объект класса Complex
    Complex sum = new Complex(
      this.re + addee.re,
      this.im + addee.im
    );

    return sum;
  }

  // Вычитание
  public Complex Subtract(Complex subtractee) {
    Complex sub = new Complex(
      this.re - subtractee.re,
      this.im - subtractee.im
    );

    return sub;
  }

  // Умножение
  public Complex Multiply(Complex multee) {

    int k1 = multee.re * (this.re + this.im);
    int k2 = this.re * (multee.im - multee.re);
    int k3 = this.im * (multee.re + multee.im);

    int real_part = k1 - k3;
    int imaginary_part = k1 + k2;

    Complex mul = new Complex(real_part, imaginary_part);

    return mul;
  }

  // Деление
  public Complex Divide(Complex dividee) {

    int re_num = (this.re * dividee.re) + (this.im * dividee.im);
    int re_den = (dividee.re * dividee.re + dividee.im * dividee.im);

    int im_num = (this.im * dividee.re) - (this.re * dividee.im);
    int im_den = (dividee.re * dividee.re + dividee.im * dividee.im);

    Complex div = new Complex(
      re_num / re_den,
      im_num / im_den
    );

    return div;
  }

  // Присвоение
  public void SetComplex(int re, int im) {
    this.re = re;
    this.im = im;
  }

  // Вывод числа
  public String toString() {
    String complex = re + " + i" + im;
    return complex;
  }
}
