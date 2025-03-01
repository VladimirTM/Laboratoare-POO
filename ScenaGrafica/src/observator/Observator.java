package observator;
import java.util.*;
import figura.Figura;

public class Observator {
	public static Observator instanta = new Observator();
	private List<Figura> lista = new ArrayList<Figura>();
	
	public void adaugaFigura(Figura figura) {
		lista.add(figura);
	}
	
	public void modificare() {
		System.out.println(this);
	}
	
	public String toString() {
		String text = " ";
		for(Figura figura: lista) {
			text = text + figura + " ";
		}
		return text;
	}
}
