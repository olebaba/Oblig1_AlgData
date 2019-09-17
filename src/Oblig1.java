////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;


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




    ////tileggsmetodter til oppgave 4(quicksort)//////
    public static int partisjon(int a[],int low,int high){

        int leftwall=low-1;
        for(int i = low; i< high; i++) {
            if (a[i] <= a[high]) {
                leftwall++;
                Oblig1.bytt(a,leftwall,i);
            }

        }
        Oblig1.bytt(a,leftwall+1, high);
        return leftwall+1;


    }
    public static void quickSort(int[] a,int low, int high){
        if(low<high){
            int midt= partisjon(a,low,high);

            quickSort(a,low,midt-1);
            quickSort(a,midt+1,high);
        }

    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a){
        if (a.length==0) return;

        int antallOddetall=0;
        for(int i:a){
            if(i%2!=0) antallOddetall++;
        }
        int t=a[0];
        int start=a.length-1;
        for(int i=0;i<antallOddetall;i++){
            if(a[i]%2==0){
                t=a[i];
                for(int j=start;j>=antallOddetall;j--){
                    if(a[j]%2!=0){
                        start=j;

                        a[i]=a[j];
                        a[j]=t;
                        break;
                    }
                }
            }
        }
        quickSort(a,0,antallOddetall-1);
        quickSort(a,antallOddetall,a.length-1);


        /*int svn=a[0];
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
        for(int i=od;i<a.length-1;i++){
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

        }*/

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
        char[] b = new char[a.length];

        //sjekker om det skal roteres mer enn en "runde" og endrer k slik at metoden fungerer
        while(Math.abs(k) > a.length-1){
            if(k<0){
                k = a.length - Math.abs(k);
            }else{
                k = Math.abs(a.length - Math.abs(k));
            }

            //System.out.println(k);
        }

        //legger bokstavene i et nytt array på den roterte plassen
        if(k>0){
            for(int i = 0; i<a.length; i++){
                if(i+k < a.length){
                    b[i+k] = a[i];
                    //System.out.println("1" + Arrays.toString(b));
                }else{
                    b[i-a.length+k] = a[i];
                    //System.out.println("2" + Arrays.toString(b));
                }
            }
        }else if(k<0){
            for(int i = a.length-1; i>=0; i--){
                if(i+k >= 0){
                    b[i+k] = a[i];
                    //System.out.println("1" + Arrays.toString(b));
                }else{
                    b[i+a.length+k] = a[i];
                    //System.out.println("2" + Arrays.toString(b));
                }
            }
        }else{ //om k=0
            System.arraycopy(a, 0, b, 0, a.length); //kanskje unødvendig
        }

        System.arraycopy(b, 0, a, 0, a.length);
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

        char[] al={'A','B','C','D','E','F','G','H','I',
                'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};
        for(int i=0;i<al.length;i++){
            if(al[i]==bokstav) return i;
        }
        return 31;
    }

    public static void mengde(char[] a,int[] b){
        for (char c : a) {
            b[bokstavNr(c)]+=1;
        }
    }

    public static boolean inneholdt(String a, String b) {
        char[] charA=a.toCharArray();
        char[] charB=b.toCharArray();
        int lengde=32;

        int[] charAMengde = new int[lengde];
        int[] charBMengde = new int[lengde];
        mengde(charA,charAMengde);
        mengde(charB,charBMengde);

         for(int i=0;i<lengde-2;i++){
             if(charBMengde[i]<charAMengde[i]){
                 return false;
             }
         }
         return true;
    }

}  // Oblig1
