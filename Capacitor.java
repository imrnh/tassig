import java.lang.Math;

public class Capacitor extends Component {
  public String Warning;
  double area;
  double distance;

  public Capacitor() {
    Name = "Capacitors";
    Description = "Store electrical charges.";
    Manufacturer = "Siemens";
    Cost = 0.50;
    Obsolete = false;

    this.Warning = "Do not use electrolytic capacitors in tank circuits.";

  }

  public void setArea(double a) {
    if(a < 0){
      throw new RuntimeException("Area cannot be negative");
    }
    this.area = a;
  }

  public double getArea() {
    return this.area;
  }

  public void setDistance(double d) {
    this.distance = d;
  }

  public double getDistance() {
    return this.distance;
  }

  public String getWarning() {
    return this.Warning;
  }

  // calculate and return capacitance.
  public double getCapacitance() {
    double E = 8.85 * Math.pow(10, -12);
    double C = (E * this.getArea() / this.getDistance());
    return C;
  }

  public void printInfo() {
    //the capacitance was multiplied by 1e11 to match pico unit. [As we have used pico Farade to express the capacitance]
    System.out.print(this.getName() + ", ") ;
    System.out.printf("%.2f pF, ", this.getCapacitance() * 1e11);
    System.out.print(this.getDescription() + ". Warning: " + this.getWarning() + "\n");
  }
}