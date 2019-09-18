import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        int[] values = {5,2,7,21,3,6,4};
        //assertEquals(true, true, "Implementer maks og denne testen");
        assertEquals(21, Oblig1.maks(values));
        System.out.println(Arrays.toString(values));
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] tabell = Oblig1.randPerm(1000);
        int antall_tester = 1000;
        int ombyttinger = 0;
        for(int i= 0; i<antall_tester; i++){
            ombyttinger += Oblig1.ombyttinger(tabell);
        }
        int gj_snitt = ombyttinger/antall_tester;
        System.out.println(gj_snitt);
        //assertEquals(true, false, "Implementer ombyttinger og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        int[] c = {1, 2, 3, 4, 5, 4};


        assertEquals(false, Oblig1.antallUlikeSortert(c), "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        int[] d = {6, 2, 4, 6, 9, 1, 4,4, 9, 10};
        assertEquals(6, Oblig1.antallUlikeUsortert(d), "Implementer antallUlikeUsortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        char[] bokstaver = {'a','b','c','d','e','f'};
        System.out.println(Arrays.toString(bokstaver));
        Oblig1.rotasjon(bokstaver, 5);
        System.out.println(Arrays.toString(bokstaver));
        Oblig1.rotasjon(bokstaver, -8);
        System.out.println(Arrays.toString(bokstaver));
        assertEquals('d', bokstaver[0], "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {



        assertEquals(true, false, "Implementer flett og denne testen");
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        int[] tabell = {1, 2, 3, 4, 5};
        int[] forventet = {0, 1, 2, 3, 4};
        assertEquals(Arrays.toString(forventet), Arrays.toString(Oblig1.indekssortering(tabell)), "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        int[] tabell = {3, 1, 2};
        int[] foreventet = {1, 2, 0};

        assertEquals(Arrays.toString(foreventet), Arrays.toString(Oblig1.tredjeMin(tabell)), "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}