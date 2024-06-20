package projeto_final_bloco_01.model;

public class CardGame extends Product{
	private int cardQty;

	public CardGame(int id, int quatity, int type, String name, String description, float price, int cardQty) {
		super(id, quatity, type, name, description, price);
		this.cardQty = cardQty;
	}

	public int getCardQty() {
		return cardQty;
	}

	public void setCardQty(int cardQty) {
		this.cardQty = cardQty;
	}

	public void rules(String rules) {
		System.out.println("Game with "+ this.cardQty +" cards default start with no modifications. The rules are: " + rules);
	}
	
	public void rules(String rules, String addOn) {
		System.out.println("Game start with add-ons! The rules are: "+ rules + "\nThe addOn rules are: " + addOn);
	}
	
	@Override
	public void visualize() {
		super.visualize();
		System.out.println("Number of cards: " + this.cardQty);
	}
}
