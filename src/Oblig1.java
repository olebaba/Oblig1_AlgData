////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        throw new NotImplementedException();

//        if(a.length<1){
//            throw new NoSuchElementException("Tabellen finnes ikke!");
//        }
//
//        int maks = a[0];
//        for(int i = 1; i<a.length; i++){
//            if(a[i]<maks){
//                int temp = a[i];
//                a[i] = maks;
//                maks = temp;
//            }
//        }
//
//        return maks;
    }

    public static int ombyttinger(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int uliketall=0;
        if (a.length>1){
            int tall =a[0];
            for(int i:a){
                if (tall >i) throw new IllegalStateException( "ikke sortert");
                tall=i;
            }

        }
        if(a.length>=1){
            //hvis rekker er lengre eller lik 1, har vi minst ett "ulikt" tall. dvs->
            // uliketall starter på 1
            uliketall++;
            int temp_utall=a[0];
            for(int i=1;i<a.length;i++){
                if (temp_utall != a[i]) uliketall++;
                temp_utall=a[i];
            }


        }

        return uliketall;
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //anntall forskjellige verdier er lik antall verdier minus duplikanter
        // når de forekommer i loopen
        int ulikeverdier=a.length;

        if(a.length>1) {
            int aNull=a[0];
            for (int i = 1; i < a.length; i++) {
                for (int j = i; j < a.length; j++) {
                    if (aNull == a[j]) {
                        ulikeverdier--;
                        break;
                    }
                }
                aNull = a[i];
            }
        }
        return ulikeverdier;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
