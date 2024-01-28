import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class bst {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void inorder(Node root){ // O(n)
        if(root == null){
            return ;
        }
        inorder(root.left );
        System.out.print(root.data + " ");

        inorder(root.right);
    }
    public static void inorder(Node root , ArrayList al){ // O(n)
        if(root == null){
            return ;
        }
        inorder(root.left , al);
        al.add(root.data);
        inorder(root.right , al);
    }

    public static void levelOrderTravesal(Node root){ // O(n)
        if(root == null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int i = 0;

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){break;}
                else{q.add(null);}
            }else{
                System.out.print(currNode.data + " ");

                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            i++;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }else{
            root.right = insert(root.right , val);
        }
        return root;
    }

    public static boolean search(Node root , int val){
        if (root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        if(root.data > val){
            return search(root.left , val);
        } else{
            return search(root.right , val);
        }
    }


    public static Node InOrderSuccesor(Node root){
        if(root.left == null){
            return root;
        }
        return InOrderSuccesor(root.left);
    }

    public static Node delete(Node root ,int val){

        if(root == null){
            System.out.println("\nValue doesn't exist ");
            return null;
        }
        if(val > root.data){
            root.right = delete(root.right , val);
        } else if (val < root.data) {
            root.left = delete(root.left , val);

        } else{
            // case 1 :- leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 :- one child
            else if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            // case 3 :- two child
            else{
                Node Is = InOrderSuccesor(root.right);
                root.data = Is.data;
                root.right = delete(root.right , Is.data);
            }
        }
        return root;
    }

    public static void printInRange(Node root , int k1 , int k2){
        if(root == null){return;}

        if(k1<=root.data && k2>=root.data){
            printInRange(root.left,k1 , k2);
            System.out.print(root.data+ " ");
            printInRange(root.right , k1 , k2);
        } else if(k1>root.data){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left , k1 , k2);
        }
        return;
    }

    public static void RootToLeafPath(Node root , ArrayList<Integer> path){
        if(root == null){
            return ;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }

        RootToLeafPath(root.left , path);
        RootToLeafPath(root.right , path);
        path.remove(path.size() - 1);

    }

    public static boolean isValid(Node root , Node min , Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data>= max.data){
            return false;
        }

        return isValid(root.left , min , root) && isValid(root.right , root , max);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }
    public int add(int num1) {
        return num1;
    }


    public static Node balanceBST(int[] arr ,int start , int end){
        if(start> end){
            return null;
        }
        int mid = start + (end-start)/2;
        Node root = new Node(arr[mid]);
        root.left = balanceBST(arr , start , mid-1);
        root.right = balanceBST(arr , mid+1 , end);
        return root;
    }

    static class info{
        boolean isvalid;
        int min;
        int max;
        int size;
        info(boolean bst , int min , int max , int size){
            isvalid = bst;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    static int maxsize = 0;
    public static info MaxValidBST(Trees.Node root){

        if(root.left == null && root.right == null){
            return new info(true , root.data, root.data , 1);
        }

        // Valid Bst
        info leftinfo = MaxValidBST(root.left);
        info rightinfo = MaxValidBST(root.right);
        int min = leftinfo.max;
        int max = rightinfo.min;
        boolean isvalid = (root.data>= min && root.data<=max && leftinfo.isvalid && rightinfo.isvalid);
//        System.out.println(root.data + " " +  (root.data>=max) + max);

        //
        min = Math.min(Math.min(rightinfo.min , leftinfo.min) , root.data );
        max = Math.max(Math.max(rightinfo.max , leftinfo.max) , root.data );
        int size = leftinfo.size + rightinfo.size +1;

        if(maxsize < size  && leftinfo.isvalid && rightinfo.isvalid){maxsize = size;}

        return new info(isvalid , min , max ,size);

    }



    public static Node MergeTree(Node root1 , Node root2){
        ArrayList<Integer> r1 = new ArrayList();
        ArrayList<Integer> r2 = new ArrayList();
        inorder(root1 , r1);
        inorder(root2 , r2);

        int[] r12 = new int[r1.size() + r2.size()];
        int i = 0 ,j = 0 ;
        while(i<r1.size() && j<r2.size()){
            if(r1.get(i) <= r2.get(j) ){
                r12[i+j] = (r1.get(i));i++;
            }else {
                r12[i + j] = (r2.get(j));
                j++;
            }
        }
        while(i<r1.size()){
            r12[i+j] = (r1.get(i));i++;
        }
        while(j<r2.size()){
            r12[i+j] = (r2.get(j));j++;
        }

        for(int l : r12){
            System.out.print(l +" ");
        }

        return balanceBST(r12, 0 , r1.size() + r2.size() - 1);
    }

    public static void main(String arg[]){
//        int[] arr = {1, 2,3,4,5,6,7,8,9,10};
//        Node root = null;
//        for(int i = 0 ; i<arr.length ; i++){
//            root = insert(root, arr[i]);
//        }

        Node root1 = new Node(2);
        root1.left =  new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.right  = new Node(12);
        root2.left = new Node(3);


        levelOrderTravesal(root1);
        System.out.println();
        levelOrderTravesal(root2);
        System.out.println();
        Node root = MergeTree(root1,root2);
        System.out.println();
        levelOrderTravesal(root);


    }
}
