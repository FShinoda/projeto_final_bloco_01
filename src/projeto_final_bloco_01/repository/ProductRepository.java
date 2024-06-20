package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Product;

public interface ProductRepository {
	
	// CRUD
	public void searchById(int id);
	public void listAll();
	public void register(Product product);
	public void update(Product product);
	public void delete(int id);
}
