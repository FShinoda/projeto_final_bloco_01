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
		boolean dice, valid;
		float price, boardWidth, boardLength;
		String name, description;
		
		int option = 0;
		
		CardGame uno = new CardGame(0, 5, 1, "UNO", "card game to lose some friends", (float) 15.69, 64);
		uno.visualize();
		
		BoardGame monopoly = new BoardGame(1, 3, 2, "Monopoly", "a capitalism game", (float)200.44, (float)31.5, (float)31.5, true);
		monopoly.visualize();
		
		
		do { 
			System.out.println("=".repeat(30));
			System.out.println("1 - Create product \n"
					+ "2 - List all products \n"
					+ "3 - Search product by id \n"
					+ "4 - Update product info \n"
					+ "5 - Delete product \n"
					+ "6 - Exit program");
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
					
					System.out.println("Price: ");
					price = sc.nextFloat();
					
					keyPress();
				}
				case 2 -> {
					System.out.println("List all products");
					keyPress();
				}
				case 3 -> {
					System.out.println("Search product");
					keyPress();
				}
				case 4 -> {
					System.out.println("Update product info");
					keyPress();
				}
				case 5 -> {
					System.out.println("Delete product");
					keyPress();
				}
				case 6 -> {
					System.out.println("Exit Program");
					about();
				}
				default -> {
					System.out.println("[!] This option does not exist.");
					keyPress();
				}
			}
			System.out.print("\n");
		} while(option != 6);
		
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
