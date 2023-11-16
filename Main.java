import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    try{
        double PI = Math.PI;
        Scanner scanner = new Scanner(System.in);
        double total_cost = 0;
        double total_capacitance = 0;
        double total_inductance = 0;
        double resonate_frequency;

        ArrayList<Component> tankCircuit = new ArrayList<>();

        // Student name and ID
        System.out.println("Student Name: Mushayev Masrur");
        System.out.println("Student ID: 56856");

        // control while loop
        boolean toAddNewC = true;
        boolean toAddNewI = true;


        //loop for capacitor's info as user input
        while (toAddNewC) {
          System.out.print("Are you adding capacitors? (Y/N): ");
          String loop_control = scanner.next();

          if (loop_control.charAt(0) == 'N') {
            toAddNewC = false;
            break;
          }

          // ask user for area and distance
          System.out.print("Enter Capacitor Area (mm^2): ");
          double _a = scanner.nextDouble();
          System.out.print("Enter Capacitor separated distance (mm): ");
          double _d = scanner.nextDouble();

          Capacitor newCapacitor = new Capacitor(); // creating a new capacitor object.
          newCapacitor.setArea(_a);
          newCapacitor.setDistance(_d);

          // adding the newly created capacitor to list.
          tankCircuit.add(newCapacitor);
        }




        //loop for inductor's info as input
        while (toAddNewI) {
          System.out.print("Are you adding inductors? (Y/N): ");
          String loop_control = scanner.next();

          if (loop_control.charAt(0) == 'N') {
            toAddNewI = false;
            break;
          }

          // asking user for inductance
          System.out.print("Enter Inductance of the inductor (uH): ");
          double _l = scanner.nextDouble();

          Inductor newIndc = new Inductor(); // creating a new inductor object.
          newIndc.setL(_l);

          tankCircuit.add(newIndc); // adding the newly created inductor to list.
        }

        // calculate total capacitance, inductance, and resonant frequency
        for (int idx = 0; idx < tankCircuit.size(); idx++) {
            total_cost += tankCircuit.get(idx).getCost(); // total cost
            if (tankCircuit.get(idx) instanceof Capacitor) { //if Capacitor
                total_capacitance += ((Capacitor) tankCircuit.get(idx)).getCapacitance();
            }
            else if (tankCircuit.get(idx) instanceof Inductor) { //if Inductor
                total_inductance += ((Inductor) tankCircuit.get(idx)).getL();
            }
            else{
                System.out.println("Unknown circuit element");
            }
        }


        //calculate resonate frequency
        resonate_frequency = (1 / (2 * PI * Math.sqrt((total_inductance) * total_capacitance))) / 1000;

        System.out.println("Mushayev Masrur's LC Tank Circuit");
        System.out.printf("Resonate Frequency: %.2f MHz\n", resonate_frequency);

        // display information about each capacitor and inductor one by one.
        for (int idx = 0; idx < tankCircuit.size(); idx++) {
          if (tankCircuit.get(idx) instanceof Capacitor) { //if Capacitor
                ((Capacitor) tankCircuit.get(idx)).printInfo();
          }
          else if (tankCircuit.get(idx) instanceof Inductor) { //if Inductor
              ((Inductor) tankCircuit.get(idx)).printInfo();
          }
        }

        System.out.println("Total cost: $" + total_cost);

        scanner.close(); // closing the scanner to prevent resource leaks.
    }
    catch(Exception e){
      System.out.println("Exception thrown: " + e.getClass() + " : " + e.getMessage());
    }
  }
}