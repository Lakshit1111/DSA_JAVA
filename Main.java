
public class Main {

    public static int kadans(int[] a){
        int curr = 0;
        int maxsum = Integer.MIN_VALUE;

        for(int i : a){

            curr += i;
            if(curr + i < 0){
                curr = 0;
            }
            maxsum = maxsum> curr ? maxsum : curr ;
            System.out.println(maxsum + " safjao" + " " + i + " " + curr);
        }
        return maxsum;
    }

    public static int kn(int a[]){
        int curr = 0;
        int maxsum = Integer.MIN_VALUE;

        for(int i : a){
            curr += i;


            maxsum = maxsum> curr ? maxsum : curr ;
            System.out.println(maxsum + " safjao" + " " + i + " " + curr);
        }
        return maxsum;
    }
    public static void main(string[] args) {
        int[] a = {-1,-2,3,4};
        System.out.println(kadans(a));
    }
}