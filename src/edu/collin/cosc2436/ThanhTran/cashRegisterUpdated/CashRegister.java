package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;
import java.text.DecimalFormat;
import java.util.ArrayList; // import the ArrayList class
import java.util.Iterator;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.ActivePromotions;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.Promotion;
import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.RetailItem;
/**
* A CashRegister class representing a cash register used in a retail store.
* It uses a RetailItemLookup object to look up prices and tax rates for items.
* It also keeps track of a list of purchased items and can display a receipt for the transaction.
*/
public class CashRegister {
	/**
     * A static RetailItemLookup object that the class uses to look up prices and tax rates for items.
     */
    private static RetailItemLookup RetailItemLookup;
 
    /**
     * A list of RetailItem objects representing items that have been purchased.
     */
    private ArrayList<RetailItem> purchasedItems;
    
    static ActivePromotions promotions = new ActivePromotions();
 
    /**
     * A DecimalFormat object used to format prices for the receipt.
     */
    DecimalFormat Format = new DecimalFormat("0.00");
 
    /**
     * Sets the RetailItemLookup object used by the class to look up prices and tax rates for items.
     * @param config A RetailItemLookup object containing information about items and tax rates.
     */
    public static void setRetailItemLookup(RetailItemLookup config) {
        RetailItemLookup = config;
    }
 
    /**
     * Initializes a new transaction by creating a new ArrayList of purchased items.
     */
    public void startTransaction() {
        this.purchasedItems = new ArrayList<RetailItem>();
    }
 
    /**
     * Scans an item and adds it to the list of purchased items.
     * @param item A RetailItem object representing the item to be scanned.
     */
    public void scanItem(RetailItem item) {
        this.purchasedItems.add(item);
    }
    
    /**
     * Scans a list of items and adds them to the list of purchased items.
     * @param items An ArrayList of RetailItem objects representing the items to be scanned.
     * @param <T> A type parameter for the RetailItem class and its subclasses.
     */
    public <T extends RetailItem> void scanItems(ArrayList<T> items) {
        for (T item : items) {
            this.purchasedItems.add(item);
        }
    }
 
    /**
     * Computes the subtotal of the transaction by summing the prices of all purchased items.
     * @return The subtotal of the transaction.
     * @throws MissingItemException if an item is missing from the RetailItemLookup.
     */
    private double computeSubTotal() throws MissingItemException {
        double subTotal = 0;
        Promotion itemPromo;
        Double discountPrice;
        for (RetailItem item : purchasedItems) {
            itemPromo = promotions.findBestPromotion(item);
            if (itemPromo != null) {
                subTotal += RetailItemLookup.getItemsPrice(item);
                discountPrice = (Double.parseDouble(String.valueOf(itemPromo.getDiscountPer())) / 100) * RetailItemLookup.getItemsPrice(item);
                subTotal -= discountPrice;
            }
            else {
                subTotal += RetailItemLookup.getItemsPrice(item);
            }
        }
        return subTotal;
    }
 
    /**
    * Computes the tax of the transaction by summing the taxes of all purchased items.
    * @return The tax of the transaction. 
     * @throws MissingItemException If the item is missing from the inventory.
    */
    private double computeTax() throws MissingItemException {
        double tax = 0;
        Promotion itemPromo;
        Double discountPrice;
        for(RetailItem item:purchasedItems) {
        	itemPromo = promotions.findBestPromotion(item);
        	if(itemPromo!=null && RetailItemLookup.computeTax(item)>0) {
        			discountPrice = (Double.parseDouble(String.valueOf(itemPromo.getDiscountPer())) / 100) * RetailItemLookup.getItemsPrice(item);
                    tax += RetailItemLookup.computeTax(item);
                    tax -= discountPrice*RetailItemLookup.getTaxRate();       		
        	}
        	else {
        		tax += RetailItemLookup.computeTax(item);
        	}	
        }
        return tax;
    }
 
    /**
     * Displays a receipt for the transaction, including a list of purchased items, subtotal, tax, and total.
     * @throws MissingItemException     If the item is missing from the inventory.
     */
    public void displayReceipt() throws MissingItemException {
        StringBuilder sb = new StringBuilder();
        Iterator<RetailItem> node = purchasedItems.iterator();
        Promotion itemPromo;
        while(node.hasNext()) {
            RetailItem item = node.next();
            try {
                itemPromo = promotions.findBestPromotion(item);
                if(itemPromo != null) {
                    sb.append(String.format("%-15s%-15s%n", item.getName(), "$ " + Format.format(RetailItemLookup.getItemsPrice(item))));
                    double discountPrice = (Double.parseDouble(String.valueOf(itemPromo.getDiscountPer())) / 100) * RetailItemLookup.getItemsPrice(item);
                    sb.append(String.format("%-15s%-15s%n", "\sPromo: " + itemPromo.getName(), " -$ " + Format.format(discountPrice)));
                } else {
                    sb.append(String.format("%-15s%-15s%n", item.getName(), "$ " + Format.format(RetailItemLookup.getItemsPrice(item))));
                }
            } catch (MissingItemException e) {
                System.out.println(item.getName() + "\t" + e);
                node.remove();
            }
        }
        sb.append("\n");
        sb.append(String.format("%-15s%-15s%n", "Subtotal ", "$ " + Format.format(computeSubTotal())));
        sb.append(String.format("%-15s%-15s%n", "Tax ", "$ " + Format.format(computeTax())));
        sb.append(String.format("%-15s%-15s%n", "Total: ", "$ " + Format.format(computeSubTotal() + computeTax())));
        sb.append("----------------\n");
        System.out.println(sb.toString());
    }

}
