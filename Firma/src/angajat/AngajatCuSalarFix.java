package angajat;

public class AngajatCuSalarFix extends Angajat {
	private double salar;

	public AngajatCuSalarFix(String nume, double salar) {
		super(nume);
		this.salar = salar;
	}

	public double calculSalar() {
		return salar;
	}

	public void schimbaSalarFix(double salarNou) {
		salar = salarNou;
	}

	public String toString() {
		return super.toString() + " " + this.calculSalar();
	}
}
