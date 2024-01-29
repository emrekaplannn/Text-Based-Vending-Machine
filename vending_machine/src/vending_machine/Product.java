package vending_machine;

public class Product {
	
	private int id;
	private String productName;
	private double price;
	private int quantity;
	
	Product(int id , String productName, double price , int quantity  ){
		this.id = id;
		this.productName = productName ;
		this.price = price ; 
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity() {
		quantity-=1;
	}
	
	public String getName() {
		return productName;
	}
	
}
