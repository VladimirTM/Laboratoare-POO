package figura;

import observator.Observator;

public class Triunghi extends Figura {
	private double laturaA, laturaB, laturaC;

	public Triunghi(String culoare, double laturaA, double laturaB, double laturaC) {
		super(culoare);
		this.laturaA = laturaA;
		this.laturaB = laturaB;
		this.laturaC = laturaC;
	}

	public double perimetru() {
		return laturaA + laturaB + laturaC;
	}
	
	public String toString() {
		return "Triunghi, " + super.toString();
	}

	public boolean equals(Object o) {
		if(o instanceof Triunghi) {
			Triunghi aux = (Triunghi)o;
			return this.perimetru() == aux.perimetru();
		}
		return false;
	}
	
	public void setLaturaA(double laturaANoua) {
		laturaA = laturaANoua;
		Observator.instanta.modificare();
	}
	
	public void setLaturaB(double laturaBNoua) {
		laturaB = laturaBNoua;
		Observator.instanta.modificare();
	}
	
	public void setLaturaC(double laturaCNoua) {
		laturaC = laturaCNoua;
		Observator.instanta.modificare();
	}
}
