package projeto_final_bloco_01.model;

public abstract class Product {
	private int id;
	private int type;
	private int quatity;
	private String name;
	private String description;
	private float price;
	
	public Product(int id, int quatity, int type, String name, String description, float price) {
		this.id = id;
		this.quatity = quatity;
		this.name = name;
		this.type = type;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void visualize() {
		String type = "";
		
		switch(this.type) {
			case 1:
				type = "Card Game";
				break;
			case 2:
				type = "Board Game";
				break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Product Data:");
		System.out.println("***********************************************************");
		System.out.println("Product ID: " + this.id);
		System.out.println("Name:" + this.name);
		System.out.println("Game Type: " + type);
		System.out.println("Description: " + this.description);
		System.out.printf("Price: %.2f\n", this.price);
	}
}
