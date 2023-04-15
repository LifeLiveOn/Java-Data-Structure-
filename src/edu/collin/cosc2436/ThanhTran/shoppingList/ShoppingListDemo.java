package edu.collin.cosc2436.ThanhTran.shoppingList;

import java.util.ArrayList;
import java.util.Scanner;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.Cereal;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.Chips;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.SmartShelf;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.SmartShelfDemo;
import edu.collin.cosc2436.ThanhTran.cashRegisterUpdated.Soap;
import edu.collin.cosc2436.ThanhTran.cashRegisterUpdated.Soda;

public class ShoppingListDemo {

	public static void main(String[] args) {
		
		SmartShelf<Cereal> cerealShelf = new SmartShelf<>("Cereal");
		SmartShelf<Chips> chipsShelf = new SmartShelf<>("Chips");
		SmartShelf<Soda> sodaShelf = new SmartShelf<>("Soda");
		SmartShelf<Soap> soapShelf = new SmartShelf<>("Soap");
		
		// item from the cereals.txt file and add to an cerealList
		ArrayList<Cereal> cerealList = new ArrayList<>();
		// Read items from the chips.txt file and add to ArrayList
		ArrayList<Chips> chipList = new ArrayList<>();
		// Read items from the soda.txt file and add to ArrayList
		ArrayList<Soda> sodaList = new ArrayList<>();
				// Read items from the soap.txt file and add to ArrayList
		ArrayList<Soap> soapList = new ArrayList<>();
		Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		while (scanner.hasNext()) {
			cerealList.add(new Cereal(scanner.nextLine()));
		}
		scanner.close();
		scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		while (scanner.hasNext()) {
			chipList.add(new Chips(scanner.nextLine()));
		}
		scanner.close();
		scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/soda.txt"));
		while (scanner.hasNext()) {
			sodaList.add(new Soda(scanner.nextLine()));
		}
		scanner.close();	
			scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/soap.txt"));
		while (scanner.hasNext()) {
			soapList.add(new Soap(scanner.nextLine()));
		}
		scanner.close();
		
		
		Employee employee = new Employee("Jack");
		employee.placeItems(cerealShelf, cerealList);
		employee.placeItems(chipsShelf, chipList);
		employee.placeItems(sodaShelf,sodaList);
		employee.placeItems(soapShelf,soapList);
		
		Supermarket market = new Supermarket();
		market.addShelf(cerealShelf);
		market.addShelf(sodaShelf);
		market.addShelf(chipsShelf);
		market.addShelf(soapShelf);
		
		
		
		Customer customer1 = new Customer("JohnCenna");
		MyLinkedList<ShoppingListEntry> shoppinglist1 = new MyLinkedList<>();
		shoppinglist1.addFirst(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, sodaShelf.getShelfName()));
		shoppinglist1.addLast(new ShoppingListEntry("Dial", RetailItemType.SOAP, soapShelf.getShelfName()));
		shoppinglist1.addLast(new ShoppingListEntry("Fritos", RetailItemType.CHIPS, chipsShelf.getShelfName()));
		shoppinglist1.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelf.getShelfName()));
		shoppinglist1.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelf.getShelfName()));
		customer1.shop(shoppinglist1,market);
		
		Customer customer2 = new Customer("Mary");
		MyLinkedList<ShoppingListEntry> shoppinglist2 = new MyLinkedList<>();
		shoppinglist2.addFirst(new ShoppingListEntry("Coca-Cola", RetailItemType.SODA, sodaShelf.getShelfName()));
		shoppinglist2.addLast(new ShoppingListEntry("Neutrogena", RetailItemType.SOAP, soapShelf.getShelfName()));
		shoppinglist2.addLast(new ShoppingListEntry("Doritos", RetailItemType.CHIPS, chipsShelf.getShelfName()));
		shoppinglist2.addLast(new ShoppingListEntry("Apple Jacks", RetailItemType.CEREAL, cerealShelf.getShelfName()));
		customer2.shop(shoppinglist2, market);
		
		MyLinkedList<ShoppingListEntry> shoppinglist3 = new MyLinkedList<>();
		Customer customer3 = new Customer("Jar Jar Binks");
		// Add items to Jar Jar Binks' shopping list
		shoppinglist3.addLast(new ShoppingListEntry("Cheetos", RetailItemType.CHIPS, sodaShelf.getShelfName()));
		shoppinglist3.addLast(new ShoppingListEntry("Red Bull", RetailItemType.SODA, soapShelf.getShelfName()));
		shoppinglist3.addLast(new ShoppingListEntry("Coke Zero", RetailItemType.SODA, chipsShelf.getShelfName()));
		shoppinglist3.addLast(new ShoppingListEntry("Ivory", RetailItemType.SOAP, cerealShelf.getShelfName()));

		// Jar Jar Binks goes shopping
		customer3.shop(shoppinglist3, market);
		
		
	}

}
