package edu.collin.cosc2436.ThanhTran.shoppingList;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.IShelfCustomer;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;
import edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf.OutOfStockException;

/**
 * Represents a customer that can take items from a shelf.
 */
public class Customer {
    
    private final String name;

    /**
     * Constructs a new customer with the specified name.
     * 
     * @param name the name of the customer
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the customer.
     * 
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Takes an item with the specified name from the given shelf, if available.
     * 
     * @param shelf the shelf to take the item from
     * @param itemName the name of the item to take
     * @throws OutOfStockException if the item is not available on the shelf
     */
    public <T extends RetailItem> void takeFromShelf(IShelfCustomer<T> shelf, String itemName,RetailItemType itemType) throws OutOfStockException {
        System.out.println(getName() + " getting from " + shelf.getShelfName() + " Shelf: " + itemName);
//		try {
			T item = shelf.findAndTake(itemName,itemType);
			System.out.println(getName() + " got " + item.getName());
			
//		} catch (OutOfStockException e) {
//			System.out.println(e);
//		}
		
        
    }
    
    @SuppressWarnings("unchecked")
	public<T extends RetailItem> void shop(MyList<ShoppingListEntry> list,Supermarket market ) {
    	System.out.println(name+" needs to buy:");
    	for(ShoppingListEntry item : list) {
    		System.out.println(item.toString());    	
    		}
    	System.out.println();
    	for(ShoppingListEntry item : list) {
    		if(market.findShelf(item.getShelfName())!=null) {
    			try {
					takeFromShelf((IShelfCustomer<T>) market.findShelf(item.getShelfName()), item.getName(), item.getType());
					list.remove(item);
				} catch (OutOfStockException e) {
					System.out.print(e);
				}
    			
    		}
    	}
    	if(list.isEmpty()) {
    		System.out.println("\n"+name+" got everything\n");
    	}
    	else {
    		System.out.println("\n"+name+" still has on the list:");
    		for(ShoppingListEntry item : list) {
        		System.out.println(item.toString());    	
        		}
    		System.out.println();
    	}
    	
    }
}
