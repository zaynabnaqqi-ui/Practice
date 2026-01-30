import java.util.Scanner;

class Car {
    String brand;
    String model;
    int year;
    double mileage;

    void showCarDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }

    int calculateCarAge() {
        return 2026 - year;
    }

    boolean isVintageCar() {
        if (calculateCarAge() > 25)
            return true;
        else
            return false;
    }

    void updateMileage(int newMileage) {
        if (newMileage > mileage)
            mileage = newMileage;
        else
            System.out.println("Invalid mileage update");
    }
}

public class Vehicle {
    public static void main(String[] args) {

        Car c1 = new Car();
        Car c2 = new Car();

        c1.model = "Devo 3.0";
        c1.brand = "Mercedes";
        c1.year = 2020;
        c1.mileage = 2000;

        c2.model = "Fortuner 6.1";
        c2.brand = "Honda";
        c2.year = 2006;
        c2.mileage = 10000;

        Scanner input = new Scanner(System.in);

        // Car 1
        c1.showCarDetails();
        System.out.println("Car Age: " + c1.calculateCarAge());
        System.out.println("Vintage: " + c1.isVintageCar());
        System.out.print("Enter updated mileage: ");
        int updatedMileage1 = input.nextInt();
        c1.updateMileage(updatedMileage1);

        System.out.println("---------------------");

        // Car 2
        c2.showCarDetails();
        System.out.println("Car Age: " + c2.calculateCarAge());
        System.out.println("Vintage: " + c2.isVintageCar());
        System.out.print("Enter updated mileage: ");
        int updatedMileage2 = input.nextInt();
        c2.updateMileage(updatedMileage2);
    }
}
