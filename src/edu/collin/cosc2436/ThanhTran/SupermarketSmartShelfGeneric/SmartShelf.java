package edu.collin.cosc2436.ThanhTran.SupermarketSmartShelfGeneric;

import java.util.ArrayList;

import edu.collin.cosc2436.ThanhTran.SupermarketSmartShelf.OutOfStockException;

/**
 * Represents a smart shelf in a supermarket that can be accessed by both customers and employees.
 *
 * @param <T> the type of RetailItem stored on the shelf
 */
public class SmartShelf<T extends RetailItem> implements IShelfCustomer<T>, IShelfEmployee<T> {

	private final String itemType;
    private ArrayList<T> items = new ArrayList<>();

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
     *
     * @param items the ArrayList of RetailItems to be sorted
     */
    @Override
    public void placeItems(ArrayList<T> items) {
    	for(T item:items) {
    		this.items.add(item);
    	}
        quickSort(this.items, 0, this.items.size() - 1);
    }

    /**
     * Adds an item to the shelf in the correct position.
     *
     * @param item the item to be added to the shelf
     */
    @Override
    public void addItem(T item) {
    	// add item correctly by using binarySearch for the index instead of quicksearch again. 
        int index = binarySearch(item,this.items);
//        System.out.println(index);
        if (index < items.size() || items.get(index).compareTo(item)==0) {
             // index of the first element greater than the key
        	this.items.add(index, item);
        }
        

    }

    /**
     * Finds and removes an item with the given name from the shelf.
     *
     * @param itemName the name of the item to be removed
     * @return the item that was removed from the shelf
     * @throws OutOfStockException if the item is not found on the shelf
     */
    @Override
    public T findAndTake(String itemName) throws OutOfStockException {
    	RetailItem item = new RetailItem(itemName);
        int index = binarySearch(item,items);
        if (index < items.size() && items.get(index).compareTo(item)==0) {
        	return items.remove(index);
            
        } else {
        	throw new OutOfStockException(item.getName());
        }
    }

    /**
     * Returns a string representation of the items on the shelf.
     *
     * @return a string representation of the items on the shelf
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n"+itemType+" Shelf:\n");
        for (RetailItem item : items) {
            sb.append("\t").append(item.getName()).append("\n");
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
    private static<T extends RetailItem> void quickSort(ArrayList<T> items, int lo, int hi) {
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

    private static<T extends RetailItem> int partition(ArrayList<T> items, int lo, int hi) {
    	int pivotIndex = lo + (int)(Math.random()*(hi-lo+1)); 
    	RetailItem pivot = items.get(pivotIndex);
    	swap(items,lo,pivotIndex);
    	int i = lo + 1; // i put pivot to lo index so my i index should be on the right of pivot
    	for(int j =lo+1;j<=hi;j++) {
    		// If current element is smaller than the pivot
    		if(items.get(j).compareTo(pivot)<0) {
    			swap(items,i,j);
    			// index of smaller element get incremented
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
	private static<T extends RetailItem> void swap(ArrayList<T> items, int i, int j) {
	    T temp = items.get(i);
	    items.set(i, items.get(j));
	    items.set(j, temp);
	}

	/**
	 * Searches the list of RetailItems for an item with the given name
	 *
	 * @param itemName the name of the item to search for
	 * @return the index of the item if found, or the index of the first element greater than the key if not found
	 */
	private static<T extends RetailItem> int binarySearch(RetailItem item,ArrayList<T> items2) {
		int lo = 0;
		int hi = items2.size()-1;
		
			// is there a way to implement sublist so we could do return (cmp>0) ? binarySearch(upperBound): binarySearch(lowerBound)
        	while (lo <= hi) {
        		int mid = lo + (hi - lo) / 2;
    	        int cmp = item.compareTo(items2.get(mid));
    	        if(cmp ==0) {
    	        	return mid; // found item
    	        }
    	        else if(cmp >0) { // greater than the mid points
    	        	lo = mid+1;
    	        }
    	        else if(cmp<0) {
    	        	hi=mid-1; // smaller than the mid points
    	        }
    	    }
    	    return lo; 
	    
	}
	
	/**
	 *Getting the shelf name
	 */
	@Override
	public String getShelfName() {
		// TODO Auto-generated method stub
		return itemType;
	}

	

}




