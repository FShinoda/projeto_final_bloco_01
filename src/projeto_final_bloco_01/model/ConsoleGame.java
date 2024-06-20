package projeto_final_bloco_01.model;

public class ConsoleGame extends Product{
	private String consoleName;
	private String mediaType;
	
	
	public ConsoleGame(int id, int quantity, int type, String name, String description, float price) {
		super(id, quantity, type, name, description, price);
	}
	
	public String getConsoleName() {
		return this.consoleName;
	}
	
	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}
	
	public String getMediaType() {
		return this.mediaType;
	}
	
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
	@Override
	public void visualize() {
		super.visualize();
		System.out.println("For Console: " + this.consoleName);
		System.out.println("Media type: " + this.mediaType);
	}
	
	
}
