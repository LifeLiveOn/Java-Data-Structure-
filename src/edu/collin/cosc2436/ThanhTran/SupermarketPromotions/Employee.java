package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

import java.util.List;

/**
 * The Employee class represents an employee who can place items on a shelf and add new items to a shelf.
 */
public class Employee {
    
    /**
     * The name of the employee.
     */
    private final String name;

    /**
     * Constructs an employee with the given name.
     *
     * @param name the name of the employee
     */
    public Employee(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Places a list of unsorted items on a shelf and sorts them.
     *
     * @param shelf the shelf to place items on
     * @param unsortedItems the list of unsorted items to place on the shelf
     * @param <T> the type of the items to place on the shelf, which must be a subclass of RetailItem
     */
    public <T extends RetailItem> void placeItems(IShelfEmployee<T> shelf, List<T> unsortedItems) {
        System.out.println(name + " placing on " + shelf.getShelfName() + " Shelf");
        for (T item : unsortedItems) {
            System.out.println("\t"+item.getName());
//            shelf.addItem(item); employee not allow to change the internal of the shelf.
        }
        // Sort the items
        shelf.placeItems(unsortedItems);
    }

    /**
     * Adds a new item to a shelf.
     *
     * @param shelf the shelf to add the item to
     * @param item the new item to add
     * @param <T> the type of the item to add to the shelf, which is a subclass of RetailItem
     */
    public <T extends RetailItem> void addItem(IShelfEmployee<T> shelf, T item) {
        // Add the new item to the shelf in the correct position
        System.out.println(name + " adding to " + shelf.getShelfName() + " Shelf: " + item.getName());
        shelf.addItem(item);
        
    }
}
