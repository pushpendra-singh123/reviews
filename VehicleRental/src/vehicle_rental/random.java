// Rentable interface
interface Rentable {
    double calculateRent(int days);
}

// Base Vehicle class
abstract class Vehicle implements Rentable {
    protected String licensePlate;
    protected String make;
    protected String model;
    protected int year;
    protected boolean isRented;
    
    public Vehicle(String licensePlate, String make, String model, int year) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.isRented = false;
    }
    
    // Getters and setters
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public boolean isRented() {
        return isRented;
    }
    
    public void setRented(boolean rented) {
        isRented = rented;
    }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model + " (" + licensePlate + ")";
    }
}

// Bike class
class Bike extends Vehicle {
    private static final double BASE_RATE = 10.0;
    private String bikeType; // e.g., Mountain, Road, Hybrid
    
    public Bike(String licensePlate, String make, String model, int year, String bikeType) {
        super(licensePlate, make, model, year);
        this.bikeType = bikeType;
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    @Override
    public double calculateRent(int days) {
        // Bikes have a simple daily rate
        return BASE_RATE * days;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + bikeType + " Bike";
    }
}

// Car class
class Car extends Vehicle {
    private static final double BASE_RATE = 50.0;
    private int seatingCapacity;
    private String carType; // e.g., Sedan, SUV, Hatchback
    
    public Car(String licensePlate, String make, String model, int year, int seatingCapacity, String carType) {
        super(licensePlate, make, model, year);
        this.seatingCapacity = seatingCapacity;
        this.carType = carType;
    }
    
    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public String getCarType() {
        return carType;
    }
    
    @Override
    public double calculateRent(int days) {
        // Cars have base rate plus premium for larger vehicles
        double rate = BASE_RATE;
        if (seatingCapacity > 5) {
            rate += 15.0; // SUV or minivan surcharge
        }
        return rate * days;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + carType + " (" + seatingCapacity + " seats)";
    }
}

// Truck class
class Truck extends Vehicle {
    private static final double BASE_RATE = 100.0;
    private double cargoCapacity; // in tons
    private boolean hasTrailer;
    
    public Truck(String licensePlate, String make, String model, int year, double cargoCapacity, boolean hasTrailer) {
        super(licensePlate, make, model, year);
        this.cargoCapacity = cargoCapacity;
        this.hasTrailer = hasTrailer;
    }
    
    public double getCargoCapacity() {
        return cargoCapacity;
    }
    
    public boolean hasTrailer() {
        return hasTrailer;
    }
    
    @Override
    public double calculateRent(int days) {
        // Trucks have base rate plus cargo capacity and trailer surcharges
        double rate = BASE_RATE + (cargoCapacity * 5.0);
        if (hasTrailer) {
            rate += 40.0;
        }
        return rate * days;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Truck (" + cargoCapacity + " tons" + 
               (hasTrailer ? ", with trailer" : "") + ")";
    }
}

// Customer class
class Customer {
    private String name;
    private String driverLicense;
    private String phoneNumber;
    private Vehicle rentedVehicle;
    private int rentalDays;
    
    public Customer(String name, String driverLicense, String phoneNumber) {
        this.name = name;
        this.driverLicense = driverLicense;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getDriverLicense() {
        return driverLicense;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }
    
    public int getRentalDays() {
        return rentalDays;
    }
    
    // Rent a vehicle
    public boolean rentVehicle(Vehicle vehicle, int days) {
        if (vehicle.isRented()) {
            System.out.println("Sorry, this vehicle is already rented.");
            return false;
        }
        
        this.rentedVehicle = vehicle;
        this.rentalDays = days;
        vehicle.setRented(true);
        System.out.println(name + " has rented " + vehicle + " for " + days + " days.");
        System.out.println("Total rent: $" + vehicle.calculateRent(days));
        return true;
    }
    
    // Return a vehicle
    public void returnVehicle() {
        if (rentedVehicle == null) {
            System.out.println(name + " has no vehicle to return.");
            return;
        }
        
        System.out.println(name + " has returned " + rentedVehicle);
        rentedVehicle.setRented(false);
        rentedVehicle = null;
        rentalDays = 0;
    }
    
    @Override
    public String toString() {
        return name + " (DL: " + driverLicense + ", Phone: " + phoneNumber + ")" +
               (rentedVehicle != null ? " - Renting: " + rentedVehicle : "");
    }
}

// Main class to demonstrate the rental system
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create some vehicles
        Bike bike1 = new Bike("B001", "Trek", "FX 2", 2022, "Hybrid");
        Car car1 = new Car("C001", "Toyota", "Camry", 2021, 5, "Sedan");
        Car car2 = new Car("C002", "Ford", "Explorer", 2023, 7, "SUV");
        Truck truck1 = new Truck("T001", "Ford", "F-150", 2022, 1.5, false);
        Truck truck2 = new Truck("T002", "Chevrolet", "Silverado", 2023, 3.0, true);
        
        // Create customers
        Customer customer1 = new Customer("John Doe", "DL123456", "555-0101");
        Customer customer2 = new Customer("Jane Smith", "DL654321", "555-0202");
        
        // Demonstrate rentals
        System.out.println("\n=== Rental Demo ===");
        customer1.rentVehicle(bike1, 3);
        customer2.rentVehicle(car2, 7);
        
        // Try to rent an already rented vehicle
        Customer customer3 = new Customer("Bob Johnson", "DL987654", "555-0303");
        customer3.rentVehicle(bike1, 2);
        
        // Rent another vehicle
        customer3.rentVehicle(truck2, 2);
        
        // Display customer information
        System.out.println("\n=== Customer Information ===");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        
        // Return vehicles
        System.out.println("\n=== Returning Vehicles ===");
        customer1.returnVehicle();
        customer2.returnVehicle();
        customer3.returnVehicle();
        
        // Show status after returns
        System.out.println("\n=== Status After Returns ===");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
    }
}