package figura;

import observator.Observator;

public class Cerc extends Figura {
	private double raza;

	public Cerc(String culoare, double raza) {
		super(culoare);
		this.raza = raza;
	}

	public double perimetru() {
		return 2 * Math.PI * raza;
	}

	public String toString() {
		return "Cerc, " + super.toString();
	}

	public boolean equals(Object o) {
		if (o instanceof Cerc) {
			Cerc aux = (Cerc) o;
			return this.perimetru() == aux.perimetru();
		}
		return false;
	}

	public void setRaza(double razaNoua) {
		raza = razaNoua;
		Observator.instanta.modificare();
	}
}
