class Sertar {
    private double latime, lungime, inaltime;

    public Sertar(double latime, double lungime, double inaltime) {
        this.latime = latime;
        this.lungime = lungime;
        this.inaltime = inaltime;
    }

    public void tipareste() {
        System.out.println("Sertar " + latime + " " + lungime + " " + inaltime);
    }
}

class Birou {
    private double latime, lungime, inaltime;
    private Sertar sertar1, sertar2;

    public Birou(double latime, double lungime, double inaltime, Sertar sertar1, Sertar sertar2) {
        this.latime = latime;
        this.lungime = lungime;
        this.inaltime = inaltime;
        this.sertar1 = sertar1;
        this.sertar2 = sertar2;
    }

    public void tipareste() {
        System.out.println("Birou " + latime + " " + lungime + " " + inaltime);
        sertar1.tipareste();
        sertar2.tipareste();
    }
}

class Main {

    public static void main(String[] args) {
        Birou birou;
        Sertar sertar1, sertar2;
        sertar1 = new Sertar(1, 2, 3);
        sertar2 = new Sertar(1, 2, 2);
        birou = new Birou(10, 10, 5, sertar1, sertar2);
        birou.tipareste();
    }
}

class Complex {
    private double real, imaginar;
    private static int contor = 0;

    public Complex(double real, double imaginar) {
        this.real = real;
        this.imaginar = imaginar;
        contor = contor + 1;
    }

    public double modul() {
        return Math.sqrt(this.real * this.real + this.imaginar * this.imaginar);
    }

    public void afisare() {
        System.out.println(this.real + " + i * " + this.imaginar);
    }

    public Complex adunare(Complex numar) {
        return new Complex(this.real + numar.real, this.imaginar + numar.imaginar);
    }

    public static void contorizare() {
        System.out.println("S-au creat " + contor + " numere complexe");
    }
}

class ClientComplex {
    public static void main(String [] argv)
    {
        Complex n1, n2, rezultat;
        n1 = new Complex(1, 2);
        n2 = new Complex(-3, 2);
        n1.afisare();
        rezultat = n1.adunare(n2);
        rezultat.afisare();
        System.out.println(rezultat.modul());
        Complex.contorizare();
    }
}