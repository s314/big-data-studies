public class Surgeon implements Physician {
  
  String area = "Surgery";

  @Override
  public void doTreatment() {
    System.out.println("Вырезан аппендицит");
  }

}
