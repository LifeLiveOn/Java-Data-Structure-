package edu.collin.cosc2436.ThanhTran.SupermarketPromotions;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * A demo class that demonstrates the use of the promotions with retail item
 */
public class PromotionDemo {
	public static void main(String[] args) {
		// Read items from the cereal.txt file and add to ArrayList
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

		// Create three promotions with different names, discounts and expiration dates. One promotion should be expired. 
		Promotion promo1 = new Promotion("Halloween", 10, LocalDate.parse("2024-11-28")); 
		Promotion promo3 = new Promotion("ThanksGiving", 20, LocalDate.parse("2024-11-28")); 
		Promotion promo2 = new Promotion("Columbus", 5, LocalDate.parse("2021-11-28"));// expired

		
		// Add cereal items to promotion 2 and even cereal to promotion 3
		promo2.addAddItems(cerealList);
		for( int i =0 ; i < cerealList.size();i++) {
			if((i)%2==0) {
				promo3.addItem(cerealList.get(i));
			}
		}
		
		//add chip items to promotion 1 and  even chip element to promotion 3
		promo1.addAddItems(chipList);
		for( int i =0 ; i < chipList.size();i++) {
			if((i)%2==0) {
				promo3.addItem(chipList.get(i));
			}
		}


		ActivePromotions activePromos = new ActivePromotions();
		activePromos.addPromo(promo1);
		activePromos.addPromo(promo2);
		activePromos.addPromo(promo3);

		// Print the best promotions for the cereal list and the chip list
		System.out.println("Cereal: ");
		printBestPromos(cerealList, activePromos);
		System.out.println("\n");
		System.out.println("Chips: ");
		printBestPromos(chipList, activePromos);
		
		
		//remove expired
		System.out.println("\nRemoved expired \n");
		activePromos.removeExpiredPromotion();
		System.out.println("Cereal: ");
		printBestPromos(cerealList, activePromos);
		System.out.println("\n");
		System.out.println("Chips: ");
		printBestPromos(chipList, activePromos);

		// removing thanks giving promotion
		System.out.println("\nRemoved Thanksgiving \n");
		activePromos.removePromo("ThanksGiving");
		System.out.println("Cereal: ");
		printBestPromos(cerealList, activePromos);
		System.out.println("\n");
		System.out.println("Chips: ");
		printBestPromos(chipList, activePromos);
	}
	
	/**
	 * Prints the best active promotion for each item in the given list of items.
	 * For each item, this method finds the promotion that provides the highest discount and prints its details. 
	 * If no active promotion is found, it prints "No active promo" for that item.
	 * @param items the list of items to find the best promotions for
	 * @param promos the list of active promotions to consider
	 * @param <T> the type of the items in the list which extend from RetailItem
	 */
	public static <T extends RetailItem>  void  printBestPromos(List<T> items,ActivePromotions  promos) {
		for(T item : items) {
			Promotion bestPromo = promos.findBestPromotion(item);
			if(bestPromo != null) {
				//				System.out.println(item.getName()+"\t\t\t"+bestPromo.getName() + "\t"+ "Expires: " +bestPromo.getExpireDate() + "\t" + bestPromo.getDiscountPer()+"%" );
				System.out.printf("%-30s%-15s%-25s%d%%%n", item.getName(), bestPromo.getName(),
						("Expires: "+ bestPromo.getExpireDate()), bestPromo.getDiscountPer());
			}
			else {
				System.out.printf("%-30s%-20s%n", item.getName(), "No active promo");
			}
		}
	}
}

