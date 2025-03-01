package strategii;

import card.CardBancar;

public interface Strategie {
	public boolean conditie(CardBancar card);
}