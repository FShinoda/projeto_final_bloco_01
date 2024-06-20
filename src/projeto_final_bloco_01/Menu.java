package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProductController;
import projeto_final_bloco_01.model.BoardGame;
import projeto_final_bloco_01.model.CardGame;

public class Menu {

	public static void main(String[] args) {
		ProductController prod = new ProductController();
		Scanner sc = new Scanner(System.in);
		int id, quantity, type, cardQty;
		boolean dice = false, valid;
		float price, boardWidth, boardLength;
		String name, description;
		
		int option = 0;
		
		do { 
			System.out.println("=".repeat(30));
			System.out.println("1 - Create product \n"
					+ "2 - List all products \n"
					+ "3 - Search product by id \n"
					+ "4 - Update product info \n"
					+ "5 - Delete product \n"
					+ "6 - Search product by name \n"
					+ "7 - See how many products are avaible \n"
					+ "8 - List all products in alphabetic order \n"
					+ "9 - Exit program");
			System.out.println("=".repeat(30));
			
			try {
				System.out.print("Type the desired option: ");
				option = sc.nextInt();				
			} catch(InputMismatchException e) {
				System.out.println("\nType integer values!");
		    	sc.nextLine();
		    	option = 0;
			}
			sc.skip("\\R");
			System.out.print("\n");
			switch(option) {
				case 1 -> {
					System.out.println("Create product");
					
					System.out.println("Name: ");
					name = sc.nextLine();
					
					do {
						System.out.println("Type the product type (1-Card Game or 2-Board Game): ");
						type = sc.nextInt();
					} while (type < 1|| type > 2);
					sc.skip("\\R");
					
					System.out.println("Description: ");
					description = sc.nextLine();
					
					System.out.println("Quantity: ");
					quantity = sc.nextInt();
					sc.skip("\\R");
					
					System.out.println("Price: ");
					price = sc.nextFloat();
					
					switch(type) {
					case 1 -> {
						System.out.println("Card Qty: ");
						cardQty = sc.nextInt();
						
						prod.register(new CardGame(prod.generateId(), quantity, type, name, description, price, cardQty));
					}
					case 2 -> {
						System.out.println("Board Length (cm): ");
						boardLength = sc.nextFloat();
						
						System.out.println("Board Width (cm): ");
						boardWidth = sc.nextFloat();
						
						do {
							try {
								valid = true;
								System.out.println("Is there a dice in this board game? (true or false): ");
								dice = sc.nextBoolean();									
							} catch (InputMismatchException e) {
								System.out.println("[!] Please type a boolean value (true or false)");
								valid = false;
								sc.next();
							}
						} while (valid != true);
						
						prod.register(new BoardGame(prod.generateId(), quantity, type, name, description, price, boardWidth, boardLength, dice));
					}
				}
					
					keyPress();
				}
				case 2 -> {
					System.out.println("List all products");
					prod.listAll();
					keyPress();
				}
				case 3 -> {
					System.out.println("Search product");
					System.out.println("Type id to be searched: ");
					id = sc.nextInt();
					sc.skip("\\R");
					
					prod.searchById(id);
					keyPress();
				}
				case 4 -> {
					System.out.println("Update product info");
					System.out.println("Type id of the product to be updated: ");
					id = sc.nextInt();
					sc.skip("\\R");
					
					var p = prod.searchInList(id);
					
					if(p != null) {
						System.out.println("Name: ");
						name = sc.nextLine();
						
						do {
							System.out.println("Type the product type (1-Card Game or 2-Board Game): ");
							type = sc.nextInt();
						} while (type < 1|| type > 2);
						sc.skip("\\R");
						
						System.out.println("Description: ");
						description = sc.nextLine();
						
						System.out.println("Quantity: ");
						quantity = sc.nextInt();
						sc.skip("\\R");
						
						System.out.println("Price: ");
						price = sc.nextFloat();
						
						switch(type) {
							case 1 -> {
								System.out.println("Card Qty: ");
								cardQty = sc.nextInt();
								sc.skip("\\R");
								
								prod.update(new CardGame(id, quantity, type, name, description, price, cardQty));
							}
							case 2 -> {
								System.out.println("Board Length (cm): ");
								boardLength = sc.nextFloat();
								
								System.out.println("Board Width (cm): ");
								boardWidth = sc.nextFloat();
								
								do {
									try {
										valid = true;
										System.out.println("Is there a dice in this board game? (true or false): ");
										dice = sc.nextBoolean();									
									} catch (InputMismatchException e) {
										System.out.println("[!] Please type a boolean value (true or false)");
										valid = false;
										sc.next();
									}
								} while (valid != true);
								prod.update(new BoardGame(id, quantity, type, name, description, price, boardWidth, boardLength, dice));
							}
						}
					} else {
						System.out.println("\n Product not found.");
					}
					keyPress();
				}
				case 5 -> {
					System.out.println("Delete product");
					System.out.println("Type id of the product to be updated: ");
					id = sc.nextInt();
					sc.skip("\\R");
					
					var p = prod.searchInList(id);
					
					if(p != null) {
						prod.delete(id);
					} else {
						System.out.println("\n Product not found.");
					}
					keyPress();
				}
				case 6 -> {
					System.out.println("Search product by name");
					System.out.println("Type the name:");
					name = sc.nextLine();
					
					prod.searchByName(name);
					keyPress();
				}
				case 7 -> {
					System.out.println("See how many products are avaible: ");
					
					prod.countProducts();
					keyPress();
				}
				case 8 -> {
					System.out.println("List products in alphabetical order:");
					
					prod.listAllAlphabetic();
					keyPress();
				}
				case 9 -> {
					System.out.println("Exit Program");
					about();
				}
				default -> {
					System.out.println("[!] This option does not exist.");
					keyPress();
				}
			}
			System.out.print("\n");
		} while(option != 9);
		
		sc.close();
	}
	
	public static void about() {
		System.out.println("\n****************************************************************************************");
		System.out.println("Project made by: ");
		System.out.println("Fernanda Shinoda - fernanda.shinoda@hotmail.com - at Generation Bootcamp");
		System.out.println("github.com/fshinoda");
	    System.out.println("****************************************************************************************");
	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPress Enter to Continue...");
			System.in.read();
		} catch(IOException e) {
			System.out.println("This is not the Enter Key >:(");
		}
	}

}
