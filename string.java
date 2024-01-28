public class string {

    public static boolean anagrams(String a , String b){

        if (a.length() != b.length()){
            return false;
        }
        if(a.length() == 0){
            return true;
        }

        int num = 0;

        for(int i =0 ; i< a.length() ; i++){

            num += a.charAt(i) - b.charAt(i);

        }
        if(num != 0){
            return false;
        }

        return true;
    }


    public static void main(String[] arg){
        String a = "aaaabdwbee";
        String b = "abeqadaeba";
        int t = 1;
        for(int i = 0 ; i<6 ; i++){
            System.out.println(t<<1);
            t = t<<1;

        }

    }
}
