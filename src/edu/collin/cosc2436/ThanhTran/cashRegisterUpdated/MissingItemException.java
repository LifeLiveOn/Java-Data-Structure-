package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
/**
Exception for when a RetailItem is missing from the inventory.
*/
public class MissingItemException  extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * A MissingItemException with a message indicating that the specified RetailItem is missing.
	 * 
	 * @param item the RetailItem that is missing from the inventory
	 */
	public MissingItemException (RetailItem item) {
		super(item.getName()+" not found");
	}

}
