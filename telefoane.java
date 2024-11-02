import java.util.Random;
import java.util.Scanner;

class Telefon {
    private String nume;
    private String[] agenda = new String[100];
    private int index = 0;

    public Telefon(String nume) {
        this.nume = nume;
    }

    public boolean apeleaza(Telefon persoana) {
        if (persoana.index >= 100) {
            return false;
        }
        persoana.agenda[persoana.index] = nume;
        persoana.index = persoana.index + 1;
        return true;
    }

    public int numarDeApeluri(String nume) {
        int contor = 0, i;
        for (i = 0; i < index; i++) {
            if (nume.equals(agenda[i])) {
                contor = contor + 1;
            }
        }
        return contor;
    }

    public String toString() {
        String text = nume + " a fost apelat de : ";
        int i;
        for (i = 0; i < index; i++) {
            text = text + agenda[i] + " ";
        }
        return text;
    }
}

class Main {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int numarTelefoane = Integer.parseInt(sc.nextLine()), i;
        String nume;
        Telefon[] telefoane = new Telefon[numarTelefoane];
        for (i = 0; i < numarTelefoane; i++) {
            nume = sc.nextLine();
            telefoane[i] = new Telefon(nume);
        }
        int A = Integer.parseInt(sc.nextLine()), x, y;
        Random rand = new Random();
        for (i = 0; i < A; i++) {
            x = rand.nextInt(numarTelefoane);
            do {
                y = rand.nextInt(numarTelefoane);
            } while (x == y);
            System.out.println(x + " " + y);
            telefoane[x].apeleaza(telefoane[y]);
        }
        String proprietar = sc.nextLine();
        for (i = 0; i < numarTelefoane; i++) {
            System.out.println(telefoane[i]);
            System.out.println(telefoane[i].numarDeApeluri(proprietar));
        }
    }
}