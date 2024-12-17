import java.util.*;

// La E1 ArrayList este mai eficient dacă ai nevoie de acces rapid la elemente prin index și dacă inserezi sau ștergi elemente doar la finalul listei, deoarece este bazat pe un tablou dinamic. LinkedList este preferat când ai multe inserări și ștergeri în interiorul listei (la început sau mijloc), dar accesul prin index este lent, deoarece necesită parcurgerea listei nod cu nod.

class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialList, finalList;
        initialList = new LinkedList<String>();
        finalList = new LinkedList<String>();
        String word = scanner.next();
        while (!(word.equals("STOP"))) {
            initialList.add(word);
            word = scanner.next();
        }
        scanner.close();
        for (String string1 : initialList) {
            boolean exists = false;
            for (String string2 : finalList) {
                if (string1.equals(string2)) {
                    exists = true;
                }
            }
            if (!exists) {
                finalList.add(string1);
            }
        }
        System.out.println(finalList);
    }
}

abstract class Tip {
    public String getTip() {
        return "Tip: ";
    }

    public abstract String toString();
}

class Intreg extends Tip {
    private int data;

    public Intreg(int data) {
        this.data = data;
    }

    public String getTip() {
        return super.getTip() + "Intreg";
    }

    public String toString() {
        return "" + data;
    }

    public boolean equals(Object o) {
        if (o instanceof Intreg) {
            return data == ((Intreg) o).data;
        }
        return false;
    }
}

class Sir extends Tip {
    private String data;

    public Sir(String data) {
        this.data = data;
    }

    public String getTip() {
        return super.getTip() + "Sir";
    }

    public String toString() {
        return data;
    }

    public boolean equals(Object o) {
        if (o instanceof Sir) {
            return data.equals(((Sir) o).data);
        }
        return false;
    }
}

class Colectie extends Tip {
    private List<Tip> lst;

    public Colectie() {
        lst = new ArrayList<Tip>();
    }

    public String getTip() {
        return super.getTip() + "Colectie";
    }

    public String toString() {
        String text = "(";
        Iterator<Tip> it = lst.iterator();
        while (it.hasNext()) {
            Tip data = it.next();
            text = text + data;
            if (it.hasNext()) {
                text = text + ", ";
            }
        }
        text = text + ")";
        return text;
    }

    public boolean equals(Object o) {
        if (o instanceof Colectie) {
            Colectie aux = (Colectie) o;
            if (lst.size() != aux.lst.size()) {
                return false;
            }
            Iterator<Tip> it1 = lst.iterator();
            Iterator<Tip> it2 = aux.lst.iterator();
            while (it1.hasNext()) {
                Tip el1 = it1.next();
                Tip el2 = it2.next();
                if (el1.equals(el2) == false) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void adauga(Tip tip) {
        lst.add(tip);
    }
}

class E3 {
    public static void main(String argv[]) {
        Colectie c1, c2;
        c1 = new Colectie();
        c2 = new Colectie();
        c1.adauga(new Intreg(10));
        c1.adauga(new Intreg(12));
        c1.adauga(new Sir("Ana"));
        c1.adauga(new Intreg(19));
        c2.adauga(new Intreg(10));
        c2.adauga(new Intreg(12));
        c2.adauga(new Sir("Ana"));
        c2.adauga(new Intreg(19));
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
        c1.adauga(c2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
        System.out.println(c1.getTip());
    }
}