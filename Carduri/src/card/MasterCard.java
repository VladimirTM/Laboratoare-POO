package card;

public class MasterCard extends CardBancar {
	private char[] control;

	public MasterCard(String nume, char numar[], char control[]) {
		super(nume, numar);
		this.control = control;
	}

	public String toString() {
		String string = "Card MasterCard: nume - " + super.getNume() + " numar - ";
		for (int i = 0; i < 16; i++) {
			string = string + super.getNumar()[i];
		}
		string = string + " control - ";
		for (int i = 0; i < 3; i++) {
			string = string + control[i];
		}
		return string;
	}
}