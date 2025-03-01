package main;

import angajat.*;
import firma.Firma;

public class GestiuneAngajati {
	public static void main(String argv[]) {
		Angajat a1, a2, a3, a4;
		a1 = new AngajatCuOra("Vladimir", 100);
		((AngajatCuOra) a1).adaugaOre(2);
		((AngajatCuOra) a1).adaugaOre(1);
		((AngajatCuOra) a1).adaugaOre(3);
		a2 = new AngajatCuOra("Alex", 20);
		((AngajatCuOra) a2).adaugaOre(1);
		((AngajatCuOra) a2).adaugaOre(1);
		a3 = new AngajatCuSalarFix("Marc", 30);
		a4 = new AngajatCuSalarFix("Adi", 10);
		Firma firma = new Firma();
		firma.angajeaza(a1);
		firma.angajeaza(a1);
		firma.angajeaza(a2);
		firma.angajeaza(a3);
		firma.angajeaza(a4);
		firma.angajeaza(a2);
		System.out.println(firma.salariuMediu());
		((AngajatCuOra) a1).schimbaSalarPeOra(200);
		((AngajatCuSalarFix) a4).schimbaSalarFix(100);
		System.out.println(firma.salariuMediu());
	}
}
