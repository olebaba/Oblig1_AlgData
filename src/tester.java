import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class tester {
    public static void ds(int a[],int h,int l){
        int piv = a[h];


        for(int i=l-1;i<=h-1;i++){
            if(a[i]<piv){
                l++;
                Oblig1.bytt(a,l-1,i);
            }
        }
        Oblig1.bytt(a,l,h);


    }
    public static int par1(int a[],int s, int e){
        int count=0;

       for (int i=s;i<e-2;i++){
           if(a[i]>a[i+1]){
               Oblig1.bytt(a,i,i+1);
               count++;
           }
       }
       return count;

    }
    public static int par3(int a[],int s, int e){
        int count=0;
        for(int i=0; i<e-1;i++){
            for (int j=e-1;j>1;j--){
                if(a[i]>a[j]){
                    Oblig1.bytt(a,i,j);
                    count++;
                }
            }

        }
        return count;
    }
    public static void main(String[] args) {
        //long tid = System.currentTimeMillis();
        //tid = System.currentTimeMillis() - tid;
        //System.out.println(tid);

        //System.out.println(Arrays.toString(b));
        /*ord2=ord2.substring(0,1)+ord2.substring(2);
        System.out.println(ord2);*/
        String a= "ABBA";
        String b= "A";
        String c="";


    }
    public static void qqs(int[]a){
        boolean uferdig=true;
        int low=0;
        int high=a.length-1;
        int midt=(low+high)/2;
        int byttv;
        int bytth=0;
        while (uferdig){
            //System.out.println("a"+" "+midt);
            Oblig1.bytt(a,midt,high);
            for(int i=low; i<midt;i++){
                if(a[i]>a[midt]){
                    byttv=i;
                    for (int j=high-1;j>=midt+1;j--){
                        if(a[j]<a[midt]){
                            bytth=j;
                            break;
                        }
                    }
                    Oblig1.bytt(a,byttv,bytth);

                }
            }
            Oblig1.bytt(a,high,midt);
            high=midt;
            midt=(low+high)/2;
            if(high==low){
                uferdig=false;
            }

        }
    }
    public static int qss1(int a[],int low,int high){

        int left=low-1;
        for(int i = low; i< high; i++) {
            if (a[i] <= a[high]) {
                left++;
                Oblig1.bytt(a,left,i);
            }
            System.out.println(Arrays.toString(a));
        }
        Oblig1.bytt(a,left+1, high);
        return left+1;


    }

    public static void qss2(int[] a,int low, int high){
        if(low<high){
            int midt= qss1(a,low,high);

            qss2(a,low,midt-1);
            qss2(a,midt+1,high);
        }

    }

}