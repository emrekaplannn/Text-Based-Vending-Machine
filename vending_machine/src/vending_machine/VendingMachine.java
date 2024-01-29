package vending_machine;

public interface VendingMachine {

	void displayEntranceMessage();
	
	void displayProductsDrinks();
	void displayProductsSnacks();
	
	int selectProductDrinks( int product);
	int selectProductSnacks(int product);

	
	void displayEnterCoinsMessage();
	
	void entercoins(double coin);
		
	void displayChangeMessage();

}
