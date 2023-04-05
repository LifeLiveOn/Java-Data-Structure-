package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

/**
 * Represents an item for sale in a retail store.
 */
public class RetailItem implements Comparable<RetailItem>{
    private final String name;
    private final RetailItemType itemType;

    /**
     * Constructs a new retail item with the specified name.
     * @param name the name of the retail item
     */
    public RetailItem(String name,RetailItemType itemType) {
        this.name = name;
		this.itemType = itemType;
    }

    /**
     * Compares this retail item to another retail item based on their names.
     * @param other the other retail item to compare to
     * @return a negative integer, zero, or a positive integer as this retail item
     *         is less than, equal to, or greater than the other retail item
     */
    @Override
    public int compareTo(RetailItem other){
        return (this.name+String.valueOf(itemType)).compareTo(other.name+String.valueOf(other.itemType));
    }

    /**
     * Gets the name of this retail item.
     * @return the name of this retail item
     */
    public String getName() {
        return name;
    }
    
    /**
     * Calculates a unique hash code for the RetailItem object based on its name and item type.
     use prime number to prevent collision
     *
     * @return an integer hash code value for this object
     */
    @Override
    public int hashCode() {
    	//https://stackoverflow.com/questions/3613102/why-use-a-prime-number-in-hashcode
    	// why choosing prime number to generate unique hashCode to prevent collision.
    	int hashRet = 5;
    	hashRet = 31 * hashRet + name.hashCode();
    	hashRet = 31 * hashRet + itemType.hashCode();
		return hashRet;
    	
    }
    
    
    /**
     * Compares this RetailItem object to the specified object for equality.
     * The comparison is based on the name and item type of the RetailItem object.
     *
     * @param obj the object to compare to this RetailItem
     * @return true if the given object represents a RetailItem with the same name and item type as this object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof RetailItem) {
            RetailItem item = (RetailItem) obj;
            ret = name.equals(item.name) && itemType==item.itemType;
        }
        return ret;
    }
    
    
    
    /**
     * Returns the type of the retail item.
     *
     * @return The retail item's type.
     */
    public RetailItemType getType() {
        return itemType;
    }

    
}
