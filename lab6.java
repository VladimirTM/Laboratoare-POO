import java.util.*;

class PC {
    private String memory = "";
    private String registry;

    public void store(String information) {
        memory += information;
        registry = information;
    }

    public String load() {
        return registry;
    }
}

abstract class Device {
    private String information;

    public Device() {
        information = "";
    }

    public Device(String information) {
        this.information = information;
    }

    public void store(String information) {
        this.information = information;
    }

    public String load() {
        return information;
    }

    public abstract String getDeviceType();
}

class PhotoDevice extends Device {
    public PhotoDevice(String information) {
        super(information);
    }

    public void takePicture() {
        System.out.println("TakePicture...");
    }

    public String getDeviceType() {
        return "PhotoDevice";
    }
}

class VideoDevice extends Device {
    private String producer;

    public VideoDevice(String information, String producer) {
        super(information);
        this.producer = producer;
    }

    public void film() {
        System.out.println("Film...");
    }

    public String getDeviceType() {
        return "VideoDevice";
    }
}

class USB {
    public void transferPCToDevice(PC pc, Device device) {
        String data = pc.load();
        device.store(data);
        System.out.println("PC -> " + device.getDeviceType() + " " + data);
    }
}

class B {
    public void oMetoda(Object o) {
        System.out.println("B");
    }
}

class D extends B {
    public void oMetoda(Object o) {
        System.out.println("D");
    }
}

abstract class Proprietate {
    private String adresa;
    protected int suma;
    private int suprafata;

    public Proprietate(String adresa, int suprafata) {
        this.adresa = adresa;
        this.suprafata = suprafata;
    }

    public String getAdresa() {
        return adresa;
    }

    public int getSuma() {
        return suma;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public String toString() {
        return "Proprietati\n";
    }
}

class Cladire extends Proprietate {
    public Cladire(String adresa, int suprafata) {
        super(adresa, suprafata);
        super.suma = 500 * suprafata;
    }

    public String toString() {
        return super.toString() + "\tCladire: " + super.getAdresa() + "\n\t\tSuprafata: " + super.getSuprafata()
                + "\n\t\tCost: " + super.getSuma() + "\n";
    }
}

class Teren extends Proprietate {
    private int rang;

    public Teren(String adresa, int suprafata, int rang) {
        super(adresa, suprafata);
        super.suma = (350 * suprafata) / rang;
    }

    public String toString() {
        return super.toString() + "\tTeren: " + super.getAdresa() + "\n\t\tSuprafata: " + super.getSuprafata()
                + ", Rang: " + rang + "\n\t\tCost: " + super.getSuma() + "\n";
    }
}

class Contribuabil {
    private String nume;
    private int sumaBani;
    private List<Proprietate> proprietati;

    public Contribuabil(String nume, List<Proprietate> proprietati) {
        this.nume = nume;
        for (Proprietate proprietate : proprietati) {
            sumaBani = sumaBani + proprietate.getSuma();
        }
        this.proprietati = proprietati;
    }

    public String toString() {
        return "Contribuabil: " + nume + "\n" + proprietati + "Suma totala: " + sumaBani;
    }
}

class Ghiseu {
    public static void main(String[] args) {
        List<Proprietate> proprietati = new ArrayList<Proprietate>();
        proprietati.add(new Cladire("Strada V Parvan Nr. 2", 20));
        proprietati.add(new Teren(" Strada V Parvan Nr. 2", 10, 1));
        proprietati.add(new Cladire("Strada Lugoj Nr. 4", 25));
        Contribuabil c = new Contribuabil("Vladimir", proprietati);
        System.out.println(c);
    }
}

abstract class Vagon {
    private int numarColete;

    public Vagon(int numarColete) {
        this.numarColete = numarColete;
    }

    public int getNumarColete() {
        return numarColete;
    }
}

abstract class VagonCalatori extends Vagon {
    private int numarPasageri;

    public VagonCalatori(int numarColete, int numarPasageri) {
        super(numarColete);
        this.numarPasageri = numarPasageri;
    }

    public void deschideUsaAutomat() {
        System.out.println("Am deschis usa automat");
    }

    public void inchideUsaAutomat() {
        System.out.println("Am inchis usa automat");
    }

    public int getNumarPasageri() {
        return numarPasageri;
    }
}

class VagonCalatoriA extends VagonCalatori {
    public VagonCalatoriA() {
        super(300, 40);
    }

    public String toString() {
        return "Vagon Tip A: Numar Pasageri: " + getNumarPasageri() + " Numar Colete: " + getNumarColete() + "\n";
    }
}

class VagonCalatoriB extends VagonCalatori {
    public VagonCalatoriB() {
        super(400, 50);
    }

    public void blocareGeam() {
        System.out.println("Am blocat geamurile");
    }

    public String toString() {
        return "Vagon Tip B: Numar Pasageri: " + getNumarPasageri() + " Numar Colete: " + getNumarColete() + "\n";
    }
}

class VagonMarfa extends Vagon {
    public VagonMarfa() {
        super(400);
    }

    public void deschideUsaManual() {
        System.out.println("Am deschis usa manual");
    }

    public void inchideUsaManual() {
        System.out.println("Am inchis usa manual");
    }
}

abstract class Greutate {
    public abstract int getCapacitate();
}

class GreutateSimpla extends Greutate {
    private int capacitate;

    public GreutateSimpla(int capacitate) {
        this.capacitate = capacitate;
    }

    public int getCapacitate() {
        return capacitate;
    }
}

class GreutateDubla extends Greutate {
    private GreutateSimpla g1, g2;

    public GreutateDubla(GreutateSimpla g1, GreutateSimpla g2) {
        this.g1 = g1;
        this.g2 = g2;
    }

    public void setGreutate1(GreutateSimpla g) {
        g1 = g;
    }

    public void setGreutate2(GreutateSimpla g) {
        g2 = g;
    }

    public int getCapacitate() {
        return g1.getCapacitate() + g2.getCapacitate();
    }
}

class GreutateMultipla extends Greutate {
    private List<Greutate> greutati = new ArrayList<Greutate>();

    public void adaugaCapacitate(Greutate g) {
        greutati.add(g);
    }

    public int getCapacitate() {
        int sum = 0;
        for (Greutate greutate : greutati) {
            sum = sum + greutate.getCapacitate();
        }
        return sum;
    }
}

class ColectieGreutati {
    private List<Greutate> colectieGreutati = new ArrayList<Greutate>();

    public void adaugaGreutate(Greutate g) {
        colectieGreutati.add(g);
    }

    public double medie() {
        double sum = 0;
        for(Greutate greutate: colectieGreutati) {
            sum = sum + greutate.getCapacitate();
        }
        sum = sum / colectieGreutati.size();
        return sum;
    }

    public static void main(String[] args) {
        GreutateSimpla gs1, gs2;
        GreutateDubla gd1, gd2;
        GreutateMultipla gm1;
        gs1 = new GreutateSimpla(10);
        gs2 = new GreutateSimpla(5);
        gd1 = new GreutateDubla(gs1, gs2);
        gd2 = new GreutateDubla(gs1, gs1);
        gm1 = new GreutateMultipla();
        gm1.adaugaCapacitate(gs1);
        gm1.adaugaCapacitate(gs2);
        gm1.adaugaCapacitate(gd1);
        ColectieGreutati greutati;
        greutati = new ColectieGreutati();
        greutati.adaugaGreutate(gm1);
        greutati.adaugaGreutate(gs1);
        greutati.adaugaGreutate(gd1);
        greutati.adaugaGreutate(gd2);
        System.out.println(greutati.medie());
    }
}