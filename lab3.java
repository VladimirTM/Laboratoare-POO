// La E1 metodele nu sunt supraincarcate

class Carte {
    private int numarPagini;

    public Carte(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    public boolean equals(Object o) {
        if (o instanceof Carte) {
            Carte aux = (Carte) o;
            return numarPagini == aux.numarPagini;
        }
        return false;
    }
}

class Patrat {
    private int latura;

    public Patrat() {
        latura = 10;
    }

    public Patrat(int latura) {
        this.latura = latura;
    }

    public String toString() {
        return "Patrat " + latura + " Aria " + latura * latura;
    }
}

class Piramida {
    private int n;

    public Piramida(int n) {
        this.n = n;
    }

    public String toString() {
        String text = "";
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = i; j <= n; j++) {
                text = text + i + " ";
            }
            text = text + "\n";
        }
        return text;
    }
}

class Suma {
    public static int suma(int a, int b) {
        return a + b;
    }

    public static int suma(int a, int b, int c) {
        return a + b + c;
    }

    public static int suma(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}

class Main {
    public static void main(String argv[]) {
        // Carte c1, c2, c3;
        // c1 = new Carte(10);
        // c2 = new Carte(12);
        // c3 = new Carte(10);
        // System.out.println(c1.equals(c2));
        // System.out.println(c1.equals(c3));
        // Patrat p1, p2;
        // p1 = new Patrat();
        // p2 = new Patrat(2);
        // System.out.println(p1);
        // System.out.println(p2);
        // Piramida p;
        // p = new Piramida(4);
        // System.out.println(p);
        // System.out.println(Suma.suma(1, 2));
        // System.out.println(Suma.suma(1, 2, 3));
        // System.out.println(Suma.suma(1, 2, 3, 4));
    }
}