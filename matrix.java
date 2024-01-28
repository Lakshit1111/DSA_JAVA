public class matrix {

    public static void digonal_sum_Matrix(int[][] a , int l){
        int total = 0;
        for(int i = 0 ; i<a.length ; i++){
            total += a[i][i];
        }
        int j =a.length - 1 ;
        for(int i = 0 ; i<a.length ; i++ ,j--){
            if(i == j){continue ; }

            total += a[i][j];
        }
        System.out.println(total);
    }

    public static boolean sorted_matrix(int[][] a , int key){
        int i = 0;
        int j  = a.length-1;

        while(i < a.length && j>= 0 ){
//            System.out.println(i + " " + j);

            if(a[i][j] == key){
                System.out.println("Key found " + a[i][j]);
                return true;
            }
            else if (a[i][j] > key) {
                j--;
            }
            else if (a[i][j] < key){
                i++;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public static void transpose_matrix(int[][] a){
        int[][] q = new int[a.length][a[0].length];
        for(int i = 0 ; i<a[0].length ; i++){
            for(int j = 0 ; j<a.length ; j++){
                q[j][i] = a[i][j];
            }
        }
        for(int i = 0 ; i<a.length ; i++){
            for(int j = 0 ; j<a[0].length ; j++){
                System.out.print(q[i][j] +" ");
            }
            System.out.println();
        }

    }
    public static void main(string[] arg){
        int[][] a = {{1,3,5},
                     {5,2,3}};
        transpose_matrix(a);


    }
}
