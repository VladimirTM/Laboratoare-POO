import java.util.Scanner;

// La E2 daca clasa Punct are un constructor cu parametrii atunci acesta trebuie apelat in clasa PunctColorat pentru a merge programul fiind mostenit.
// Un exemplu in care merge omis constructorul
// class Punct {
//     private int x, y;
// }

// class PunctColorat extends Punct{
//     private int c;
// }

class NumarComplex {
    protected double re, im;

    public NumarComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public NumarComplex adunare(NumarComplex a) {
        return new NumarComplex(re + a.re, im + a.im);
    }

    public NumarComplex inmultire(NumarComplex a) {
        return new NumarComplex(re * a.re - im * a.im, re * a.im + im * a.re);
    }

    public double modul() {
        return Math.sqrt(re * re + im * im);
    }

    public String toString() {
        return re + " + " + im + " * i";
    }
}

class MatriceComplex {
    public static NumarComplex[][] citesteMatrice(int randuri, int coloane, Scanner scanner) {
        NumarComplex[][] matrice = new NumarComplex[randuri][coloane];

        for (int i = 0; i < randuri; i++) {
            for (int j = 0; j < coloane; j++) {
                System.out.printf("Introduceți elementul [%d][%d] (1 pentru număr real, 2 pentru număr complex): ", i,
                        j);
                int tip = scanner.nextInt();
                if (tip == 1) {
                    System.out.print("Partea reală: ");
                    double real = scanner.nextDouble();
                    matrice[i][j] = new NumarComplex(real, 0);
                } else {
                    System.out.print("Partea reală: ");
                    double real = scanner.nextDouble();
                    System.out.print("Partea imaginară: ");
                    double imaginar = scanner.nextDouble();
                    matrice[i][j] = new NumarComplex(real, imaginar);
                }
            }
        }
        return matrice;
    }

    public static NumarComplex[][] inmultireMatrici(NumarComplex[][] matriceA, NumarComplex[][] matriceB) {
        int n = matriceA.length;
        int m = matriceA[0].length;
        int p = matriceB[0].length;
        NumarComplex[][] rezultat = new NumarComplex[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                rezultat[i][j] = new NumarComplex(0, 0);
                for (int k = 0; k < m; k++) {
                    rezultat[i][j] = rezultat[i][j].adunare(matriceA[i][k].inmultire(matriceB[k][j]));
                }
            }
        }
        return rezultat;
    }

    public static void afiseazaMatrice(NumarComplex[][] matrice) {
        for (NumarComplex[] rand : matrice) {
            for (NumarComplex element : rand) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți numărul de rânduri pentru matricea A: ");
        int n = scanner.nextInt();
        System.out.print("Introduceți numărul de coloane pentru matricea A: ");
        int m = scanner.nextInt();
        System.out.print("Introduceți numărul de coloane pentru matricea B: ");
        int p = scanner.nextInt();

        System.out.println("Citirea matricei A:");
        NumarComplex[][] matriceA = citesteMatrice(n, m, scanner);

        System.out.println("Citirea matricei B:");
        NumarComplex[][] matriceB = citesteMatrice(m, p, scanner);

        System.out.println("Rezultatul înmulțiri matricelor A și B:");
        NumarComplex[][] rezultat = inmultireMatrici(matriceA, matriceB);
        afiseazaMatrice(rezultat);

        scanner.close();
    }
}

class Avion {
    private String planeID;
    private int totalEnginePower;

    public String geString() {
        return planeID;
    }

    public int getTotalEnginePower() {
        return totalEnginePower;
    }

    public void takeOff() {
        System.out.println("Take Off");
    }

    public void land() {
        System.out.println("Land");
    }

    public void fly() {
        System.out.println("Fly");
    }
}

class AvionCalatori extends Avion{
    private int maxPassengers;

    public int getMaxPassengers() {
        return maxPassengers;
    }
}

class Boeing extends AvionCalatori{

}

class Concorde extends AvionCalatori{
    public void goSuperSonic() {
        System.out.println("SuperSonic");
    }

    public void goSubSonic() {
        System.out.println("SubSonic");
    }
}

class AvionLupta extends Avion{
    public void launchMissile() {
        System.out.println("Launching Missile");
    }
}

class Mig extends AvionLupta{
    public void highSpeedGeometry() {
        System.out.println("High Speed Geometry");
    }

    public void normalGeometry() {
        System.out.println("Normal Speed Geometry");
    }
}

class TomCat extends AvionLupta{
    public void refuel() {
        System.out.println("Refuel");
    }
}