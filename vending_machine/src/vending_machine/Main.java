package vending_machine;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = 1, m=1;
		System.out.println("Welcome to Emre's Super Vending Machines!");
		System.out.println(" ");
		System.out.println("I sense that you are hungry or thirsty...");
		System.out.println(" ");
		
		
		try {
			List<String> allLines1 = Files.readAllLines(Paths.get("okunacak1.txt"));
			List<String> allLines2 = Files.readAllLines(Paths.get("okunacak2.txt"));
			
			Product[] productListDrinks = new Product[allLines1.size()];
			Product[] productListSnacks = new Product[allLines2.size()];
			
			for (String line : allLines1) {
				String[] columns = line.split(",");
				double p = Double.parseDouble(columns[1]);
				int q = Integer.parseInt(columns[2]);
				Product newProduct = new Product(n, columns[0] , p ,q);
				productListDrinks[n-1] = newProduct;
				n++;
				
			}
			for (String line : allLines2) {
				String[] columns = line.split(",");
				double p = Double.parseDouble(columns[1]);
				int q = Integer.parseInt(columns[2]);
				Product newProduct = new Product(m, columns[0] , p ,q);
				productListSnacks[m-1] = newProduct;
				m++;
				
			}
			VendingMachine vendingmachine1 = new TextBasedVendingMachine(productListDrinks , productListSnacks);

			while(true) {
				vendingmachine1.displayEntranceMessage();
				String selectProductType = scanner.nextLine();
				int mr1 =0;
				if(selectProductType.equals("a")) {
					
					vendingmachine1.displayProductsDrinks();
					while(true){
						vendingmachine1.displayEnterCoinsMessage();
						String enteredd = scanner.nextLine();
						double enteredCoins = Double.parseDouble(enteredd);
						if(enteredCoins==-1) break;
	
						vendingmachine1.entercoins(enteredCoins);
						while(true){
							vendingmachine1.displayChangeMessage();
						
							String selectProductNumber = scanner.nextLine();
							int selectedProductNumber = Integer.parseInt(selectProductNumber);
							if (selectedProductNumber == 0) break;
		
							mr1 = vendingmachine1.selectProductDrinks(selectedProductNumber);
							System.out.println(" ");
							if(mr1!=2) break;
						}
						if(mr1!=1) break;
					}
				}
				
				else if(selectProductType.equals("b")) {
					vendingmachine1.displayProductsSnacks();
					while(true){	
						vendingmachine1.displayEnterCoinsMessage();
						String enteredd = scanner.nextLine();
						double enteredCoins = Double.parseDouble(enteredd);
						if(enteredCoins==-1) break;
						vendingmachine1.entercoins(enteredCoins);
						while(true) {
							vendingmachine1.displayChangeMessage();
							String selectProductNumber = scanner.nextLine();
							int selectedProductNumber = Integer.parseInt(selectProductNumber);
							if (selectedProductNumber == 0) break;
							mr1 = vendingmachine1.selectProductSnacks(selectedProductNumber);
							System.out.println(" ");
							if(mr1!=2) break;
						}
						if(mr1!=1) break;
					}
				}
				else {
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thank you for your business!");

		scanner.close();
		
	}
}
