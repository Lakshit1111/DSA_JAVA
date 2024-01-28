import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class Trees {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class binary_trees{
        static int idx = -1;
        public static Node buildTree(int nodes[]){ // O(n)
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            if(idx == nodes.length-1){
                idx = -1;
            }

            return newNode;
        }
    }

    public static void preorder(Node root){ // O(n)
        if(root == null){
            System.out.print("Null ");
            return;
        }
        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){ // O(n)
        if(root == null){
            return;
        }
        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void postorder(Node root){ // O(n)
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
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
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) +1;
    }

    public static int diameter(Node root){ // O(N^2)
        if(root == null){
            return 0;
        }
        int leftDia = diameter(root.left);
        int leftHt = height(root.left);
        int rightDia = diameter(root.right);
        int rightHt = height(root.right);

        int selfDia = leftHt + rightHt +1;
        return Math.max(selfDia , Math.max(leftDia,rightDia));
    }

//  More Better approch for diameter

    static class Info{
            int diam;
            int ht;
            public Info(int diam , int ht){
                this.diam = diam;
                this.ht = ht;
            }
    }

    public static Info diameter1(Node root){ // O(N)
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter1(root.left);
        Info rightInfo = diameter1(root.right);
        int diam = Math.max(Math.max(leftInfo.diam , rightInfo.diam) , leftInfo.ht +rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;
        return new Info(diam,ht);
    }

    public static boolean isIdentical(Node root1 , Node root2){
        if(root1 == null && root2 == null){
            return true;
        } else if (root1 == null || root2== null) {
            return false;
        } else if (root1.data != root2.data) {
            return false;
        }
        if(!isIdentical(root1.left , root2.left)){
            return false;
        }
        if(!isIdentical(root1.right , root2.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root1 , Node root2){
        if(root1 == null){
            return false;
        }
        if(root1.data == root2.data){
            if(isIdentical(root1,root2)){
                return true;
            }
        }
        return isSubtree(root1.left,root2) || isSubtree(root1.right,root2);
    }

    static class infoo {
        Node node;
        int hd;  // Horizontal distance

        public infoo(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        // level order
        Queue<infoo> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();

        int min = 0 , max = 0;
        q.add(new infoo(root,0));
        q.add(null);

        while(!q.isEmpty()){
            infoo curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd , curr.node);
                }
                if(curr.node.left != null) {
                    q.add(new infoo(curr.node.left,curr.hd-1));
                    min = Math.min(curr.hd-1 , min);
                }
                if(curr.node.right != null){
                    q.add(new infoo(curr.node.right,curr.hd+ 1));
                    max = Math.max(curr.hd+1 , max);
                }
            }
        }
        for(int i = min; i<=max ; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void lowerView(Node root){
        // level order
        Queue<infoo> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();

        int min = 0 , max = 0;
        q.add(new infoo(root,0));
        q.add(null);

        while(!q.isEmpty()){
            infoo curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                map.put(curr.hd , curr.node);
                if(curr.node.left != null) {
                    q.add(new infoo(curr.node.left,curr.hd-1));
                    min = Math.min(curr.hd-1 , min);
                }
                if(curr.node.right != null){
                    q.add(new infoo(curr.node.right,curr.hd+ 1));
                    max = Math.max(curr.hd+1 , max);
                }
            }
        }
        for(int i = min; i<=max ; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static boolean getPath(Node root , int n , ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }
        if(getPath(root.left, n , path) || getPath(root.right, n, path)){
            return true;
        }
        path.remove(path.size() -1);
        return false;
    }

    public static Node lca(Node root , int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root , n1 , path1);
        getPath(root,n2 , path2);

        int i = 0;
        for(; i<path1.size() ; i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // last equal node -> i-1th
        Node lca = path1.get(i-1);
//        for(Node j : path1){ System.out.print(j.data + " ");}
//        System.out.println();
//        for(Node j : path2){ System.out.print(j.data +" ");}
//        System.out.println();

        return lca;
    }

    public static Node lca2(Node root , int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left , n1 , n2);
        Node rightlca = lca2(root.right , n1 , n2);

        // left  = valid , rigth = null
        if(rightlca == null ){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root;
    }

    public static int mindistance(Node root , int n1, int n2){
        if (root == null){
            return 0;
        }
        if(root.data == n1 || root.data == n2){
            return 1;
        }

        int leftlca = mindistance(root.left , n1 , n2);
        int rightlca = mindistance(root.right , n1 , n2);

//         left  = valid , rigth = null
        if(rightlca == 0 && leftlca == 0){return 0;}
        if(rightlca == 0 ){
            return leftlca+1;
        }
        if(leftlca == 0){
            return rightlca+1;
        }
//        System.out.println(" sfis " + (rightlca + leftlca));
        return rightlca + leftlca;
    }

    public static int KAncesstor(Node root , int n , int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }

        int leftDist = KAncesstor(root.left , n , k );
        int rightDist = KAncesstor(root.right , n  , k);

        int max = Math.max(leftDist , rightDist);
        if(max+1 == k ){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int data = root.data;
        int lnode = sum(root.left);
        int rnode = sum(root.right);

        int newleft = root.left==null ?0 : root.left.data;
        int newright = root.right==null ?0 : root.right.data;
        root.data = lnode+rnode + newleft + newright;
        return data;
    }

    public static void mirror(Node root){
        if(root == null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static Node leafDelete(Node root , int target){
        if(root == null){return null;}

        if(root.data == target && root.left == null && root.right == null ){
            return null;
        }
        root.left = leafDelete(root.left, target);
        root.right = leafDelete(root.right , target);
        if(root.data == target && root.left == null && root.right == null ){
            return null;
        }
        return root;
    }

    public static int MaxPathSum(Node root , int sum){
        if(root == null){
            return 0;
        }
        if(root.right == null && root.right == null){
            return sum+root.data;
        }
        sum += root.data;
        int Max = Math.max(MaxPathSum(root.left , sum) , MaxPathSum(root.right , sum));
        return Max;
    }

    public static void main(String[] arg){
        int[] nodes = {1,2,3,-1,3,-1,-1,4,-1,-1,3,-1,3,-1,-1};
        binary_trees bt = new binary_trees();
        Node root1 = bt.buildTree(nodes);
        levelOrderTravesal(root1);
        System.out.println(MaxPathSum(root1 , 0));

    }
}
