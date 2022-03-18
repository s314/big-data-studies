public class Computer {
  Parameters parameters;

  public Computer(String os, String processor, int ram) {
    parameters = new Parameters(os, processor, ram);
  }

  class Parameters {
    String os;
    String processor;
    int ram;

    public Parameters(String os, String processor, int ram) {
      this.os = os;
      this.processor = processor;
      this.ram = ram;
    }

    public void setOs(String os) {
      this.os = os;
    }

    public void setProcessor(String processor) {
      this.processor = processor;
    }

    public void setRam(int ram) {
      this.ram = ram;
    }

    public String getOs() {
      return os;
    }

    public String getProcessor() {
      return processor;
    }

    public int getRam() {
      return ram;
    }

    @Override
    public String toString() {
      return "Computer{" +
                "os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                ", RAM=" + ram +
                '}';
    }
  }
}
