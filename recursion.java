import java.util.*;
public class recursion {

    public static int fibb(int n ){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return fibb(n-2) +fibb(n-1);
    }

    public static int power(int a , int n ){ // O(log(n))
        if(n==0){
            return 1;
        }
        int halfpower = power(a,n/2);
        int halfpowersq = halfpower * halfpower;

        if(n%2 != 0){
            halfpowersq *= a;
        }

        return halfpowersq;
    }

    public static int tile(int n , char q){

        if(n == 0){
            return 1;
        }
        if(n<0){return 0;}

        int h = n-2>=0 ? n-2:-1;
        int v = n-1;
//        System.out.println(n + " " + q);
        return tile(h , 'h') + tile(v,'v');
    }

    public static void removeduplicte(int index , String text , StringBuilder newtext , boolean map[]){

        if(index == text.length()){
            System.out.println(newtext);
            return ;
        }
        if(!(map[text.charAt(index) - 'a'])) {
            map[text.charAt(index) - 'a'] = true;
            newtext.append(text.charAt(index));
            removeduplicte(++index, text, newtext, map);
        }else {
            removeduplicte(++index , text , newtext,map);
        }

    }

    public static void merge_sort(int i , int j , int[] a){

         if( i >= j){
             return;
         }
         int mid = i+ (j-i)/2;
         merge_sort(i , mid , a);
         merge_sort(mid+1 , j, a);
         merge(i, mid , j , a);

    }
    public static void merge(int start , int mid ,int end, int[] a){
        int[] temp = new int[end-start+ 1];
        int i = start;
        int j = mid+1;
        int k = 0;
//        System.out.println( start + " " + mid + " " + end);

        while(i<=mid && j<=end){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
//            System.out.println("hii " + i + " " + mid);
            temp[k++] = a[i++];
        }
        while(j<=end){
            temp[k++] = a[j++];
        }
        for(k = 0 , i = start ; k<temp.length ; k++,i++){
            a[i] = temp[k];
        }

    }



    static int friends(int n) {
        if (n == 1 | n == 2) {
            return n;
        }
        // Single
        int fnm1 = friends(n-1);
        // double
        int fnm2 = friends(n-2);
        int ways = n-1 * fnm2;

        return fnm1 + ways;

    }
//    Quick sort
    public static void quick_sort(int[] arr , int start , int end ){
        if(start >= end){
            return;
        }

        int n = start-1;
        int piviot = arr[end];
        for(int i = start ; i<=end ; i++){
            if(piviot >= arr[i] ){
                n++;
                int temp = arr[i];
                arr[i] = arr[n];
                arr[n] = temp;
            }
        }
        quick_sort(arr , start , n-1);
        quick_sort(arr , n+1 , end);

    }


    static void printarr(int[] arr){
        for(int i = 0 ; i< arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] arg){
        int[] q = {2,2,1,1,3,3,3,3,3,3,3,3,3,3,3,3,31,2,2};
        merge_sort(0 ,q.length-1 , q);
//        quick_sort(q , 0 , q.length-1);
        printarr(q);
        System.out.println("\n" + q[(q.length)/2]);


    }
}


