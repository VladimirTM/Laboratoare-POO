package main;
import figura.*;
import observator.Observator;


public class Main {
	public static void main(String[] args) {
		Cerc cerc = new Cerc("rosu", 20);
		Patrat patrat = new Patrat("verde", 10);
		Triunghi triunghi = new Triunghi("albastru", 1, 2, 3);
		System.out.println(Observator.instanta);
		cerc.setCuloare("galben");
		triunghi.setLaturaA(2);
	}
}
