import card.*;
import strategii.*;

public class Main {
	public static void main(String argv[]) {
		char []numar1 = {'4', '8', '3', '7', '1', '5', '0', '6', '9', '2', '3', '8', '4', '7', '5', '1'};
		char []numar2 = {'9', '0', '2', '6', '5', '8', '3', '4', '1', '7', '6', '0', '9', '2', '8', '5'};
		char []numar3 = {'2', '5', '8', '1', '5', '7', '9', '3', '6', '0', '4', '5', '2', '7', '8', '1'};
		char []control1 = {'2', '1', '1'};
		char []control2 = {'5', '4', '1'};
		CardBancar card1, card2, card3;
		card1 = new Visa("Vladimir", numar1, control1);
		card2 = new Maestro("Alex", numar2);
		card3 = new MasterCard("Bogdan", numar3, control2);
		Strategie strategie1, strategie2;
		strategie1 = new StrategieA("Vladimir");
		strategie2 = new StrategieB();
		//Coada coadaCarduri = new Coada(-3); -> genereaza exceptie
		Coada coadaCarduri = new Coada(3);
		//coadaCarduri.scoateCard(); -> genereaza exceptie
		coadaCarduri.adaugaCard(card1);
		coadaCarduri.adaugaCard(card2);
		coadaCarduri.adaugaCard(card3);
		//coadaCarduri.adaugaCard(card3); -> genereaza exceptie
		System.out.println(coadaCarduri);
		CardBancar cardScos;
		cardScos = coadaCarduri.scoateCard();
		System.out.println(coadaCarduri);
		System.out.println(coadaCarduri.esteInCoada(strategie1));
		System.out.println();
		System.out.println(coadaCarduri.esteInCoada(strategie2));
	}
}