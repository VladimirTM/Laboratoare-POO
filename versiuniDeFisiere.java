class Fisier {
    private String nume, continut;
    private int id;
    private static int contor = 0, numarConcatenari = 0;
    private Fisier versiuneAnterioara;

    public Fisier(String nume, String continut) {
        this.nume = nume;
        this.continut = continut;
        id = contor;
        versiuneAnterioara = null;
        contor = contor + 1;
    }

    public void salveazaVersiune() {
        Fisier versiune = new Fisier(nume + ".bak", continut);
        versiune.versiuneAnterioara = versiuneAnterioara;
        versiuneAnterioara = versiune;
    }

    public void concateneaza(Fisier fisier) {
        salveazaVersiune();
        continut = continut + fisier.continut;
        numarConcatenari = numarConcatenari + 1;
    }

    public String toString() {
        return id + " " + nume + " [" + continut + "] " + versiuneAnterioara;
    }

    public static int numarConcatenari() {
        return numarConcatenari;
    }
}

class Main {
    public static void main(String argv[]) {
        Fisier f1, f2, f3;
        f1 = new Fisier("Prenume1", "Vladimir");
        f2 = new Fisier("Prenume2", "Mihai");
        f3 = new Fisier("Nume", "Ghimpau");
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        f1.salveazaVersiune();
        System.out.println(f1);
        f1.concateneaza(f2);
        System.out.println(f1);
        f1.concateneaza(f3);
        System.out.println(f1);
        System.out.println(Fisier.numarConcatenari());
    }
}