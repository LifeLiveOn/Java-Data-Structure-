package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class ActivePromotions {
	private ArrayList<Promotion> promotionList;

    /**
     * Constructs an empty ActivePromotions object with an empty list of promotions.
     */
    public ActivePromotions() {
    	promotionList = new ArrayList<>();
    }
	
    /**
     * Adds the specified promotion to the list of active promotions.
     * @param promo the promotion to be added
     */
	public void addPromo(Promotion promo) {
		promotionList.add(promo);
	}
	
	/**
     * Removes the promotion with the specified name from the list of active promotions.
     * @param promoName the name of the promotion to be removed
     */
	public void removePromo(String promoName) {
		Iterator<Promotion> node = promotionList.iterator();
		while(node.hasNext()) {
			Promotion promo = node.next();
			if(promo.getName().equals(promoName)) {
				System.out.println("Removed promotion "+promoName+": expired on "+promo.getExpireDate());
				node.remove();
				
				break;
			}
		}
	}
	
	/**
     * Removes all expired promotions from the list of active promotions.
     */
	public void removeExpiredPromotion() {
		Iterator<Promotion> node = promotionList.iterator();
		while(node.hasNext()) {
			Promotion promo = node.next();
			if(promo.getExpireDate().isBefore(LocalDate.now())) {
				System.out.println("Removed promotion "+ promo.getName()+": expired on "+promo.getExpireDate());
				node.remove(); //remove the promotion that has expired date
				break;
			}
		}
	}
	
	/**
     * Finds the best promotion for a given item from the list of active promotions.
     * @param item the item for which to find the best promotion
     * @return the best promotion for the given item
     */
	public Promotion findBestPromotion(RetailItem item) {
		Promotion bestPromo = null;
		int bestDiscount = 0;
		// iter through arrayList to find the given item with best discount ( find max discount )
		for(Promotion promo : promotionList) {
			if((promo.getDiscountPer() > bestDiscount) && promo.hasItem(item)) {
				bestDiscount = promo.getDiscountPer();
				bestPromo = promo;
			}
		}
		return bestPromo;
	}
	
}

