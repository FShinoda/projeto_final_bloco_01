package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import projeto_final_bloco_01.model.Product;
import projeto_final_bloco_01.repository.ProductRepository;

public class ProductController implements ProductRepository {
	private ArrayList<Product> productList = new ArrayList<Product>();
	int id = 0;
	
	@Override
	public void searchById(int id) {
		var prod = searchInList(id);
		
		if(prod != null) {
			prod.visualize();
		} else {
			System.out.println("\n A product with ID " + this.id + " was not found.");
		}
	}

	@Override
	public void listAll() {
		try {
			for(var prod : productList) {
				prod.visualize();
			}			
		} catch (Exception e) {
			System.out.println("An Exception ocurred while listing the products: " + e.getMessage());
		}
	}

	@Override
	public void register(Product product) {
		productList.add(product);
		System.out.println("\n Product with ID " + product.getId() + " was successfully created!");
		
	}

	@Override
	public void update(Product product) {
		var prod = searchInList(id);
		
		if(prod != null) {
			productList.set(productList.indexOf(prod), product);
			System.out.println("\n Product with ID " + product.getId() + " was successfully updated!");
		} else {			
			System.out.println("\n Product with ID " + product.getId() + " not found.");
		}
		
	}

	@Override
	public void delete(int id) {
		var prod = searchInList(id);
		
		if(prod != null) {
			if(productList.remove(prod)) System.out.println("\n Product with ID " + id + " was successfully removed!");
		} else {			
			System.out.println("\n Product with ID " + id + " not found.");
		}
		
	}
	
	@Override
	public void searchByName(String name) {
		var p = searchInListByName(name);
		
		if(p != null) {
			p.visualize();
		} else {
			System.out.println("Product with name " + name + " not found.");
		}
	}
	
	@Override
	public void countProducts() {
		int count = productList.size();
		System.out.print("We currently have " + count + " different products");
	}
	
	@Override
	public void listAllAlphabetic() {
        ArrayList<Product> sortedProducts = new ArrayList<>(productList);

        // Sort the copy using a custom Comparator
        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        
		for(var prod : sortedProducts) {
			prod.visualize();
		}	
	}
	
	public Product searchInList(int id) {
		for(var prod : productList) {
			if(prod.getId() == id) {
				return prod;
			}
		}
		return null;
	}
	
	public Product searchInListByName(String name) {
		for(var prod : productList) {
			if(prod.getName().equalsIgnoreCase(name)) return prod;
		}
		
		return null;
	}
	
	public int generateId() {
		return ++id;
	}
	
}
