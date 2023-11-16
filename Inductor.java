public class Inductor extends Component {

  double L;

  public Inductor() {
    this.Name = "Inductors";
    this.Description = "Store electrical charges.";
    this.Manufacturer = "Motorola";
    this.Cost = 0.25;
    this.Obsolete = false;
  }

  public void setL(double l) {
    this.L = l;
  }

  public double getL() {
    return this.L;
  }

  public void printInfo() {
    System.out.println(this.getName() + ", " + this.getL() + " uH, " + this.getDescription());
  }
}