public class Main {
    public static void main(String[] args) {

        Squirrel s = new Squirrel(new int[] {1, -2, 1, 1, -3, -2, 2, 2});
        System.out.println(s.maxNuts());

        Squirrel s2 = new Squirrel(new int[] {1, -2, 3, 1, -1, -4, 2, 3, -8, -8});
        System.out.println(s2.maxNuts());

    }
}
