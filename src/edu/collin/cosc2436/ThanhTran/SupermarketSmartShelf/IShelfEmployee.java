package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

public interface IShelfEmployee {
	
	/**
	 * Adds a new item to the shelf.
	 * 
	 * @param item The RetailItem to be added to the shelf.
	 */
	public void addItem(RetailItem item);
	
	/**
	 * Sorts the items on the shelf.
	 */
	public void placeItems();
}
