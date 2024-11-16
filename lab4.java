import java.io.*;
import java.util.Scanner;

class ExempluIO {
    public static void main(String argv[]) {
        int n, i, suma, temporar;
        try {
            BufferedReader in_stream_char = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out_stream = new PrintStream(
                    new FileOutputStream("out.txt"));
            System.out.print("Dati numarul de intregi:");
            n = Integer.parseInt(in_stream_char.readLine());
            suma = 0;
            for (i = 1; i <= n; i++) {
                System.out.print("Dati numarul " + i + ":");
                temporar = Integer.parseInt(in_stream_char.readLine());
                suma += temporar;
                out_stream.println(temporar);
            }
            out_stream.println(suma);
            System.out.println("Suma este:" + suma);
            out_stream.close();
        } catch (IOException e) {
            System.out.println("Eroare la operatiile de intrare-iesire!");
            System.exit(1);
        }
    }
}

// La E2 raspunsul este b1.equals(b2), unde b1 si b2 sunt de tip Boolean

class E2 {
    public static void main(String argv[]) {
        Boolean b1 = true, b2 = true, b3 = false;
        System.out.println(b1.equals(b2));
        System.out.println(b1.equals(b3));
    }
}

class E3 {
    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        String linie, numeFisier, aux;
        int contor = 0;
        linie = sc.nextLine();
        numeFisier = sc.nextLine();
        sc.close();
        try {
            Scanner filesc = new Scanner(new File(numeFisier));
            while (filesc.hasNextLine()) {
                aux = filesc.nextLine();
                if (aux.equals(linie)) {
                    contor++;
                }
            }
            filesc.close();
            System.out.println(contor);
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}

class E4 {
    public static void main(String argv[]) {
        try {
            Scanner in = new Scanner(new File("matrice.in"));
            PrintStream out = new PrintStream(new FileOutputStream("matrice.out"));
            int N, M, P, i, j, k;
            N = in.nextInt();
            M = in.nextInt();
            P = in.nextInt();
            double[][] a = new double[N][M], b = new double[M][P], c = new double[N][P];
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    a[i][j] = in.nextDouble();
                }
            }
            for (i = 0; i < M; i++) {
                for (j = 0; j < P; j++) {
                    b[i][j] = in.nextDouble();
                }
            }
            for (i = 0; i < N; i++) {
                for (j = 0; j < P; j++) {
                    c[i][j] = 0;
                    for (k = 0; k < M; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                    out.print(c[i][j] + " ");
                }
                out.println();
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}

class Interval {
    private int a, b;
    private int numarComparatii = 0;
    private int numarComparatiiCorecte = 0;

    public Interval(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void contine(Double x) {
        numarComparatii++;
        if (a <= x && x <= b) {
            numarComparatiiCorecte++;
        }
    }

    public void writeResult(PrintStream out) {
        out.println("Intervalul: " + a + " " + b + "\nNumar Comparatii: " + numarComparatii
                + "\nNumar Comparatii Corecte: " + numarComparatiiCorecte + "\n");
    }
}

class E5 {
    public static void main(String argv[]) {
        Scanner inputFiles = new Scanner(System.in);
        try {
            PrintStream output;
            if (argv.length <= 0) {
                output = new PrintStream(System.out);
            } else {
                output = new PrintStream(new FileOutputStream(argv[0]));
            }
            int numberOfFiles = Integer.parseInt(inputFiles.nextLine()), i;
            int[] frecventaFiles = new int[numberOfFiles];
            String[] fileNames = new String[numberOfFiles];
            for (i = 0; i < numberOfFiles; i++) {
                fileNames[i] = inputFiles.nextLine();
            }
            Scanner intervalIn = new Scanner(new File("intervale.dat"));
            while (intervalIn.hasNextInt()) {
                int a, b, fisier;
                a = intervalIn.nextInt();
                b = intervalIn.nextInt();
                fisier = intervalIn.nextInt();
                Interval interval = new Interval(a, b);
                Scanner fisierIn = new Scanner(new File(fileNames[fisier]));
                if (frecventaFiles[fisier] == 1) {
                    output.println("Fisierul a fost deschis");
                } else {
                    while (fisierIn.hasNextLine()) {
                        interval.contine(Double.parseDouble(fisierIn.nextLine()));
                    }
                    interval.writeResult(output);
                    frecventaFiles[fisier] = 1;
                }
                fisierIn.close();
            }
            intervalIn.close();
        } catch (IOException e) {
            System.exit(-1);
        }
        inputFiles.close();
    }
}