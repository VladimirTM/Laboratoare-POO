package card;

public class Maestro extends CardBancar {
	public Maestro(String nume, char numar[]) {
		super(nume, numar);
	}

	public String toString() {
		String string = "Card Maestro: nume - " + super.getNume() + " numar - ";
		for (int i = 0; i < 16; i++) {
			string = string + super.getNumar()[i];
		}
		return string;
	}
}