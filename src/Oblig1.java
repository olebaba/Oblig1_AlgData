////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 //////////////////////////////////////
    /*
     * Det blir flest ombyttinger når n blir stort
     * Det blir færrest ombyttinger når n=1
     * I gjennomsnitt er det ? (trenger hjelp)
     */
    public static int maks(int[] a) {
        if (a.length < 1) {
            throw new NoSuchElementException("Tabellen finnes ikke!");
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }

        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {

        int antall = 0;

        for(int i = 1; i<a.length; i++){
            if(a[i-1]>a[i]){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
                antall++;
            }
        }

        return antall;

    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
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
        int od=0;
        for(int i:a){
            if(i%2!=0) od++;
        }
        int t=a[0];
        for(int i=0;i<od;i++){
            if(a[i]%2==0){
                t=a[i];
                for(int j=i;j<a.length;j++){
                    if(a[j]%2!=0){
                        a[i]=a[j];
                        a[j]=t;
                        break;
                    }
                }
            }
        }


        int svn=a[0];
        int svi=0;
        int vn=0;

        for(int i=0;i<od-1;i++){
            svn=a[i];
            vn=a[i];
            for(int j=i;j<od;j++){
                if(svn>=a[j]){
                    svn=a[j];
                    svi=j;
                }
            }
            a[svi]=vn;
            a[i]= svn;
        }
        for(int i=od-1;i<a.length-1;i++){
            svn=a[i];
            vn=a[i];
            for(int j=i;j<a.length;j++){
                if(svn>=a[j]){
                    svn=a[j];
                    svi=j;
                }
            }
            a[svi]=vn;
            a[i]= svn;

        }




    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        char sist = a[a.length-1];

        for(int i = a.length-2; i>=0; i--){
            a[i+1] = a[i];
        }
        a[0] = sist;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {


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
