package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;
import java.util.HashMap;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
/**
This class represents a pricing category that has a taxable status for the selected category and a collection of item prices.
*/
public class PricingCategory {
	private final boolean taxable;
	private final HashMap<RetailItem,Double> itemPrices;
	
	/**
	 * Constructor for creating a new pricing category with a given taxable status and an empty collection of item prices.
	 * @param status a boolean indicating whether the category is taxable
	 */
	public PricingCategory(boolean status) {
		taxable = status;
		itemPrices = new HashMap<>();
	}
	
	/**
	 * Returns the taxable status of the pricing category.
	 * @return a boolean indicating whether the pricing category is taxable
	 */
	public boolean getStatus() {
		return taxable;
	}
	
	/**
	 * Adds a new item to the pricing category with the given price.
	 * @param item the retail item to be added to the pricing category
	 * @param price the price of the retail item
	 */
	public void addItem(RetailItem item, Double price) {
		try {
			if(price>0) {
				itemPrices.put(item, price);
			}else {
				System.out.println("Invalid price, price must greater than 0");
			}
			
		}catch(Exception e) {
			System.out.println("error when adding item");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Finds the price of the given retail item in the pricing category.
	 * @param item the retail item to find the price for
	 * @return the price of the given retail item
	 * @throws MissingItemException if the given retail item is not found in the pricing category
	 */
	public double findItemPrice(RetailItem item) throws MissingItemException {
		if(itemPrices.containsKey(item)) {
			return itemPrices.get(item);
		}
		throw new MissingItemException(item);
	}
	
	/**
	 * Removes the given retail item from the pricing category.
	 * @param item the retail item to be removed
	 * @throws MissingItemException if the given retail item is not found in the pricing category
	 */
	public void removeItem(RetailItem item) throws MissingItemException{
		if(itemPrices.containsKey(item)) {
			itemPrices.remove(item);
			System.out.println(item.getName()+" is removed");
		}
		// if item not found
		else {
			throw new MissingItemException(item);
		}
		
		
	}
}