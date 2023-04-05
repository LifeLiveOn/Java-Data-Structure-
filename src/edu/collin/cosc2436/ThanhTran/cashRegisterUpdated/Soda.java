package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;
/**
 * Represents a soda item in a supermarket.
 * Extends the RetailItem class and sets the type to SODA
 */
public class Soda extends RetailItem{
	
	/**
     * Creates a new Soda object with the specified name.
     * @param name the name of the soda
     */
	public Soda(String name) {
		super(name, RetailItemType.SODA);
	}

}
