package vehicle_rental;

interface Rentable {
	double calculateRent(int days);
}
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