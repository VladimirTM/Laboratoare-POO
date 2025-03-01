import card.CardBancar;
import exceptii.DimensionException;
import exceptii.EmptyException;
import exceptii.SizeException;
import strategii.Strategie;

public class Coada {
	private CardBancar[] coadaCarduri;
	private int size;
	private int index;

	public Coada(int size) throws SizeException {
		if (size < 0)
			throw new SizeException("Dimensiune invalida !");
		this.size = size;
		coadaCarduri = new CardBancar[size];
	}

	public void adaugaCard(CardBancar card) throws DimensionException {
		if (index >= size)
			throw new DimensionException("Dimensiune depasita !");
		coadaCarduri[index++] = card;
	}

	public CardBancar scoateCard() throws EmptyException {
		if (index == 0)
			throw new EmptyException("Coada este goala !");
		CardBancar scos = coadaCarduri[0];
		for (int i = 0; i < index - 1; i++) {
			coadaCarduri[i] = coadaCarduri[i + 1];
		}
		coadaCarduri[--index] = null;
		return scos;
	}
	
	public String toString() {
		String text = "";
		for(int i = 0; i < index; i++) {
			text = text + coadaCarduri[i] + "\n";
		}
		return text;
	}

	public boolean esteInCoada(Strategie strategie) {
		for (int i = 0; i < index; i++) {
			if (strategie.conditie(coadaCarduri[i]) == true) {
				return true;
			}
		}
		return false;
	}
}