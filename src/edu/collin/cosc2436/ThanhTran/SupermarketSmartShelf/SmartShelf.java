package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf;

import java.util.ArrayList;

/**
 * Represents a smart shelf in a supermarket that can be accessed by both customers and employees.
 */
public class SmartShelf implements IShelfCustomer, IShelfEmployee {

    @SuppressWarnings("unused")
	private final String itemType;
    private ArrayList<RetailItem> items = new ArrayList<>();

    /**
     * Constructs a smart shelf with the given item type.
     *
     * @param name the type of item stored on the shelf
     */
    public SmartShelf(String name) {
        itemType = name;
    }

    /**
     * Sorts the items on the shelf using the quicksort algorithm.
     */
    @Override
    public void placeItems() {
        quickSort(items, 0, items.size() - 1);
    }

    /**
     * Adds an item to the shelf in the correct position.
     *
     * @param item the item to be added to the shelf
     */
    @Override
    public void addItem(RetailItem item) {
    	// add item correctly by using binarySearch for the index instead of quicksearch again. 
        int index = binarySearch(item.getName(), 0, items.size() - 1);
        if (index < 0) {
            index = -(index + 1); // index of the first element greater than the key
        }
        items.add(index, item);

    }

    /**
     * Finds and removes an item with the given name from the shelf.
     *
     * @param itemName the name of the item to be removed
     * @return the item that was removed from the shelf
     * @throws OutOfStockException if the item is not found on the shelf
     */
    @Override
    public RetailItem findAndTake(String itemName) throws OutOfStockException {
        int index = binarySearch(itemName, 0, items.size() - 1);
        if (index < 0) {
            throw new OutOfStockException(itemName);
        } else {
            return items.remove(index);
        }
    }

    /**
     * Returns a string representation of the items on the shelf.
     *
     * @return a string representation of the items on the shelf
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RetailItem item : items) {
            sb.append(item.getName()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Sorts an array list of retail items using the quicksort algorithm.
     *
     * @param items the array list of items to be sorted
     * @param lo the index of the first element in the array list
     * @param hi the index of the last element in the array list
     */
    private static void quickSort(ArrayList<RetailItem> items, int lo, int hi) {
        if (lo < hi) {
            int pivotIndex = partition(items, lo, hi);
            quickSort(items, lo, pivotIndex - 1);
            quickSort(items, pivotIndex + 1, hi);
        }
    }

    /**
     * Partitions an array list of retail items using the quicksort algorithm.
     *
     * @param items the array list of items to be partitioned
     * @param lo the index of the first element in the array list
     * @param hi the index of the last element in the array list
     * @return the index of the pivot element
     */

    private static int partition(ArrayList<RetailItem> items, int lo, int hi) {
    	int pivotIndex = lo + (int)(Math.random()*(hi-lo+1)); 
    	RetailItem pivot = items.get(pivotIndex);
    	swap(items,lo,pivotIndex);
    	int i = lo+1;
    	for(int j =lo+1;j<=hi;j++) {
//    		indicate arr[i] < pivot
    		if(items.get(j).CompareTo(pivot)<0) {
    			swap(items,i,j);
    			i++;
    		}
    	}
    	swap(items,lo,i-1);
    	return i-1;
    	}

	
	/**
	 * Swaps the elements at the specified indices in the given list.
	 *
	 * @param items the list of RetailItems
	 * @param i the index of the first element to be swapped
	 * @param j the index of the second element to be swapped
	 */
	private static void swap(ArrayList<RetailItem> items, int i, int j) {
	    RetailItem temp = items.get(i);
	    items.set(i, items.get(j));
	    items.set(j, temp);
	}

	/**
	 * Searches the list of RetailItems for an item with the given name using
	 * binary search algorithm.
	 *
	 * @param itemName the name of the item to search for
	 * @param lo the lowest index of the range to search in
	 * @param hi the highest index of the range to search in
	 * @return the index of the item if found, or the index of the first element greater than the key if not found
	 */
	private int binarySearch(String itemName, int lo, int hi) {
	    while (lo <= hi) {
	        int mid = lo + (hi - lo) / 2;
	        int cmp = itemName.compareTo(items.get(mid).getName());
	        if (cmp < 0) {
	            hi = mid - 1;
	        } else if (cmp > 0) {
	            lo = mid + 1;
	        } else {
	            return mid;
	        }
	    }
	    return -(lo + 1); // key not found, return the index of the first element greater than the key
	}

	

}




