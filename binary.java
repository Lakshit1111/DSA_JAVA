public class binary {

    public static int Binary_Search(int[] a , int target){
        int start = 0 ;
        int end = a.length-1;

        while(start <= end) {
            int mid = (start + end)/2;

            if (a[mid] == target) {
                return mid;
            }
            else if (a[mid] > target) {
                end = mid-1;
            }
            else if (a[mid] < target) {
                start = mid + 1;
            }
//            System.out.println(start + " " + mid +  " " + end);
        }
        return -1;
    }

    public static void main(string[] arg){
        int[] a = {1,3,5,7,8,10,34,56};
        System.out.println(Binary_Search(a , 34));

    }
}
