package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelfGeneric;

import edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf.OutOfStockException;

/**
 * An interface for customers to find and take retail items from a shelf.
 *
 * @param <T> the type of the items the shelf stores
 */
public interface IShelfCustomer<T extends RetailItem> extends IShelf {

    /**
     * Finds and takes the retail item with the given name from the shelf.
     *
     * @param itemName the name of the retail item to find and take
     * @return the retail item that was found and taken
     * @throws OutOfStockException if the requested item is not available on the shelf
     */
    public T findAndTake(String itemName) throws OutOfStockException;
}
