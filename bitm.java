import java.util.*;
public class bitm {
    static int factorial(int n)
    {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
    public static void countbin(int a){
        int count = 0;
        while (a!=0){
            if((a & 1) != 0){
                count++;
            }
            a = a>>1;
        }
        System.out.println(count);
    }
    public static void fastex(int a,int n){
        int ans = 1;
        while(n>0){
            if((n&1) != 0) {
                ans *= a;
            }
            a *= a;
            n = n>>1;
            System.out.println("jsdfw " + ans);
        }
        System.out.println(ans);
    }
    public static void bin(int n){

        StringBuilder binaryno = new StringBuilder("");
        while(n>0){
            binaryno.append(n & 1);
            n = n>>1;
        }
        System.out.println(binaryno.reverse());
    }
    public static void main(String[] arg){
        int x = 4;
        int y = -2;
        char q = 'A';
        char w = ' ';
        x = x^y;
//        y = x^y;
//        x = x^y;
        bin('a');
        bin('b');
        bin('y');
        bin('z');
//        fastex(3,20);
    }
}
