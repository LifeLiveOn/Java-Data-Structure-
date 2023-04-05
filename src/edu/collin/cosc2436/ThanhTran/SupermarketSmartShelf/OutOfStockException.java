package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

/**
 * An exception that is thrown when a requested item is out of stock on the smart shelf.
 */
@SuppressWarnings("serial")
public class OutOfStockException extends Exception {

    /**
     * Constructs a new OutOfStockException with the given item name.
     * 
     * @param item the name of the item that is out of stock
     */
    public OutOfStockException(String item) {
        super("The item: '" + item + "' is out of stock"+"\n");
    }
}
