package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

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
		customer1.takeFromShelf(cerealShelf,"Apple Jacks",RetailItemType.CEREAL);
		customer1.takeFromShelf(cerealShelf,  "Cinnamon Toast Crunch",RetailItemType.CEREAL);
		customer1.takeFromShelf(cerealShelf,  "Cinnamon Toast Crunch",RetailItemType.CEREAL);

		// Greedy customer trying to take chips
		customer2.takeFromShelf(chipsShelf, "Lays",RetailItemType.CEREAL);
		customer2.takeFromShelf(chipsShelf, "Bugles",RetailItemType.CEREAL);
		// Test adding items to the cereal and chips shelves
		Cereal newCerealItem = new Cereal("Cinnamon Toast Crunch");
		Cereal newCerealItem2 = new Cereal("Lucky Charms");
		employee.addItem(cerealShelf, newCerealItem);
		employee.addItem(cerealShelf, newCerealItem2);
		// add item outside of range
		Cereal newCereal6 = new Cereal("Zzzz");
		employee.addItem(cerealShelf, newCereal6);
		// add item at end of list
		Cereal newCereal5 = new Cereal("Rice Krispies");
		employee.addItem(cerealShelf, newCereal5);
		// add item at the start of list
		Cereal newCereal7 = new Cereal("Aaaa");
		employee.addItem(cerealShelf, newCereal7);
		

		System.out.println(cerealShelf);

		employee.addItem(chipsShelf, new Chips("Ruffles"));
		employee.addItem(chipsShelf, new Chips("Bugles"));

		System.out.println(chipsShelf);
	}
}
