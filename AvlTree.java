import java.util.LinkedList;
import java.util.Queue;

public class AvlTree {
    static class Node{
        int data , height;
        Node left , right;
        Node(int data){
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

//    public static Node root;

    public static int height(Node root){
        if(root== null){return 0;}
        return root.height;
    }

    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x){
        Node y= x.right;
        Node T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) +1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        // new Node
        return y;
    }

    public static Node rightRotate(Node y){
        Node x= y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // new Node
        return x;
    }

    public static Node insert(Node root , int key){
        if(root == null){
            return new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left , key);
        }else if(key > root.data){
            root.right = insert(root.right , key);
        }else{
            return root; // Duplicate are not allowed
        }

        // Update root height
        root.height = 1+ Math.max(height(root.left) , height(root.right));

        // Get root's balance factor
        int bf = getBalance(root);

        // Left Left Case
        if(bf>1 && key<root.left.data){
            return rightRotate(root);
        }

        //Right Right Case
        if(bf<-1 && key>root.right.data){
            return leftRotate(root);
        }

        // Left Right Case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Left Right Case
        if(bf <-1 && key < root.left.data) {
            root.right = leftRotate(root.right);
            return rightRotate(root);
        }

        return root;  // AVL is balance

    }

    public static Node search(Node root , int key){
        if(root == null){
            return null;
        }

        if( key < root.data ){
            return root.left;
        }
        if(key > root.data){
            return root.right;
        }

        return root;
    }

    public static Node InorderSuccesor(Node root){
        if(root.left == null){
            return root;
        }
        return InorderSuccesor(root);
    }

    public static Node DeleteNode(Node root , int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = DeleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = DeleteNode(root.right, key);
        } else {
            // No Child
            if (root.left == null && root.right == null) {
                return null;
            }
            // One Child
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            // Two Child
            Node in = InorderSuccesor(root.right);
            root.data = in.data;
            DeleteNode(root.right, in.data);
        }

        // New height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get root Balance
        int bf = getBalance(root);

        // There are 4 condition
        // Left Left
        if (bf > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Right Right
        if (bf < -1 && getBalance(root.right) < 0) {
            return rightRotate(root);
        }

        // Left Right
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

//        Right Left
        if (bf < -1 && getBalance(root.right) >= 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }


        return root;
    }

    public static void preorder(Node root){
        if(root == null){return ;}
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void levelOrderTravesal(Node node){ // O(n)
        if(node == null){
            return ;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
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

    public static void main(String[] arg){
        Node root = null;
        root = insert(root , 10);
        root = insert(root , 20);
        root = insert(root , 30);

        root = insert(root , 23);
        root = insert(root , 40);
        root = insert(root , 50);
        root  = insert(root, 25);
//        root = insert(root , 9);
        levelOrderTravesal(root);
        System.out.println();
        preorder(root);
        root =DeleteNode(root , 50);
        System.out.println();
        levelOrderTravesal(root);
        System.out.println();
        preorder(root);

    }







}
