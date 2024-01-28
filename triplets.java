import java.util.ArrayList;
import java.util.HashSet;

public class triplets {

    public static ArrayList<ArrayList<Integer>> tri(int[] a){
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<ArrayList<Integer>> c = new ArrayList();

        for(int i = 0 ; i<a.length-2 ; i++){
            for(int j = i+1 ; j<a.length-1 ; j++){
                for( int k = j+1 ; k<a.length ; k++){
                    System.out.println(i + " " + j + " " + " " + k);
                    if (a[i] + a[j] + a[k] == 0){
                        b.add(a[i]);
                        b.add(a[j]);
                        b.add(a[k]);
                        c.add(b);
                        System.out.println(c);
                        b = new ArrayList<>();
                    }
                }
            }
        }
        c = new ArrayList<>(new HashSet<>(c));
        return c;
    }
    public static void main(string[] arg){
        int a[] = {-1, 0,  1, 2, -1, -4};
        System.out.println(tri(a));
    }
}
