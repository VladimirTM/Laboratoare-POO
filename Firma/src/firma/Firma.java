package firma;

import angajat.Angajat;

public class Firma {
	private Angajat[] angajati = new Angajat[1024];
	private int index;

	public int angajeaza(Angajat angajat) {
		if (index >= 1024) {
			return -1;
		}
		for (int i = 0; i < index; i++) {
			if (angajat.equals(angajati[i])) {
				return -2;
			}
		}
		angajati[index++] = angajat;
		return 0;
	}

	public double salariuMediu() {
		if (index == 0) {
			return 0;
		}
		double salariu = 0;
		for (int i = 0; i < index; i++) {
			salariu = salariu + angajati[i].calculSalar();
		}
		return salariu / index;
	}
}
