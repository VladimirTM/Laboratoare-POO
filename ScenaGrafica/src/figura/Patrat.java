package figura;

import observator.Observator;

public class Patrat extends Figura {
	private double latura;

	public Patrat(String culoare, double latura) {
		super(culoare);
		this.latura = latura;
	}

	public double perimetru() {
		return 4 * latura;
	}

	public String toString() {
		return "Patrat, " + super.toString();
	}

	public boolean equals(Object o) {
		if (o instanceof Patrat) {
			Patrat aux = (Patrat) o;
			return this.perimetru() == aux.perimetru();
		}
		return false;
	}

	public void setLatura(double laturaNoua) {
		latura = laturaNoua;
		Observator.instanta.modificare();
	}
}
