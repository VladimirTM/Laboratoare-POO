package figura;
import observator.Observator;

public abstract class Figura {
	private String culoare;

	public Figura(String culoare) {
		this.culoare = culoare;
		Observator.instanta.adaugaFigura(this);
	}

	public abstract double perimetru();

	public String toString() {
		return culoare + ", " + this.perimetru() + "\n";
	}

	public abstract boolean equals(Object o);

	public void setCuloare(String culoareNoua) {
		culoare = culoareNoua;
		Observator.instanta.modificare();
	}
}
