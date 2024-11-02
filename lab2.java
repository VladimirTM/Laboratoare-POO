class E1 {
    private int aux;

    private E1() {
        aux = 10;
    }
}

class E2 {
    private int a1;
    private char a2;

    public String toString() {
        return a1 + " " + a2;
    }
}

// La E3 se afiseaza Motor de capacitate 10

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
    private Sertar s1, s2;

    public Birou(double latime, double lungime, double inaltime, Sertar s1, Sertar s2) {
        this.latime = latime;
        this.lungime = lungime;
        this.inaltime = inaltime;
        this.s1 = s1;
        this.s2 = s2;
    }

    public void tipareste() {
        System.out.println("Birou " + latime + " " + lungime + " " + inaltime);
        s1.tipareste();
        s2.tipareste();
    }
}

class Complex {
    private double real, imaginar;
    private static int numarAfisari = 0;

    public Complex(double real, double imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }

    public double modul() {
        return Math.sqrt(real * real + imaginar * imaginar);
    }

    public String toString() {
        numarAfisari++;
        return real + " + i * " + imaginar;
    }

    public Complex adunare(Complex c) {
        return new Complex(real + c.real, imaginar + c.imaginar);
    }

    public static int getNumarAfisari() {
        return numarAfisari;
    }
}

class ClientComplex {
    public static void main(String argv[]) {
        Complex c1, c2, c3;
        c1 = new Complex(2, 4);
        c2 = new Complex(-4, 4);
        c3 = c1.adunare(c2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(Complex.getNumarAfisari());
    }
}

class Main {
    public static void main(String argv[]) {
        // E1 e1 = new E1();
        // E2 e2 = new E2();
        // System.out.println(e2);
        // Sertar s1, s2;
        // s1 = new Sertar(2, 2, 1);
        // s2 = new Sertar(3, 3, 2);
        // Birou b;
        // b = new Birou(10, 10, 5, s1, s2);
        // b.tipareste();
    }
}