package projeto_final_bloco_01.model;

public class BoardGame extends Product{
	private float boardWidth;
	private float boardLength;
	private boolean dice;
	
	public BoardGame(int id, int quantity, int type, String name, String description, float price, float boardWidth, float boardLength, boolean dice) {
		super(id, quantity, type, name, description, price);
		this.boardWidth = boardWidth;
		this.boardLength = boardLength;
		this.dice = dice;
	}

	public float getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(float boardWidth) {
		this.boardWidth = boardWidth;
	}

	public float getBoardLength() {
		return boardLength;
	}

	public void setBoardLength(float boardLength) {
		this.boardLength = boardLength;
	}

	public boolean getDice() {
		return dice;
	}

	public void setDice(boolean dice) {
		this.dice = dice;
	}
	
	public void rules(String rules) {
		System.out.println("Game default start with no modifications");
	}
	
	public void rules(String rules, String addOn) {
		System.out.println("Game start with add-ons! The rules are: "+ rules + "\nThe addOn rules are: " + addOn);
	}
	
	@Override
	public void visualize() {
		super.visualize();
		System.out.println("Board Width (cm): " + this.boardWidth);
		System.out.println("Board Length (cm): " + this.boardLength);
		System.out.println("Is there a dice? " + this.dice);
	}
}
