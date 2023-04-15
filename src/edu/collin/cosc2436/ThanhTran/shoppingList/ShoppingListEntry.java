package edu.collin.cosc2436.ThanhTran.shoppingList;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;

public class ShoppingListEntry {
	private final String name;
	private final RetailItemType itemType;
	private final String shelf;
	
	
	public ShoppingListEntry(String listName, RetailItemType itemType, String shelf) {
		name = listName;
		this.itemType = itemType;
		this.shelf = shelf;
		
	}
	
	public String getName() {
		return name;
		
	}
	
	public RetailItemType getType() {
		return itemType;
	}
	
	public String getShelfName() {
		return shelf;
	}
	
	@Override
	public String toString() {
	    return itemType + ": " + name + " from " + shelf+" Shelf";
	}


	}
	

