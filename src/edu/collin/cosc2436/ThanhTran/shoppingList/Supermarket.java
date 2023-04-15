package edu.collin.cosc2436.ThanhTran.shoppingList;

import java.util.Map;
import java.util.HashMap;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.IShelf;

public class Supermarket{
	private final Map<String, IShelf> shelfMap = new HashMap<String, IShelf>();
	
	public void addShelf(IShelf shelf) {
		shelfMap.put(shelf.getShelfName(), shelf);
	}
	
	public IShelf removeShelf(IShelf shelf) {
		IShelf ret = shelf;
		shelfMap.remove(shelf.getShelfName(), shelf);
		return ret;
	}
	
	public IShelf findShelf(String shelfName) {
		return shelfMap.get(shelfName);
		
	}
}
