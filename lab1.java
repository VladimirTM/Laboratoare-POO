class PrimulProgram {

    public static void p2(int a, int b) {
        if(a > b) {
            System.out.println(a);
        }
        else {
            System.out.println(b);
        }
    }

    public static void p3() {
        int s = 0, i;
        for(i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                s = s + i;
            }
            else {
                System.out.println(i);
            }
        }
        System.out.println(s);
    }

    public static void main(String argv[]) {
        System.out.println("Hello world!");
        p2(2, 7);
        p3();
    }
}