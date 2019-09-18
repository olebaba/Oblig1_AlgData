/*
Ole Bastian Løchen - S333758
Daniel Woldegiorgis - S305207
Thomas Horn - S326288
*/

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class Oblig1 {
    private Oblig1() {
    }

    ///// Oppgave 1 /////////////////////////////////////
    /*
     * Det blir flest ombyttinger når n blir stort, når tabellen er sortert fra sinkende til størst
     * , da blir antall ombyttinger lik n (tabellstørelse)
     * Det blir færrest ombyttinger når n=1, når tabellen
     * gjennomsnitt for en tabell på 100n blir 87
     *
     */
    public static void gjennomsnitt(){
        Function<Integer,int []> tabell= (size)->{
            Random r= new Random();
            int[] arr= new int[size];
            for(int i=0;i<arr.length;i++){
                arr[i]=r.nextInt(10);
            }
            return arr;
        };
        double bytter=0;
        int str=100;
        int gjennomkj=10000;
        for(int i=0;i<gjennomkj;i++){
            int[] arr= tabell.apply(str);
            bytter+=Oblig1.ombyttinger(arr);

        }
        System.out.println(bytter/gjennomkj);
    }
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

    public static int[] randPerm(int n)
    {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }
        return a;
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

    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(a.length<1){
            return;
        }
        char sist = a[a.length-1];

        for(int i = a.length-2; i>=0; i--){
            a[i+1] = a[i];
        }
        a[0] = sist;
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if (a.length < 1){
            return;
        }
        char[] b = new char[a.length];

        //sjekker om det skal roteres mer enn en "runde" og endrer k slik at metoden fungerer
        while(Math.abs(k) > a.length-1){
            if(k<0){
                k = a.length - Math.abs(k);
            }else{
                k = Math.abs(a.length - Math.abs(k));
            }
        }

        //legger bokstavene i et nytt array på den roterte plassen
        if(k>0) {
            for(int i = 0; i<a.length; i++){
                if(i+k < a.length){
                    b[i+k] = a[i];
                }else{
                    b[i-a.length+k] = a[i];
                }
            }
        }else if(k<0){
            for(int i = a.length-1; i>=0; i--){
                if(i+k >= 0){
                    b[i+k] = a[i];
                }else{
                    b[i+a.length+k] = a[i];
                }
            }
        }else{ //om k=0
            System.arraycopy(a, 0, b, 0, a.length); //kanskje unødvendig/tungvindt
        }

        System.arraycopy(b, 0, a, 0, a.length);
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {

        int l = Math.min(s.length(), t.length());  // lengden på den korteste  
        StringBuilder n = new StringBuilder(); //StringBuilder klasse i loop for oppbygging av tegnstreng

        for (int i = 0; i < l; i++)
        {
          n.append(s.charAt(i)).append(t.charAt(i));
        }

        n.append(s.substring(l)).append(t.substring(l)); //Legger til resten

       return n.toString();
    }

    /// 7b)
    public static String flett(String... s) {
        //throw new NotImplementedException();
        int max=0;
        for(String i:s){
            if(i.length()>max){
                max=i.length();
            }
        }
        StringBuilder sb = new StringBuilder();

        int kar_nr = 0;
        while (kar_nr < max){
            for (String value : s) {
                if (value.length() > kar_nr) {
                    sb.append(value.charAt(kar_nr));
                }
            }
            kar_nr++;
        }
        return sb.toString();
    }


    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int[] svar=new int[a.length];
        int[] aSortert=a.clone();
        Oblig1.quickSort(aSortert,0,a.length-1);

        int index=0;
        for(int i=0;i<a.length;i++){

            for(int j=0;j<a.length;j++){
                if(aSortert[i]==a[j]) index=j;
            }

            svar[i]=index;
        }
        return svar;
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        if(a.length<3){
            throw new NoSuchElementException("Tabellen har færre enn 3 elementer.");
        }

        int m = 0;      // m er posisjonen til minste verdi
        int nm = 1;     // nm er posisjonen til nest minste verdi
        int tm = 2;     // tm er posisjonen til tredje minste verdi

        //hjelpetabell
        int[] b = new int[3];
        for (int i = 0; i<b.length; i++){
            b[i] = a[i];
        }

        //skal bestemme posisjon til minste, nest minste og tredje minste
        int[] c = indekssortering(b);
        m = c[0]; nm = c[1]; tm = c[2];

        int minstverdi = a[m];                // minste verdi
        int nestminstverdi = a[nm];           // nest minste verdi
        int tredjeminstverdi = a[tm];         // tredje minste verdi

        for (int i = 3; i < a.length; i++)
        {
            if(a[i] < tredjeminstverdi) {
                if (a[i] < nestminstverdi) {
                    if (a[i] < minstverdi) {
                        tm = nm;
                        tredjeminstverdi = nestminstverdi; // ny tredje størst

                        nm = m;
                        nestminstverdi = minstverdi;     // ny nest størst

                        m = i;
                        minstverdi = a[m];              // ny størst
                    } else {
                        tm = nm;
                        tredjeminstverdi = nestminstverdi; // ny tredje størst

                        nm = i;
                        nestminstverdi = a[nm];         // ny nest størst
                    }
                }else{
                    tm = i;
                    tredjeminstverdi = a[tm];        // ny tredje størst
                }
            }
        }

        return new int[] {m, nm, tm};    // n i posisjon 0, nm i posisjon 1, tm i posisjon 2
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
