package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;

import java.util.HashMap;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItemType;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;

/**
 * RetailItemLookup class is used to hold the tax rate and prices of retail items.
 * It also provides methods to get the tax rate, get the price of a specific item, and compute the tax for a specific item.
 */
public class RetailItemLookup {
    private final double taxRate;
    private final HashMap<RetailItemType,PricingCategory> categoryItemList;

    /**
     * Constructor for RetailItemLookup class
     * @param Rate - tax rate as a double
     */
    public RetailItemLookup(double Rate) {
        this.taxRate = Rate;
        categoryItemList = new HashMap<>();
    }
    
    /**
     * Add a new pricing category for a given RetailItemType
     * @param type - the RetailItemType to add the category for
     * @param status - whether the category is taxable or not
     * @throws DuplicateCategoryException if the category already exists
     */
    public void addPricingCategory(RetailItemType type, boolean status) throws DuplicateCategoryException {
    	
    	if (categoryItemList.containsKey(type)) {
    		throw new DuplicateCategoryException();
    	}
    	else {
    		PricingCategory item = new PricingCategory(status);
    		categoryItemList.put(type,item);
    		System.out.println("Added a pricing category for "+type);
    	}
    }
    
    /**
     * Remove a pricing category for a given RetailItemType
     * @param type - the RetailItemType to remove from the Price list
     */
    public void removePricingCategory(RetailItemType type) {
    	if(categoryItemList.containsKey(type)) {
    		categoryItemList.remove(type);
    	}
    	else {
    		System.out.println("The item does not exist");
    	}
    }
    
    /**
     * Add a new RetailItem entry with a specific price to the appropriate PricingCategory
     * @param item - the RetailItem to add
     * @param price - the price of the RetailItem
     * @throws MissingCategoryException if there is no PricingCategory for the given RetailItem
     */
    public void addItemEntry(RetailItem item, Double price) throws MissingCategoryException  {
    	if(checkCategory(item)) {
    		try {
				if(categoryItemList.get(item.getType()).findItemPrice(item)>0) {
					// item already exists, do nothing
				}
			} catch (MissingItemException e) {
				categoryItemList.get(item.getType()).addItem(item, price);
				System.out.println("Added "+ item.getName()+ ": $" + price+" to "+item.getType());
			}
    		
    	}
    }

    /**
     * Get the tax rate in double
     * @return tax rate 
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Get the price of a specific retail item
     * @param item - the retail item to get the price of
     * @return price of the item as a double
     * @throws MissingCategoryException 
     * @throws MissingItemException 
     */
    public double getItemsPrice(RetailItem item) throws MissingItemException {
        try {
			if(checkCategory(item)) {
				try {
					return categoryItemList.get(item.getType()).findItemPrice(item);
				} catch (MissingItemException e) {
					throw new MissingItemException(item);
				}	
			}
		} catch (MissingCategoryException e) {
			System.out.println(e);
		}
		return 0;
    }

    /**
     * Compute the tax for a specific retail item
     * @param item - the retail item to compute the tax for
     * @return tax amount as a double
     * @throws MissingCategoryException 
     */
    public double computeTax(RetailItem item) {
    	try {
			if(checkCategory(item)) {
					PricingCategory taxItem = categoryItemList.get(item.getType());
					if(taxItem.getStatus()) {

//        				System.out.println(taxItem.findItemPrice(item)*taxRate);
							try {
								return taxItem.findItemPrice(item)*taxRate;
							} catch (MissingItemException e) {
								System.out.println(e);
							}
					}
			}
		} catch (MissingCategoryException e) {
			System.out.println(e);
		}
		return 0;
    }
    
    /**
     * Checks if the item's category exists in the pricing category list.
     * @param item - the retail item to check the category of
     * @return true if the category exists, false otherwise
     * @throws MissingCategoryException if the category is missing in the list
     */
    private boolean checkCategory(RetailItem item) throws MissingCategoryException {
    	if(categoryItemList.containsKey(item.getType())) {return true;}
    	else {
    		throw new MissingCategoryException();
    	}
    }
}
