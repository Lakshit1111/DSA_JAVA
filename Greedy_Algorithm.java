import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy_Algorithm {

    public static void Activity_Selection(int[] start , int[] end){ // O(nlogn)
        // End time basis sorted
        int activities[][] = new int[start.length][3]; // In this col are index , start element and end element.
        for(int i = 0 ; i<start.length ; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // lambda function =  ->
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));




        int maxAct = 0 ; // Count the number of Activity
        ArrayList<Integer> ans = new ArrayList<>(); // Store the index

        // 1st activity
        maxAct += 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        // For other activity
        for(int i = 1 ; i<start.length ; i++){
            if(activities[i][1] >= lastEnd){
                // activity Selection
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum Activity = " + maxAct);

        for(int i = 0 ;i<ans.size() ;i++ ){
            System.out.println("A" + ans.get(i) + " ");
        }
        System.out.println();

        for(int i = 0 ; i<start.length ; i++){
            for(int j = 0 ;j<3 ; j++ ) {
                System.out.print(activities[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void Fractional_Knapsack(int val[] , int weight[] , int capacity){
        double ratio[][] = new double[val.length][2];// col1 = index , col2 = ratio

        for(int i = 0 ; i<val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        // Sorting in Ascending
        Arrays.sort(ratio , Comparator.comparingDouble(o -> o[1]));

        int finalVal = 0;
        for(int i = ratio.length-1;i>=0 ; i-- ){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }else {
                // include fractional Item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Max Capacity " + finalVal);

    }

    public static void Absolute_min_difference(int[] a , int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int diff = 0;
        for(int i = 0 ; i<a.length ; i++){
            diff += Math.abs(a[i] - b[i]);
        }

        System.out.println("Minimum Absolute difference " + diff);

    }

    public static void Indian_coins(int target){
        int coins[] = {1,2,5,10,20,50,100,500,2000};
        int no[] = new int[coins.length];
        int snn = 0;
        for(int i = coins.length-1 ; i>=0 ; i--){
            snn += target/coins[i];
            no[i] = target/coins[i];
            target = target%coins[i];
        }

        System.out.println("Minimum number coins/notes : " + snn);
        int j = 0;
        for(int i : no){
            if(i != 0){
                System.out.print( "(" +coins[j]+ ")" +i + " ");
            }
            j++;
        }

    }

    public static void chocola( int[] vert , int[] hori){
        Arrays.sort(vert);
        Arrays.sort(hori);
        int i = hori.length-1;
        int j = vert.length-1;
        int h = 1;
        int v = 1;
        int cost = 0;

        while( i >=0 && j>=0){

            if(hori[i] >= vert[j]){
                cost += hori[i]*(v);
//                System.out.println( hori[i] + " " + v);
                i--;
                h++;
            }else {
                cost += vert[j] * (h);
                j--;
                v++;
            }
        }
        while(i>=0){
            cost += hori[i]*(v);
            i--;
            h++;
        }
        while(j >= 0){
            cost += vert[j]*(h);
            j--;
            v++;
        }
        System.out.println(cost);
    }



    public static int balance(String str ,int n){
        int r = 0 ; int l = 0;
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            if(str.charAt(i) == 'L'){
                l++;
            }else{
                r++;
            }
            if(r == l){
                ans++;
                System.out.println(i);
            }
        }
        return ans;
    }

    public static int kLargest(int L , int R , int K){
        int ans = R - 2*(K-1);
        if(ans < L){
            return 0;
        }
        if(R%2 == 0){return ans-1;}
        return ans;
    }

    public static void Lexicographically(int N , int K){

    }

    public static void main(String[] arg){

//        System.out.println(kLargest(-100 , 100 , 245));
        for(int i = 'a' ; i<='z' ;i++){
            System.out.println((char)i+" " + (i-96));

        }
    }
}








