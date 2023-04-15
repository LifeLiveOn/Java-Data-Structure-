/**
 * A Promotion represents a discount offer on one or more RetailItems during a certain period of time.
 * It can be added to a list of ActivePromotions, and RetailItems can be added to it to specify which items are part of the promotion.
 */
package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Promotion {
    private final String name;
    private final int discountPer;
    private final LocalDate expireDate;
    private final Set<RetailItem> promotionItems;

    /**
     * Constructor for Promotion class
     * @param name          the name of the promotion
     * @param percentage    the discount percentage of the promotion
     * @param date          the expiration date of the promotion
     */
    public Promotion(String name, int percentage, LocalDate date) {
        this.name = name;
        this.discountPer = percentage;
        expireDate = date;
        promotionItems = new HashSet<RetailItem>();
        System.out.println("Added promotion "+name+"\n");
    }

    /**
     * Returns the name of the promotion
     * @return the name of the promotion
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the expiration date of the promotion
     * @return the expiration date of the promotion
     */
    public LocalDate getExpireDate() {
        return expireDate;
    }

    /**
     * Returns the discount percentage of the promotion
     * @return the discount percentage of the promotion
     */
    public int getDiscountPer() {
        return discountPer;
    }

    /**
     * Returns the discount amount of the promotion for a given RetailItem
     * @param item the RetailItem to calculate the discount for
     * @return the discount amount for the given RetailItem, or 0 if the item is not part of the promotion
     */
    public int determineDiscount(RetailItem item) {
        if(promotionItems.contains(item)) {
            return  discountPer;
        }
        return 0;
    }

    /**
     * Adds a RetailItem to the promotion
     * @param item the RetailItem to add to the promotion
     */
    public void addItem(RetailItem item) {
        promotionItems.add(item);
    }

    /**
     * Checks if the promotion contains a given RetailItem
     * @param item the RetailItem to check for
     * @return true if the promotion contains the given RetailItem, false otherwise
     */
    public boolean hasItem(RetailItem item) {
        return promotionItems.contains(item);
    }

    /**
     * Adds multiple RetailItems to the promotion
     * @param items an ArrayList of RetailItems to add to the promotion
     */
    public <T extends RetailItem> void addAddItems(List<T> items ) {
        for(T item : items) {
            addItem(item);
        }
    }
}
