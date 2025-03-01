package strategii;

import card.CardBancar;

public class StrategieB implements Strategie {
	public boolean conditie(CardBancar card) {
		int contor = 0;
		char[] numar = card.getNumar();
		for (int i = 0; i < 16; i++) {
			if (numar[i] == '5') {
				contor++;
			}
		}
		return contor == 3;
	}
}