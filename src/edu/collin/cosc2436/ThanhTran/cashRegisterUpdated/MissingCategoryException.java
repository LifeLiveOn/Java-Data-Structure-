package edu.collin.cosc2436.ThanhTran.cashRegisterUpdated;
/**
Thrown when a category of an item does not exist in the system.
*/
public class MissingCategoryException extends Exception {
	public MissingCategoryException() {
		super("This category does not exist in this list");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
