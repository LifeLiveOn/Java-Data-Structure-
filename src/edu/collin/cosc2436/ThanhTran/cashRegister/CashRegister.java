package edu.collin.cosc2436.ThanhTran.cashRegister;
import java.util.ArrayList; // import the ArrayList class
import java.text.DecimalFormat;

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
    * Computes the subtotal of the transaction by summing the prices of all purchased items.
    * @return The subtotal of the transaction.
    */
    private double computeSubTotal() {
        double subTotal = 0;
        for(RetailItem item:purchasedItems) {
            subTotal += RetailItemLookup.getItemsPrice(item);
        }
        return subTotal;
    }
 
    /**
    * Computes the tax of the transaction by summing the taxes of all purchased items.
    * @return The tax of the transaction.
    */
    private double computeTax() {
        double tax = 0;
        for(RetailItem item:purchasedItems) {
            tax += RetailItemLookup.computeTax(item);
        }
        return tax;
    }
 
    /**
    * Displays a receipt for the transaction, including a list of purchased items, subtotal, tax, and total.
    */
    public void displayReceipt() {
        for(RetailItem item:purchasedItems) {
            System.out.println(item.toString()+"\t"+" $ "+RetailItemLookup.getItemsPrice(item));
        }
        System.out.println();
        System.out.println("Subtotal "+"$ "+Format.format(computeSubTotal()));
        System.out.println("Tax "+"\t"+" $ "+Format.format(computeTax()));
    }
}
