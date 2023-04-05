/**
 * A demo class that demonstrates the usage of the SupermarketSmartShelf system.
 * It instantiates the SmartShelf, Employee, and Customer classes, and tests the system by:
 *     placing items on the shelf
 *     taking items from the shelf
 *     adding new items to the shelf
 */
package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartShelfDemo {

    public static void main(String[] args) {
        
        // Read items from the cereal.txt file and add to ArrayList
        ArrayList<RetailItem> cerealItems = new ArrayList<>(); 
        Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt")); 
        while (scanner.hasNext()) { 
            cerealItems.add(new RetailItem (scanner.nextLine())); 
        } 
        scanner.close(); 
        
        // Instantiate SmartShelf, Employee, and Customer
        SmartShelf shelf = new SmartShelf("Cereal");
        Employee employee = new Employee();
        Customer customer = new Customer();
        
        // Place items on the shelf
        System.out.println("----------Employee placing on the shelf: ");
        employee.placeItems(shelf, cerealItems);
        
        // Print the shelf before and after sorting
        System.out.println("\n----------Placed on the shelf:");
        System.out.println(shelf);
        
        // Try to take existing and non-existing items from the shelf
        try {
            customer.takeItem(shelf, "Corn Flakes");
            customer.takeItem(shelf, "Cheerios");
            customer.takeItem(shelf, "Cheerios");
            customer.takeItem(shelf, "Cheerios");
        } catch (OutOfStockException e) {
            System.out.println(e);
        }
        System.out.println(shelf);
        
        // Add a new item to the shelf and print the shelf before and after adding
        RetailItem newItem1 = new RetailItem("Cinnamon Toast Crunch");
        RetailItem newItem2 = new RetailItem("Raisin Bran Crunch");
        employee.addItem(shelf, newItem1);
        employee.addItem(shelf, newItem2);
        System.out.println(shelf);
    }    
}
