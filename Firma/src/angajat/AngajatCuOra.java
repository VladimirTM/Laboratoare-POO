package angajat;

public class AngajatCuOra extends Angajat {
	private double salar;
	private double[] oreLucrate = new double[31];
	private int index;

	public AngajatCuOra(String nume, double salar) {
		super(nume);
		this.salar = salar;
	}

	public void adaugaOre(double numarOre) {
		if (index < 31) {
			oreLucrate[index++] = numarOre;
		}
	}

	public void schimbaSalarPeOra(double salarNou) {
		salar = salarNou;
	}

	public double calculSalar() {
		double numarOre = 0;
		for (int i = 0; i < index; i++) {
			numarOre = numarOre + oreLucrate[i];
		}
		return numarOre * salar;
	}

	public String toString() {
		return super.toString() + " " + this.calculSalar();
	}
}
