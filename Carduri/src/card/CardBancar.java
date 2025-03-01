package card;

public class CardBancar {
	private String nume;
	private char[] numar;

	public CardBancar(String nume, char numar[]) {
		this.nume = nume;
		this.numar = numar;
	}

	public String getNume() {
		return nume;
	}

	public char[] getNumar() {
		return numar;
	}
}