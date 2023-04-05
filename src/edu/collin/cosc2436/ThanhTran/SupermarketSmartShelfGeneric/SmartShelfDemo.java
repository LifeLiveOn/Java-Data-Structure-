package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelfGeneric;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A demo class that demonstrates the use of the SmartShelf, Employee, Customer,
 * Cereal, and Chips classes.
 */
public class SmartShelfDemo {

	public static void main(String[] args) {

		// Instantiate two SmartShelf objects
		SmartShelf<Cereal> cerealShelf = new SmartShelf<>("Cereal");
		SmartShelf<Chips> chipsShelf = new SmartShelf<>("Chips");

		// Instantiate an Employee and a couple of Customers
		Employee employee = new Employee("Jack");
		Customer customer1 = new Customer("Mary");
		Customer customer2 = new Customer("John");

		// Read items from the cereal.txt file and add to ArrayList
		ArrayList<Cereal> CerealList = new ArrayList<>();
		Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		while (scanner.hasNext()) {
			CerealList.add(new Cereal(scanner.nextLine()));
		}
		scanner.close();

		// Read items from the chips.txt file and add to ArrayList
		ArrayList<Chips> ChipsList = new ArrayList<>();
		scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		while (scanner.hasNext()) {
			ChipsList.add(new Chips(scanner.nextLine()));
		}
		scanner.close();

		// Sort and place the cereal items on the cereal shelf
		employee.placeItems(cerealShelf, CerealList);
		System.out.println(cerealShelf);
		// Sort and place the chips items on the chips shelf
		employee.placeItems(chipsShelf, ChipsList);
		System.out.println(chipsShelf);
		// Greedy customer trying to take Cereal
		customer1.takeItem(cerealShelf,"Apple Jacks");
		customer1.takeItem(cerealShelf,  "Cinnamon Toast Crunch");
		customer1.takeItem(cerealShelf,  "Cinnamon Toast Crunch");

		// Greedy customer trying to take chips
		customer2.takeItem(chipsShelf, "Lays");
		customer2.takeItem(chipsShelf, "Bugles");
		// Test adding items to the cereal and chips shelves
		Cereal newCerealItem = new Cereal("Cinnamon Toast Crunch");
		Cereal newCerealItem2 = new Cereal("Lucky Charms");
		employee.addItem(cerealShelf, newCerealItem);
		employee.addItem(cerealShelf, newCerealItem2);

		System.out.println(cerealShelf);

		employee.addItem(chipsShelf, new Chips("Ruffles"));
		employee.addItem(chipsShelf, new Chips("Bugles"));

		System.out.println(chipsShelf);
	}
}
