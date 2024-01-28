public class backtracking {

    public static void findSubset(String a , String b , int i){
        if(i==a.length()){
            System.out.print(b +" ");
            return;
        }
        findSubset( a, b , i+1);
        findSubset( a, b+a.charAt(i) , i+1);
    }

    public static void permutaition(String a , String b){
        if(a.length() == 0){
            System.out.println(b);
            return;
        }
        for(int i = 0 ; i<a.length() ; i++){
            char q = a.charAt(i);
            String str = a.substring(0,i) +  a.substring(i+1);
        }
    }
//    nKnights


    static int count;
    static void nKnights(char[][] a , int n){
        if(n == a.length){
//            printmat(a);
            count++;
            return;
        }
        for(int i = 0 ;i<a.length ;i++){
            if(cheakknight(a , n ,i)) {
                a[n][i] = 'K';
                nKnights(a, n + 1);
                a[n][i] = 'x';
            }
        }
    }
    static boolean cheakknight(char[][] a , int row , int col){

        if(row - 2 >=0 && col -1 >=0){
            if(a[row-2][col-1] == 'K'){
                return false;
            }
        }
        if(row - 1 >=0 && col -2 >=0){
            if(a[row-1][col-2] == 'K'){
                return false;
            }
        }
        if(row - 2 >=0 && col +1 <a.length){
            if(a[row-2][col+1] == 'K'){
                return false;
            }
        }
        if(row - 1 >=0 && col +2 < a.length){
            if(a[row-1][col+2] == 'K'){
                return false;
            }
        }
        return true;
    }

    static void mouseTrap(int[][] a , int row , int col , int[][] sol){
        if(row == a.length-1 && col == a.length-1){
            sol[row][col] = 1;
            printmat(sol);
            System.out.println("-------------mouseTrap-------------");
            return;
        }
//        Up
        if(row-1>0 && a[row-1][col] == 1){
            a[row][col] = 2;
            sol[row][col] = 1;
            mouseTrap(a,row-1,col,sol);
            a[row][col] = 1;
            sol[row][col] = 0;
        }
//        Down
        if(row+1<a.length && a[row+1][col] == 1){
            a[row][col] = 2;
            sol[row][col] = 1;
            mouseTrap(a,row+1,col,sol);
            a[row][col] = 1;
            sol[row][col] = 0;
        }
//        Right
        if(col+1<a.length && a[row][col+1] == 1){
            a[row][col] = 2;
            sol[row][col] = 1;
            mouseTrap(a,row,col+1 , sol);
            a[row][col] = 1;
            sol[row][col] = 0;
        }
//        Left
        if(col-1>0 && a[row][col-1] == 1){
            a[row][col] = 2;
            sol[row][col] = 1;
            mouseTrap(a,row,col-1,sol);
            a[row][col] = 1;
            sol[row][col] = 0;
        }

    }

    static boolean Suduko_solver(int[][] suduko , int row , int col){
//Base case
        if(row == 9){
            printmat(suduko);
            return true;
        }
//        Recurrsion
        int nextrow = row ; int nextCol = col+1;
        if(col+1 ==9){
            nextrow = row+1;
            nextCol= 0;
        }
        if(suduko[row][col] != 0){
            return Suduko_solver(suduko , nextrow , nextCol);
        }

        for(int i = 1 ; i<= 9 ; i++){
            if(isSafe(suduko , row , col ,i)){
                suduko[row][col] = i;
                if(Suduko_solver(suduko , nextrow , nextCol)){
                    return true;
                }
                suduko[row][col] = 0;
            }
        }
        return false;
    }
    static boolean isSafe(int[][] suduko , int row , int col ,int num){
//        Column
        for(int i = 0 ; i<9 ;i++){
            if(suduko[row][i] == num)
                return false;
        }
//        Row
        for(int i = 0 ; i<9 ;i++){
            if(suduko[i][col] == num)
                return false;
        }
//        formula of finding starting index
        int strRow = (row/3)*3;
        int strCol = (col/3)*3;

        for(int i = strRow ; i<strRow+3 ; i++){
            for(int j = strCol ;j <strCol+3 ; j++){
                if(suduko[i][j] == num)
                    return false;
            }
        }

        return true;
    }
    static void printmat(char[][] a){
        for(int i =0 ; i<a.length ; i++){
            for(int j = 0 ; j<a.length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------nKnight-------------");
    }

    static void printmat(int[][] a){
        for(int i =0 ; i<a.length ; i++){
            for(int j = 0 ; j<a.length ; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] arg){
        int[][] a = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        Suduko_solver(a,0,0);
//        printmat(a);
    }

}
