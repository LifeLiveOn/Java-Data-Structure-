package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

import java.util.ArrayList;

/**
 * The Employee class represents an employee who can place items on a shelf
 * and add new items to a shelf.
 */
public class Employee {

    /**
     * Places a list of unsorted items on a shelf and sorts them.
     *
     * @param shelf         the shelf to place items on
     * @param unsortedItems the list of unsorted items to place on the shelf
     */
    public void placeItems(IShelfEmployee shelf, ArrayList<RetailItem> unsortedItems) {
        for (RetailItem item : unsortedItems) {
            System.out.println(item.getName());
            shelf.addItem(item);
        }
        // Sort the items using Quicksort algorithm
        shelf.placeItems();
    }

    /**
     * Adds a new item to a shelf.
     *
     * @param shelf the shelf to add the item to
     * @param item  the new item to add
     */
    public void addItem(IShelfEmployee shelf, RetailItem item) {
        // Add the new item to the shelf in the correct position
    	System.out.println("----------Employee adding " + item.getName());
        shelf.addItem(item);
        System.out.println("----------"+ item.getName() +" added to the shelf\n");
        
    }
}
