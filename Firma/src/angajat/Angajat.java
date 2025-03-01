package angajat;

public abstract class Angajat {
	private String nume;

	public Angajat(String nume) {
		this.nume = nume;
	}

	public abstract double calculSalar();

	public String toString() {
		return nume;
	}

	public boolean equals(Object o) {
		if (o instanceof Angajat) {
			Angajat aux = (Angajat) o;
			return nume.equals(aux.nume);
		}
		return false;
	}
}
