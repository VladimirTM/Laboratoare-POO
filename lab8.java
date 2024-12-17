import java.util.Random;
import java.util.Date;

// La E1 se va afisa L1, pentru ca in for i ajunge pe 0 si se arunca exceptia L1, urmand ca in catch sa fie tratata

class E1 extends RuntimeException { // sau Exception pentru E2
    public E1() {
        super("E1");
    }
}

class E2 extends RuntimeException {
    public E2() {
        super("E2");
    }
}

class ExempluE2 {
    public void doSomething(int i) {
        try {
            if (i == 0)
                throw new E1();
            else
                throw new E2();
        } catch (E1 e) {
            System.out.println("Prins");
        }
    }
}

class ExempluE3 {
    public void doSomething(int i) {
        if (i == 0)
            throw new E1();
        else
            throw new E2();
    }
}

class Out extends Exception {
    public Out(String message) {
        super(message);
    }
}

class Gol extends Exception {
    public Gol(String message) {
        super(message);
    }
}

class Corner extends Exception {
    public Corner(String message) {
        super(message);
    }
}

class CoordinateGenerator {
    private Random randomGenerator;

    public CoordinateGenerator() {
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }

    public int generateX() {
        int x = randomGenerator.nextInt(101);
        if (x < 5) {
            x = 0;
        } else if (x > 95) {
            x = 100;

        } else {
            x = randomGenerator.nextInt(99) + 1;
        }
        return x;
    }

    public int generateY() {
        int y = randomGenerator.nextInt(101);
        if (y < 5) {
            y = 0;
        } else if (y > 95) {
            y = 50;
        } else {
            y = randomGenerator.nextInt(49) + 1;
        }
        return y;
    }
}

class Minge {
    private int x, y;
    private static CoordinateGenerator generator = new CoordinateGenerator();

    public Minge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void suteaza() throws Out, Gol, Corner {
        x = generator.generateX();
        y = generator.generateY();
        if (y == 0 || y == 50)
            throw new Out("Out");
        if ((x == 0 || x == 100) && (20 <= y && y <= 30))
            throw new Gol("Gol");
        if ((x == 0 || x == 100) && ((0 < y && y < 20) || (30 < y && y < 50)))
            throw new Corner("Corner");
    }
}

class Joc {
    private String echipa1, echipa2;
    private int gol1, gol2, outuri, corneruri;

    public Joc(String echipa1, String echipa2) {
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
    }

    public void simuleaza() {
        Minge minge = new Minge(50, 25), anterior = null;
        for (int i = 0; i < 1000; i++) {
            System.out.println(echipa1 + " - " + echipa2 + " : Mingea se afla la coordonatele (" + minge.getX() + ", "
                    + minge.getY() + ")");
            try {
                anterior = minge;
                minge.suteaza();
            } catch (Gol gol) {
                if (minge.getX() == 100) {
                    gol1++;
                } else {
                    gol2++;
                }
                minge = new Minge(50, 25);
                System.out.println(gol.getMessage());
            } catch (Out out) {
                minge = anterior;
                System.out.println(out.getMessage());
                outuri++;
            } catch (Corner corner) {
                if (0 < minge.getY() && minge.getY() < 20) {
                    minge = new Minge(minge.getX(), 0);
                } else {
                    minge = new Minge(minge.getX(), 50);
                }
                System.out.println(corner.getMessage());
                corneruri++;
            }
        }
    }

    public String toString() {
        return echipa1 + " vs " + echipa2 + "\nScor: " + gol1 + " - " + gol2 + "\nStatistici: Out-uri " + outuri
                + " Cornere " + corneruri;
    }
}

class E4 {
    public static void main(String[] args) {
        Joc joc1, joc2;
        joc1 = new Joc("A", "B");
        joc1.simuleaza();
        joc2 = new Joc("A", "B");
        joc2.simuleaza();
        System.out.println(joc1);
        System.out.println(joc2);
    }
}