package strategii;

import card.CardBancar;

public class StrategieA implements Strategie {
	private String nume;

	public StrategieA(String nume) {
		this.nume = nume;
	}

	public boolean conditie(CardBancar card) {
		return nume.equals(card.getNume());
	}
}