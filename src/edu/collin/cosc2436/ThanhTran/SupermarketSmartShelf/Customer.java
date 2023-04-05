package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

/**
 * Represents a customer that can take items from a shelf.
 */
public class Customer {
    
    /**
     * Takes an item with the specified name from the given shelf, if available.
     * 
     * @param shelf the shelf to take the item from
     * @param itemName the name of the item to take
     * @return the item that was taken
     * @throws OutOfStockException if the item is not available on the shelf
     */
    public RetailItem takeItem(IShelfCustomer shelf, String itemName) throws OutOfStockException {
        System.out.println("----------Customer getting " + itemName);
        RetailItem item = shelf.findAndTake(itemName);
        if(item != null) {
        	System.out.println("----------Customer got "+item.getName()+"\n");
        }
        return item;
    }
}
