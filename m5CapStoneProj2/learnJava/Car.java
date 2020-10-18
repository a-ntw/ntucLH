/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antw
 */
//import java.util.Scanner;  // Import the Scanner class

public class Car { // step 1
    // Access Modifioers: public, private, protected, package
    // State

    private String Color;
    private String licPlateNo;
    private int noOfSeats;
    private int engineCC;
    private int accSpeed;

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getLicPlateNo() {
        return licPlateNo;
    }

    public void setLicPlateNo(String licPlateNo) {
        this.licPlateNo = licPlateNo;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    public int getAccSpeed() {
        return accSpeed;
    }

    public void setAccSpeed(int accSpeed) {
        this.accSpeed = accSpeed;
    }

    //behavior
    int incSpd(int meterUp) {
        return accSpeed += meterUp;
    }

    int decSpd(int meterDn) {
        return accSpeed -= meterDn;
    }

    /**
     * *****************
     */     // constructor - which hepls me build an object /// step 4
    public Car(String cr, String lp, int sn, int ec) {
        this(cr);
        this.licPlateNo = lp;
        noOfSeats = sn;
        engineCC = ec;
    }

    public Car() {
    }

    // constructor - which hepls me build an object /// step 4
    public Car(String cr) {
        Color = cr;
    }

    // default to toString // Color; licPlateNo; noOfSeats; engineCC;accSpeed;
    @Override
    public String toString() {              // step 3
        return "1. Color: " + Color + "\n"
                + "2. car no.: " + licPlateNo + "\n"
                + "3. noOfSeats: " + noOfSeats + "\n"
                + "4. engine capacity: " + engineCC + "\n"
                + "5. Accelerate speed: " + accSpeed + "km/hr!\n"
                + "Ctrl-C to quit!\n";
    }

    //Car dummy = new Car();
    // static String arrayC[] = new String [5];
    public static void main(String args[]) {
        // TODO code application logic here
        Car nullCar = new Car(); // using the null constructor// step 2
        Car blackCar = new Car("BLACK"); // using the Color constructor
        Car redCar = new Car("RED", "AB1234C", 2, 2000);
        Car nextCar = new Car("green", "ZZ9875J", 4, 1300);
        Car dummy = new Car();

        blackCar.setEngineCC(2900);
        blackCar.setAccSpeed(90);
        blackCar.accSpeed = 99; //  ??? 
        /* redCar.incSpd(80);
        nextCar.incSpd(50);
        System.out.println(nextCar);
        redCar.decSpd(20);
        System.out.println(redCar);  */
        System.out.print("Car Menu:\n 1. NullCar \n 2. BlackCar\n"
                + " 3. RedCar \n" + " 4. nextCar \n");
        System.out.print("Pick Car to edit: ");
        String yrCarPick = scanInput();

        while (true) {
            switch (yrCarPick) {
                case "2":
                    displayCar(blackCar);
                    dummy = blackCar;
                    break;
                case "3":
                    displayCar(redCar);
                    dummy = redCar;
                    break;
                case "4":
                    displayCar(nextCar);
                    dummy = nextCar;
                    break;
                default:
                    displayCar(nullCar);
                    dummy = nullCar;
            }

            System.out.print("Select number to edit: ");
            String yrPick = scanInput();
            System.out.print("Key on your value: ");
            String yrVal = scanInput();
            int value;
            switch (yrPick) {
                case "1":
                    dummy.setColor(yrVal);
                    break;
                case "2":
                    dummy.setLicPlateNo(yrVal);
                    break;
                case "3":
                    value =Integer.parseInt(yrVal);  
                    dummy.setNoOfSeats(value);
                    break;
                case "4":
                    value =Integer.parseInt(yrVal); 
                    dummy.setEngineCC(value);
                    break;
                case "5":
                    value =Integer.parseInt(yrVal); 
                    dummy.setAccSpeed(value);
                    break;
                default:
                    break;
            }
        }

    }

    public static void example(Car myStates) {

    }

    // Input car particular
    // import java.util.Scanner;  // Import the Scanner class
    public static String scanInput() {
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.print(": ");
        //String inputStr = myObj.nextLine();  // Read user input
        System.out.print(":: "); 
        String inputStr = System.console().readLine();
        return inputStr;
    }

    public static void displayCar(Car myStates) {
        System.out.println(myStates);
    }
}

/*
1. new car
2. edit car
 */
