package edu.neu.csye6200.tractor;

public class Tractor {
    private String make;
    private String model;
    private final String fuel_type;
    private int capacity;
    private final String current_fuel_load;
    private String power;
    private double fuel_efficiency;

    public Tractor(String make, String model, String fuel_Type, int capacity, String current_Fuel_Load, String power, double fuel_efficiency) {

        this.make = make;
        this.model = model;
        fuel_type = fuel_Type;
        this.capacity = capacity;
        current_fuel_load = current_Fuel_Load;
        this.power = power;
        this.fuel_efficiency = fuel_efficiency;
    }

    public double range() {
        double range = capacity * fuel_efficiency;
        return range;
    }

    @Override
    public String toString() {
        return "Tractor" + "make= " + make + ", model= " + model + ", fuel_type= " + fuel_type + ", capacity= " + capacity + ", current_fuel_load= " + current_fuel_load + ", power= " + power + ", fuel_efficiency= " + fuel_efficiency + "range= " + range();
    }
//method to calculate range based on fuel load and fuel efficiency value
    //Add a method to print an attractive display of the  import tractor  data including  power and  range
    //• Have your code print the contents of  all the tractors

}
