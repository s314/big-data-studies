public class Neurosurgeon extends Surgeon {

  @Override
  public void doTreatment() {
    System.out.println("Проведена операция на мозге");
  }

  public void doScan() {
    System.out.println("Сделана энцефалограмма");
  }
}
