package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelfGeneric;

/**
 * Represents an item for sale in a retail store.
 */
public class RetailItem implements Comparable<RetailItem>{
    private final String name;

    /**
     * Constructs a new retail item with the specified name.
     * @param name the name of the retail item
     */
    public RetailItem(String name) {
        this.name = name;
    }

    /**
     * Compares this retail item to another retail item based on their names.
     * @param other the other retail item to compare to
     * @return a negative integer, zero, or a positive integer as this retail item
     *         is less than, equal to, or greater than the other retail item
     */
    @Override
    public int compareTo(RetailItem other){
        return this.name.compareToIgnoreCase(other.name);
    }

    /**
     * Gets the name of this retail item.
     * @return the name of this retail item
     */
    public String getName() {
        return name;
    }
    
}
