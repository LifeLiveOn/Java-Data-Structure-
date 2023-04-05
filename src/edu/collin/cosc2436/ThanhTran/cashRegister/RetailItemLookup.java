package edu.collin.cosc2436.ThanhTran.cashRegister;

import java.util.Arrays;

/**
 * @author scci123
 *
 * RetailItemLookup class is used to hold the tax rate and prices of retail items.
 * It also provides methods to get the tax rate, get the price of a specific item, and compute the tax for a specific item.
 */
public class RetailItemLookup {
    private final double taxRate;
    private final double[] pricesItem;

    /**
     * Constructor for RetailItemLookup class
     * @param Rate - tax rate as a double
     * @param array - array of prices for each retail item
     */
    public RetailItemLookup(double Rate, double[] array) {
        this.taxRate = Rate;
        pricesItem = Arrays.copyOf(array,array.length);
    }

    /**
     * Get the tax rate
     * @return tax rate as a double
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Get the price of a specific retail item
     * @param item - the retail item to get the price of
     * @return price of the item as a double
     */
    public double getItemsPrice(RetailItem item) {
        return pricesItem[item.ordinal()];
    }

    /**
     * Compute the tax for a specific retail item
     * @param item - the retail item to compute the tax for
     * @return tax amount as a double
     */
    public double computeTax(RetailItem item) {
        switch(item) {
            case SODA:
                return (pricesItem[item.ordinal()]*taxRate);
            case SOAP:
                return (pricesItem[item.ordinal()]*taxRate);
            case CHIPS:
                return 0;
            case CEREAL:
                return 0;
            default:
                System.out.println("cant find the item, cant compute tax");
                return 0;
        }
    }
}
