package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		
		do { 
			System.out.println("=".repeat(30));
			System.out.println("1 - Create product \n"
					+ "2 - List all products \n"
					+ "3 - Search product by id \n"
					+ "4 - Update product info \n"
					+ "5 - Delete product \n"
					+ "6 - Exit program");
			System.out.println("=".repeat(30));
			
			System.out.print("Type the desired option: ");
			option = sc.nextInt();
			
			System.out.print("\n");
			switch(option) {
				case 1 -> {
					System.out.println("Create product");
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
