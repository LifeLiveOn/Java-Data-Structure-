package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import edu.collin.cosc2436.ThanhTran.SupermarketPromotions.*;
/**
 * The CashRegisterDemo demonstrating the
 * functionality a supermarket with a register machine, transaction, promotion for individual items.
 */
public class CashRegisterDemo {
	public static void main(String[] args) throws MissingCategoryException, MissingItemException, DuplicateCategoryException {
		
		RetailItemLookup config = new RetailItemLookup(0.0825);
		
		
		config.addPricingCategory(RetailItemType.CEREAL, false);
		config.addPricingCategory(RetailItemType.CHIPS, false);
		config.addPricingCategory(RetailItemType.SODA, true);
		config.addPricingCategory(RetailItemType.SOAP, true);
		System.out.println("\n");
		
		
		ArrayList<Cereal> cerealList = new ArrayList<>();
		Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/cereal.txt"));
		while (scanner.hasNext()) {
			cerealList.add(new Cereal(scanner.nextLine()));
		}
		scanner.close();

		// Read items from the chips.txt file and add to ArrayList
		ArrayList<Chips> chipList = new ArrayList<>();
		scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/chips.txt"));
		while (scanner.hasNext()) {
			chipList.add(new Chips(scanner.nextLine()));
		}
		scanner.close();
		
		// Read items from the soda.txt file and add to ArrayList
		ArrayList<Soda> sodaList = new ArrayList<>();
		scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/soda.txt"));
		while (scanner.hasNext()) {
			sodaList.add(new Soda(scanner.nextLine()));
		}
		scanner.close();		
				// Read items from the soap.txt file and add to ArrayList
		ArrayList<Soap> soapList = new ArrayList<>();
			scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream("/soap.txt"));
		while (scanner.hasNext()) {
			soapList.add(new Soap(scanner.nextLine()));
		}
		scanner.close();
		
		//iterating over each list to add each item in the provided list with a random generated price.
		addItemEntries(cerealList, config);
		addItemEntries(chipList, config);
		addItemEntries(sodaList, config);
		addItemEntries(soapList, config);
		System.out.println("\n");
		
		Promotion promo1 = new Promotion("Halloween", 10, LocalDate.parse("2024-11-28")); 
		Promotion promo3 = new Promotion("ThanksGiving", 20, LocalDate.parse("2024-11-28")); 
		Promotion promo2 = new Promotion("Columbus", 5, LocalDate.parse("2021-11-28"));// expired
		
		//Add all chips and sodas to the first promo
		promo1.addAddItems(chipList);
		addEvenItems(chipList,promo3);
		
		promo1.addAddItems(sodaList);
		addEvenItems(sodaList,promo3);
		
		//all cereals and soaps to the second promo
		promo2.addAddItems(cerealList);
		addEvenItems(cerealList,promo3);
		promo2.addAddItems(soapList);
		addEvenItems(soapList,promo3);
		
		ActivePromotions activePromos = new ActivePromotions();
		activePromos.addPromo(promo1);
		activePromos.addPromo(promo2);
		activePromos.addPromo(promo3);
		
		 // Instantiate a CashRegister object and test it with three separate transactions
		CashRegister.promotions = activePromos;
		CashRegister.setRetailItemLookup(config);
		CashRegister cashRegister = new CashRegister();
		
		// First transaction: all untaxable
		cashRegister.startTransaction();
		cashRegister.scanItem(new Chips("Pringles"));
		cashRegister.scanItem(new Cereal("Cape Cod"));
		cashRegister.scanItem(new Cereal("Reese's Puffs"));
		cashRegister.displayReceipt();
		
		// all taxable
		cashRegister.startTransaction();
		cashRegister.scanItem(new Soap("Olay"));
		cashRegister.scanItem(new Soda("Fanta"));
		cashRegister.displayReceipt();
		
		//some of each
		cashRegister.startTransaction();
		cashRegister.scanItem(new Chips("Tostitos"));
		cashRegister.scanItem(new Cereal("Apple Jacks"));
		cashRegister.scanItem(new Soap("Aveeno"));
		cashRegister.scanItem(new Soda("Sprite"));
		cashRegister.displayReceipt();
		
		//remove expired
		
		activePromos.removeExpiredPromotion();
		System.out.println();
		cashRegister.displayReceipt();
		
	}
	
	/**

	This helper function adds all the even-indexed elements in the given ArrayList of RetailItems
	to a specific promotion.
	@param items an ArrayList of RetailItems
	@param promo the promotion to which the even-indexed items will be added
	@return void
	*/
	public static <T extends RetailItem> void addEvenItems(ArrayList<T> items,Promotion promo) {
		for( int i =0 ; i < items.size();i++) {
			if((i)%2==0) {
				promo.addItem(items.get(i));
			}
		}
	}
	
	/**

	Adds each item in the provided list to the RetailItemLookup with a randomly generated price.
	@param items the list of items to add to the RetailItemLookup
	@param config the RetailItemLookup to add the items to
	@throws MissingCategoryException if the item being added does not have a category defined in the RetailItemLookup
	*/
	public static <T extends RetailItem> void addItemEntries(ArrayList<T> items, RetailItemLookup config) {
		Random rand = new Random();
	    for (T item : items) {
	        try {
				config.addItemEntry(item, (rand.nextInt(300) + 200) / 100.0);
			} catch (MissingCategoryException e) {
				e.printStackTrace();
			}
	    }
	    System.out.println();
	}
	
	
	// im trying to make a helper function so i don't have to copy those code over again, do you have any suggestion
//	private static <T extends RetailItem> void readItemsFromFile(String filename, ArrayList<T> items) {
//		items = new ArrayList<>();
//	    try (Scanner scanner = new Scanner(SmartShelfDemo.class.getResourceAsStream(filename))) {
//	        while (scanner.hasNext()) {
//	        	items.add(new T(scanner.nextLine()));
//	        }
//	    }
//	}


}

