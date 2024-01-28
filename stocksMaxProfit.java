public class stocksMaxProfit {
    public static int maxProfit(int[] a ){
        int profit = 0;
        int diff = 0;
        int smallest = Integer.MAX_VALUE;

        for(int i : a){

            if(smallest > i){ smallest = i; }
            diff = i - smallest;

            profit = diff > profit ?diff : profit ;
        }
        return profit;
    }

    public static void main(string[] arg){
        int[] a = {7, 6, 4,  3, 1};
        int p = maxProfit(a);
        System.out.println(p);
    }
}
