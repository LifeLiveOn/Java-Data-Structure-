package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;

/**
 * The Soap class represents a soap item in a supermarket.
 * It extends the RetailItem class and sets the name and retail item type to SOAP
 */
public class Soap extends RetailItem{

	/**
	 * Creates a new Soap object with the given name.
	 * @param name The name of the soap item.
	 */
	public Soap(String name) {
		super(name, RetailItemType.SOAP);
	}

	
}
