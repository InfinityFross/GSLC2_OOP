package oopGSLC;

//Program: Car Rental System
//This program simulates a car rental system that allows users to rent cars and bikes.


//This interface defines the common behavior of rentable items.
interface Rentable {
	void rent();
	void returnItem();
}

//This abstract class provides a base implementation for vehicles and implements the Rentable interface.
abstract class Vehicle implements Rentable {
	private String registrationNumber;
	private boolean isRented;

	public Vehicle(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		this.isRented = false;
	 }	

	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void rent() {
	if (!isRented) {
		isRented = true;
		System.out.println("Vehicle " + registrationNumber + " has been rented.");
	} else {
		System.out.println("Vehicle " + registrationNumber + " is already rented.");
	}
	}


	public void returnItem() {
	if (isRented) {
		isRented = false;
		System.out.println("Vehicle " + registrationNumber + " has been returned.");
	} else {
		System.out.println("Vehicle " + registrationNumber + " is not currently rented.");
	}
	}
}


//This class represents a car and extends the Vehicle abstract class.
class Car extends Vehicle {
	private int passengerCapacity;

	public Car(String registrationNumber, int passengerCapacity) {
		super(registrationNumber);
		this.passengerCapacity = passengerCapacity;
	}

	public void displayDetails() {
		System.out.println("Car " + getRegistrationNumber() + " - Passenger Capacity: " + passengerCapacity);
	}
}

//This class represents a bike and extends the Vehicle abstract class.
class Bike extends Vehicle {
	private boolean hasBasket;

	public Bike(String registrationNumber, boolean hasBasket) {
		super(registrationNumber);
		this.hasBasket = hasBasket;
	}

	public void displayDetails() {
		System.out.println("Bike " + getRegistrationNumber() + " - Has Basket: " + hasBasket);
	}
}

//This class represents a customer who can rent vehicles.
class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public void rentVehicle(Rentable item) {
		item.rent();
	}

	public void returnVehicle(Rentable item) {
		item.returnItem();
	}
}

//This class contains the main method to demonstrate the car rental system application.
public class carRentalSystemApp {
	public static void main(String[] args) {
		Car car1 = new Car("ABC123", 5);
		Bike bike1 = new Bike("XYZ456", true);

		Customer customer1 = new Customer("Jang Wonyoung");
		car1.displayDetails();
		customer1.rentVehicle(car1);
//		customer1.returnVehicle(car1);
		System.out.println();

		Customer customer2 = new Customer("Vanessa Kang");
		bike1.displayDetails();
		customer2.rentVehicle(bike1);
		customer2.returnVehicle(bike1);
		
		System.out.println();
		
		Customer customer3 = new Customer("Chris Martin");
		car1.displayDetails();
		customer3.rentVehicle(car1);
		System.out.println();
	}
}