/*
* parking lodge git system :
 1. park
 2. exit
 3. show
    capacity = 6 cars other-wise
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarParkingSystem {
    private static void park(List<String> cars, String car){
        if(cars.size() <= 6){
            cars.add(car);
            System.out.println("Car Successfully Parked");
        }else{
            System.out.print("capacity full");
        }
    }
    private static void exit(List<String> cars, String car){
        if(cars.isEmpty()){
            System.out.println("No car parked.");
            return;
        }
        cars.remove(car);
        System.out.println("Car Successfully exit");
    }

    public static void main(String[] args) {
        List<String> cars = new ArrayList<>(6); // store
        final int capacity = 6;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("************************************");
            System.out.println("    *** Park Your Cars ***  ");
            System.out.print("Choose Option : \n Park : (a) \n exit : (b)\n capacity : (c)");
            String option = sc.next();
            if(cars.size() >= 3){
                System.out.println("Can not park any car.");
                option = "d";
            }
            System.out.println("Enter your car number: ");
            String carNumber = sc.next();
            switch (option) {
                case "a": {
                    park(cars, carNumber);
                    break;
                }
                case "b": {
                    exit(cars, carNumber);
                    break;
                }
                case "c": {
                    System.out.println("Capacity : " + capacity);
                    break;
                }
                case "d": {
                    System.out.println("Capacity Full");
                    break;
                }
                default:
                    System.out.println("Choose correct option");
            }
            System.out.println("size: " + cars.size());
        }while (true);
    }
}
