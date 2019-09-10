import java.util.NoSuchElementException;

public class noe {

    if(a.length<1){
        throw new NoSuchElementException("Tabellen finnes ikke!");
    }

    int maks = a[0];
        for(int i = 1; i<a.length; i++){
        if(a[i]<maks){
            int temp = a[i];
            a[i] = maks;
            maks = temp;
        }
    }

        return maks;
}
