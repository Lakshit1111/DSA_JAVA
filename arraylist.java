import java.util.ArrayList;
import java.util.Collections;

public class arraylist {

    static boolean pair_sum_2(ArrayList<Integer> al , int target){
        int bp = -1;
        int n = al.size() ;
        for(int i = 0 ; i< n-1 ;i++){
            if(al.get(i) > al.get(i+1)){
                bp = i;
                break ;
            }
        }
        int i = bp+1;
        int j = bp;
        while(i!=j){
            if(al.get(i) + al.get(j) == target){
                return true;
            }
            if(al.get(i) + al.get(j) > target)
                j = (j+n-1)%n;
            else {
                i = (i+1)%n;
            }
        }

        return false;
    }
    static void loneNumber(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<>();
        Collections.sort(a);
        for(int i = 0 ; i<a.size()-1 ;i++){
            if(a.get(i) != a.get(i+1) && a.get(i)+1 != a.get(i+1)){
                if(i == 0 || (i != 0 && a.get(i-1) != a.get(i)-1 && a.get(i-1) != a.get(i))){
                    b.add(a.get(i));
                }
            }
        }
        if(a.get(a.size()-1) != a.get(a.size()-1) -1 ){
            b.add(a.get(a.size()-1));
        }
        System.out.println(b);
    }
    public static void main(String[] arg){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(3);
        System.out.println(a);
        loneNumber(a);
    }
}
