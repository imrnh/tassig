import java.util.Scanner;
import java.lang.Math;

public class Assignment1 {
  public static void main(String[] args) {

    // Hardcoded value of Permittivity in F/m and PI
    double E = 8.85 * Math.pow(10, -12);
    double PI = Math.PI;

    // Student name and ID
    System.out.println("Student Name: Mushayev Masrur");
    System.out.println("Student ID: 56856");

    // User input for A,D and L
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Capacitor Area (mm^2), A: ");
    double A = scanner.nextDouble();
    System.out.print("Enter Capacitor separated distance (~1 mm or less), D: ");
    double d = scanner.nextDouble();
    System.out.print("Enter Inductance of the inductor (uH), L: ");
    double L = scanner.nextDouble();
    scanner.close();

    // Calculate capacitance
    double C = (E * A / d);

    // Calculate resonant frequency in MHz
    double f = (1 / (2 * PI * Math.sqrt(L * C))) / 1000;

    // Round the resonant frequency to two decimal places
    f = Math.round(f * 100.0) / 100.0;
    System.out.println("Mushayev Masrur's LC Tank Circuit Resonate Frequency: " + f + " MHz");
  }
}
