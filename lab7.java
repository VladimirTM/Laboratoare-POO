import java.util.*;

interface E1 {
    void met1();

    void met2();

    void met3();
}

// La E1 daca punem implementare la o metoda din interfata, codul nu va merge

class Person {
    private String name;
    private Transmitter transmitter;

    public Person(String name) {
        this.name = name;
    }

    public void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public void send(Person receiver, String content) {
        Message message = new Message(this, receiver, content);
        transmitter.store(message);
    }

    public void notify(Transmitter transmitter) {
        Message message = transmitter.retrieve(this);
        if (message != null) {
            System.out.println(
                    name + " received message from " + message.getSender().name + ": \"" + message.getContent() + "\"");
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Person) {
            return name.equals(((Person) o).name);
        }
        return false;
    }
}

class Message {
    private Person sender, receiver;
    private String content;

    public Message(Person sender, Person receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Person getSender() {
        return sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
}

interface Transmitter {
    public void store(Message message);

    public Message retrieve(Person receiver);
}

class EMailTransmitter implements Transmitter {
    private List<Message> messages = new ArrayList<Message>();

    public void store(Message message) {
        messages.add(message);
        message.getReceiver().notify(this);
    }

    public Message retrieve(Person receiver) {
        for (Message message : messages) {
            if (message.getReceiver().equals(receiver)) {
                messages.remove(message);
                return message;
            }
        }
        return null;
    }
}

class MailTransmitter implements Transmitter {
    private List<Message> buffer;
    private int bufferSize;

    public MailTransmitter(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer = new ArrayList<>();
    }

    public void store(Message message) {
        buffer.add(message);
        if (buffer.size() == bufferSize) {
            for (Message msg : buffer) {
                msg.getReceiver().notify(this);
            }
            buffer.clear();
        }
    }

    public Message retrieve(Person receiver) {
        for (Message message : buffer) {
            if (message.getReceiver().equals(receiver)) {
                buffer.remove(message);
                return message;
            }
        }
        return null;
    }
}

class E2 {
    public static void main(String[] args) {
        Person p1 = new Person("Paul");
        Person p2 = new Person("Andreea");
        Person p3 = new Person("Ioana");
        Person p4 = new Person("Gabriel");

        Transmitter email = new EMailTransmitter();
        Transmitter mail = new MailTransmitter(2);

        p1.setTransmitter(email);
        p1.send(p2, "Scrie-i Ioanei să-mi dea adresa ei de e-mail!");

        p2.setTransmitter(mail);
        p2.send(p3, "Paul zice să-i trimiți adresa ta de e-mail");

        p4.setTransmitter(mail);
        p4.send(p1, "Ce mai faci?");

        p3.setTransmitter(email);
        p3.send(p1, "Adresa mea de e-mail este: ioana@yahoo.com");
    }
}

interface SumaTotala {
    float getSumaTotala();
}

abstract class ContBancar implements SumaTotala {
    protected String numarCont;
    protected float suma;

    public ContBancar(String numarCont, float suma) {
        this.numarCont = numarCont;
        this.suma = suma;
    }

    public String getNumarCont() {
        return numarCont;
    }

    public float getSuma() {
        return suma;
    }

    public void setNumarCont(String numarContNou) {
        numarCont = numarContNou;
    }

    public void setSuma(float sumaNoua) {
        suma = sumaNoua;
    }

    public void depune(float suma) {
        this.suma = this.suma + suma;
    }

    public void retrage(float suma) {
        if (this.suma >= suma) {
            this.suma -= suma;
        } else {
            System.out.println("Fonduri insuficiente!");
        }
    }

    public float getSumaTotala() {
        return suma;
    }
}

class ContLei extends ContBancar {
    public ContLei(String numarCont, float suma) {
        super(numarCont, suma);
    }

    public void transfer(ContBancar contDestinatie, float suma) {
        if (contDestinatie instanceof ContLei) {
            if (this.suma >= suma) {
                this.retrage(suma);
                contDestinatie.depune(suma);
            } else {
                System.out.println("Fonduri insuficiente pentru transfer!");
            }
        }
    }
}

class ContEuro extends ContBancar {
    public ContEuro(String numarCont, float suma) {
        super(numarCont, suma);
    }

    public float getDobanda() {
        if (getSuma() >= 500) {
            return (float) 0.3;
        } else {
            return (float) 0.;
        }
    }

    public float getSumaTotala() {
        return suma * 36000;
    }
}

class Client {
    private String nume, adresa;
    private List<ContBancar> conturiBancare = new ArrayList<ContBancar>();

    public Client(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }

    public void adaugaContBancar(ContBancar contBancar) {
        if (conturiBancare.size() < 5) {
            conturiBancare.add(contBancar);
        } else {
            System.out.println("Un client nu poate avea mai mult de 5 conturi!");
        }
    }

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void afiseazaInformatii() {
        System.out.println(nume + " - " + adresa);
        for (ContBancar cont : conturiBancare) {
            System.out.println("Cont: " + cont.getNumarCont() + ", Suma totală: " + cont.getSumaTotala());
        }
    }
}

class Banca {
    private String codBanca;
    private List<Client> clienti = new ArrayList<Client>();

    public Banca(String codBanca) {
        this.codBanca = codBanca;
    }

    public void adaugaClient(Client client) {
        boolean exists = false;
        for (Client clt : clienti) {
            if (clt.equals(client)) {
                exists = true;
            }
        }
        if (!exists) {
            clienti.add(client);
        } else {
            System.out.println("Clientul cu numele " + client.getNume() + " există deja!");
        }
    }

    public void afisareClient(String nume) {
        Client client = null;
        boolean exists = false;
        for (Client clt : clienti) {
            if (clt.getNume().equals(nume)) {
                exists = true;
                client = clt;
            }
        }
        if (exists) {
            client.afiseazaInformatii();
        } else {
            System.out.println("Clientul " + nume + " nu a fost găsit!");
        }
    }
}

class E3 {
    public static void main(String[] args) {
        Banca banca = new Banca("B123");

        Client client1 = new Client("Ion Popescu", "Strada Florilor 10");
        ContLei contLei1 = new ContLei("RO123", 1000);
        ContEuro contEuro1 = new ContEuro("RO456", 600);

        client1.adaugaContBancar(contLei1);
        client1.adaugaContBancar(contEuro1);
        banca.adaugaClient(client1);

        Client client2 = new Client("Maria Ionescu", "Strada Soarelui 5");
        ContLei contLei2 = new ContLei("RO789", 1500);

        client2.adaugaContBancar(contLei2);
        banca.adaugaClient(client2);

        banca.afisareClient("Ion Popescu");
        banca.afisareClient("Maria Ionescu");

        contLei1.transfer(contLei2, 500);

        banca.afisareClient("Ion Popescu");
        banca.afisareClient("Maria Ionescu");
    }
}

class Member {
    private int varsta;
    private String nume;

    public Member(int varsta, String nume) {
        this.varsta = varsta;
        this.nume = nume;
    }
}

abstract class Project implements Risky {
    private Member manager;
    protected Member[] participanti;
    protected int numarParticipanti;
    protected int index;
    private String titlu;
    private String obiectiv;
    private long fonduri;

    public Project(Member manager, String titlu, String obiectiv, int numarParticipanti, long fonduri) {
        this.manager = manager;
        this.titlu = titlu;
        this.obiectiv = obiectiv;
        this.numarParticipanti = numarParticipanti;
        this.fonduri = fonduri;
        participanti = new Member[numarParticipanti];
    }

    public abstract void addMember(Member m);

    public int getIndex() {
        return index;
    }

    public long getFonduri() {
        return fonduri;
    }

    public int getNumarParticipanti() {
        return numarParticipanti;
    }

    public String toString() {
        return titlu;
    }
}

class ComercialProject extends Project {
    private String deadLine;
    private long fonduriMarketing;
    private int numarEchipe;

    public ComercialProject(Member manager, String titlu, String obiectiv, long fonduri, String deadLine,
            int numarEchipe) {
        super(manager, titlu, obiectiv, 15, fonduri);
        this.deadLine = deadLine;
        fonduriMarketing = super.getFonduri() / 2;
        this.numarEchipe = numarEchipe;
    }

    public void addMember(Member m) {
        int i = super.getIndex();
        if (i < 15) {
            participanti[i] = m;
            index++;
        }
    }

    public double getRisk() {
        return numarEchipe * 3 / super.getIndex() / super.getFonduri() - (double) fonduriMarketing;
    }
}

class MilitaryProject extends Project {
    private String deadLine;
    private String parola;

    public MilitaryProject(Member manager, String titlu, String obiectiv, long fonduri, String deadLine,
            String parola) {
        super(manager, titlu, obiectiv, 15, fonduri);
        this.deadLine = deadLine;
        this.parola = parola;
    }

    public void addMember(Member m) {
        int i = super.getIndex();
        if (i < 15) {
            participanti[i] = m;
            index++;
        }
    }

    public double getRisk() {
        return super.getIndex() / parola.length() / super.getFonduri();
    }
}

class OpenSourceProject extends Project {
    private String mailingList;

    public OpenSourceProject(Member manager, String titlu, String obiectiv, long fonduri, String mailingList) {
        super(manager, titlu, obiectiv, 1, fonduri);
        this.mailingList = mailingList;
    }

    public void addMember(Member m) {
        int i = super.getIndex(), len = super.getNumarParticipanti();
        if (i == len) {
            int j;
            Member[] extindere = new Member[2 * len];
            for (j = 0; j < len; j++) {
                extindere[j] = participanti[j];
            }
            extindere[j] = m;
            participanti = extindere;
            index++;
            numarParticipanti = 2 * len;
        } else {
            participanti[i] = m;
            index++;
        }
    }

    public double getRisk() {
        return super.getIndex() / super.getFonduri();
    }
}

interface Risky {
    double getRisk();
}

class InvestmentCompany {
    private Project[] proiecte = new Project[1];
    private int numarProiecte = 1;
    private int index;

    public void addProject(Project p) {
        if (index == numarProiecte) {
            int j;
            Project[] extindere = new Project[2 * numarProiecte];
            for (j = 0; j < numarProiecte; j++) {
                extindere[j] = proiecte[j];
            }
            extindere[j] = p;
            proiecte = extindere;
        } else {
            proiecte[index++] = p;
        }
    }

    public Project getBestInvestment() {
        double minRisk = proiecte[0].getRisk(), risk;
        for (int i = 1; i < index; i++) {
            risk = proiecte[i].getRisk();
            if (risk < minRisk) {
                minRisk = risk;
            }
        }
        for (int i = 0; i < index; i++) {
            risk = proiecte[i].getRisk();
            if (risk == minRisk) {
                return proiecte[i];
            }
        }
        return null;
    }

    public static void main(String argv[]) {
        Member m1, m2, m3, m4, m5, m6;
        m1 = new Member(1, "A");
        m2 = new Member(2, "B");
        m3 = new Member(3, "C");
        m4 = new Member(4, "D");
        m5 = new Member(5, "E");
        m6 = new Member(6, "F");
        Project p1, p2, p3;
        p1 = new ComercialProject(m1, "Test1", "Testarea intai", 2, "maine", 5);
        p2 = new MilitaryProject(m2, "Test2", "Testarea a doua", 3, "azi", "ABC");
        p3 = new OpenSourceProject(m3, "Test3", "Testarea a treia", 4, "aabc.com");
        p1.addMember(m1);
        p1.addMember(m4);
        p2.addMember(m2);
        p2.addMember(m5);
        p2.addMember(m6);
        p3.addMember(m1);
        p3.addMember(m2);
        p3.addMember(m3);
        p3.addMember(m4);
        InvestmentCompany eu = new InvestmentCompany();
        eu.addProject(p1);
        eu.addProject(p2);
        eu.addProject(p3);
        System.out.println(eu.getBestInvestment());
    }
}
