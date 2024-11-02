class Remorca {
    private int cantitate;
    private static int cantitateAnterioara = 9;
    private String numarInmatriculare;

    public Remorca(int cantitate, String numarInmatriculare) {
        this.cantitate = cantitate;
        this.numarInmatriculare = numarInmatriculare;
        cantitateAnterioara = cantitate;
    }

    public Remorca(String numarInmatriculare) {
        cantitate = 1 + cantitateAnterioara;
        this.numarInmatriculare = numarInmatriculare;
        cantitateAnterioara = cantitate;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public int getCantitate() {
        return cantitate;
    }

    public String toString() {
        return "R" + "(" + numarInmatriculare + ", " + cantitate + ")";
    }
}

class Tir {
    private Remorca[] remorci = new Remorca[5];
    private int index = 0, cantitate = 0;

    public boolean adaugaRemorca(int cantitate, String numarInmatriculare) {
        if (index >= 5) {
            return false;
        }
        remorci[index] = new Remorca(cantitate, numarInmatriculare);
        index = index + 1;
        this.cantitate = this.cantitate + cantitate;
        return true;
    }

    public boolean adaugaRemorca(Remorca remorca) {
        if (index >= 5) {
            return false;
        }
        remorci[index] = remorca;
        index = index + 1;
        cantitate = cantitate + remorca.getCantitate();
        return true;
    }

    public Remorca stergeRemorca(String numarInmatriculare) {
        int i, j;
        for (i = 0; i < index; i++) {
            if (numarInmatriculare.equals(remorci[i].getNumarInmatriculare())) {
                Remorca aux = remorci[i];
                for (j = i; j < index - 1; j++) {
                    remorci[j] = remorci[j + 1];
                }
                cantitate = cantitate - aux.getCantitate();
                index = index - 1;
                return aux;
            }
        }
        return null;
    }

    public boolean equals(Object o) {
        if (o instanceof Tir) {
            Tir aux = (Tir) o;
            return cantitate == aux.cantitate;
        }
        return false;
    }

    public String toString() {
        String text = "T -> ";
        int i;
        for (i = 0; i < index - 1; i++) {
            text = text + remorci[i] + " -> ";
        }
        text = text + remorci[i];
        return text;
    }
}

class Main {
    public static void main(String argv[]) {
        Remorca r1, r2, r3, r4;
        r1 = new Remorca("GMV");
        r2 = new Remorca(2, "GVM");
        r3 = new Remorca("MVG");
        r4 = new Remorca(5, "VMG");
        Tir t1, t2;
        t1 = new Tir();
        t2 = new Tir();
        t1.adaugaRemorca(r1);
        t1.adaugaRemorca(4, "GMI");
        t1.adaugaRemorca(r2);
        t1.adaugaRemorca(r3);
        t1.adaugaRemorca(r4);
        t2.adaugaRemorca(r1);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t1.equals(t2));
        t1.stergeRemorca("GMI");
        t1.stergeRemorca("GMI");
        t1.stergeRemorca("GVM");
        t1.stergeRemorca("MVG");
        t1.stergeRemorca("VMG");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t1.equals(t2));
    }
}