package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

import java.util.List;

public interface IShelfEmployee<T extends RetailItem> extends IShelf{
	
	/**
	 * Adds a new item to the shelf.
	 * 
	 * @param item The RetailItem to be added to the shelf.
	 */
	public void addItem(T item);
	
	/**
	 * Sorts the items on the shelf. accept any type that is subclass of retailItem.
	 */
	public void placeItems(List<T> unsortedItems);
}
