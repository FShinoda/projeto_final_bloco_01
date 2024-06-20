package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Product;

public interface ProductRepository {
	
	public void searchById(int id);
	public void listAll();
	public void register(Product product);
	public void update(Product product);
	public void delete(int id);
	
	public void searchByName(String name);
	public void countProducts();
	public void listAllAlphabetic();
}
