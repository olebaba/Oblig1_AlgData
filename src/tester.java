import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

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
        /*String a= "ABBA";
        String b= "A";
        String c="";
        double ob=0;
        for(int i=0;i<10000;i++){
            int[] arr=randomT(100);
            ob+=Oblig1.ombyttinger(arr);


        }
        System.out.println(ob/10000);
        System.out.println(snitt(1000));
        System.out.println(Math.log(1000)
        );*?

         */


    }

    public static int[] randomT(int size){
        Random r= new Random();
        int[] arr= new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(10);
        }
        return arr;
    }
    public static double snitt(int length){
        double sum =0;
        for (int i=1;i<length;i++){
            sum+=(Math.log(i)+ 0.577);

        }

        return sum;
    }

}
