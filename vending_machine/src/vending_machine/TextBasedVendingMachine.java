package vending_machine;

public class TextBasedVendingMachine implements VendingMachine{

	private int selectedProduct;
	private double change;
	private Product[] productListDrinks ;
	private Product[] productListSnacks ;
	
	
	TextBasedVendingMachine(Product[] productListDrinks , Product[] productListSnacks){
		this.productListDrinks = productListDrinks;
		this.productListSnacks = productListSnacks;
		change=0;
	}
	
	
	@Override
	public void displayEntranceMessage() {
		
		System.out.println("Please select a vending machine:");
		System.out.println("A- Drinks,  B- Snacks,  X- Exit:");
	}
	
	
	@Override
	public void displayProductsDrinks() {
		int itemNumber = 1;
		
		
		for(Product product: productListDrinks) {
			System.out.println(" " + itemNumber + "		" + product.getName() + "	" + product.getPrice() + "		" + product.getQuantity());
			itemNumber++;
		}
		
		System.out.println(" ");
		
	}
	
	@Override
	public void displayProductsSnacks() {
		int itemNumber = 1;
		
		
		for(Product product: productListSnacks) {
			System.out.println(" " + itemNumber + "		" + product.getName() + "	" + product.getPrice() + "		" + product.getQuantity());
			itemNumber++;
		}
		
		System.out.println(" ");
		
	}

	@Override
	public int selectProductDrinks(int product) {
		
		this.selectedProduct = product;
		if(change>=(productListDrinks[selectedProduct-1].getPrice()) && productListDrinks[selectedProduct-1].getQuantity() >0 ) {
			change-=(productListDrinks[selectedProduct-1].getPrice());
			productListDrinks[selectedProduct-1].setQuantity();

			System.out.println("You bought " + productListDrinks[selectedProduct-1].getName() + " " + productListDrinks[selectedProduct-1].getPrice() + " your change is " + change + "." );
			return 0;
		}
		else if(change<(productListDrinks[selectedProduct-1].getPrice())) {
			System.out.println("You don't have enough money. Please add more money or exit");
			return 1;
		}
		else if(productListDrinks[selectedProduct-1].getQuantity() <=0) {
			System.out.println("Sorry, the machine is currently out of that item.");

			return 2;
		}
		return 11;
		
	}
	
	@Override
	public int selectProductSnacks(int product) {
		
		this.selectedProduct = product;
		if(change>(productListSnacks[selectedProduct-1].getPrice()) && productListSnacks[selectedProduct-1].getQuantity() >0 ) {
			change-=(productListSnacks[selectedProduct-1].getPrice());
			productListSnacks[selectedProduct-1].setQuantity();

			System.out.println("You bought " + productListSnacks[selectedProduct-1].getName() + " " + productListSnacks[selectedProduct-1].getPrice() + " your change is " + change + "." );
			return 0;
		}
		
		else if(change<(productListSnacks[selectedProduct-1].getPrice())) {
			System.out.println("You don't have enough money. Please add more money or exit");
			return 1;
		}
		else if(productListSnacks[selectedProduct-1].getQuantity() <=0) {
			System.out.println("Sorry, the machine is currently out of that item.");
			return 2;
		}
		return 11;
		
	}

	@Override
	public void displayEnterCoinsMessage() {
		System.out.println("Please enter some money into the machine.(Enter -1 to exit) : ");

		
	}

	@Override
	public void entercoins(double coin) {

		change += coin ;
		
	}
	
	@Override
	public void displayChangeMessage() {
		System.out.println("You now have " + change + " to spend. Please make a selection (enter 0 to exit)" );

		
	}
	
}
