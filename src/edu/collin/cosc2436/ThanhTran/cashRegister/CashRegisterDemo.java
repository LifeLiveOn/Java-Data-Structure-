package edu.collin.cosc2436.ThanhTran.cashRegister;

public class CashRegisterDemo {
	public static void main(String[] args) {
		double[] array = {2.49,3.25,1.79,2.99};
		RetailItemLookup config = new RetailItemLookup(0.0825,array);
		CashRegister.setRetailItemLookup(config);
		CashRegister cashRegister = new CashRegister();

		// First transaction: all groceries
		cashRegister.startTransaction();
		cashRegister.scanItem(RetailItem.SODA);
		cashRegister.scanItem(RetailItem.SOAP);

		cashRegister.displayReceipt();
		
		// Second transaction: all non-groceries
		cashRegister.startTransaction();
		cashRegister.scanItem(RetailItem.CEREAL);
		cashRegister.scanItem(RetailItem.CHIPS);
		
		cashRegister.displayReceipt();
		
		// Third transaction: some of each
		cashRegister.startTransaction();
		cashRegister.scanItem(RetailItem.SODA);
		cashRegister.scanItem(RetailItem.SOAP);
		cashRegister.scanItem(RetailItem.CEREAL);
		cashRegister.scanItem(RetailItem.CHIPS);
		
		cashRegister.displayReceipt();
		
	}
}
