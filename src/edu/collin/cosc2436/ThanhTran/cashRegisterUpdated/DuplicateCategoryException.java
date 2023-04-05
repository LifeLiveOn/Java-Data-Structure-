package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;
/**
Thrown when a category with the same taxing status already exists in the system.
*/
public class DuplicateCategoryException extends Exception {

	public DuplicateCategoryException() {
		super("This category taxing status is already exists");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
