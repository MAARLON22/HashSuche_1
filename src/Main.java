import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashSuche h1 = new HashSuche(11);
        h1.fuegeEin(22022004, 23);
        h1.fuegeEin(22022044, 23);
        h1.fuegeEin(22022005,40);
        h1.fuegeEin(22022006,1);
        h1.fuegeEin(22022007,13);
        h1.fuegeEin(22022008,12);


        System.out.println(Arrays.toString(h1.gibZahlen()));
        System.out.println(Arrays.toString(h1.gibZahlen1()));
        System.out.println(h1.fuegeEin(22022005,40));
        System.out.println(Arrays.toString(h1.gibKollisionen()));


//
    }
}
