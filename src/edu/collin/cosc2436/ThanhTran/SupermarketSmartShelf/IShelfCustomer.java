package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

/**
 * An interface for customers to find and take retail items from a shelf.
 */
public interface IShelfCustomer {
    /**
     * Finds and takes the retail item with the given name from the shelf.
     * @param itemName the name of the retail item to find and take
     * @return the retail item that was found and taken
     * @throws OutOfStockException if the requested item is not available on the shelf
     */
    public RetailItem findAndTake(String itemName) throws OutOfStockException;
}
