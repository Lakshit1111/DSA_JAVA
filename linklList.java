import java.util.LinkedList;


class Doublell{
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        void show(){
            System.out.println( prev + " " + data + " " + next.data);
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }

    public void removeFirst(){
        size--;
        if(head == null){
            head = tail = null;
            return ;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        head.prev = null;


    }

    public void removeLast(){
        size--;
        if(head == null){
            head = tail = null;
            return ;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;


    }
    public void reversedll(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}


/////////////////////////////////////////////
public class linklList extends Doublell {
    public static Node head;
    public static Node tail;
    public static int size;
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirstNode(int data){ // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLastNode(int data){ // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return ;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addmiddleNode(int data , int idx){ // O(n)
        Node NewNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i< idx-1){
            temp = temp.next;
            i++;
        }
        NewNode.next = temp.next;
        temp.next = NewNode;
    }

    public int removeFirstNode(){ // O(1)
        if(size == 0){
            System.out.println("Link List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }
        size--;
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLastNode(){ // O(1)
        if(size == 0){
            System.out.println("Link List is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            size = 0;
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node pre = head;
        for(int i = 0 ; i<size-2 ; i++){
            pre = pre.next;
        }
        size--;
        int val = pre.next.data;
        pre.next = null;
        return val;
    }

    public int helper(Node node , int key){
        if(node == null){
            return -1;
        }
        if(node.data == key){
            return 0;
        }
        int idx = helper(node.next , key);
        if(idx == -1){
            return -1;
        }
        return idx +1;
    }

    public int search(int key){ // O(n)
        return helper(head , key);
    }

    public void reverse(Node node){
        if(size == 0 ){
            System.out.println("Link List is Empty");
        }
        if(size == 1){
            return ;
        }
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    public void remove_N_nodefromlast(int n){
        Node temp = head;
        int length = 0;

        while(temp != null){
            length++;
            temp = temp.next;
        }
// We are removing the n node from count from last. Ex - link list of length 5. We have to remove n=3 than from first it is 5-3 = 2.
        if(n == length){
            head = head.next;
            return;
        }
        Node prev = head;
        for(int i = 1 ; i<length-n ; i++){
              prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    public Node findMid(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow  = slow.next;      //+1
            fast = fast.next.next;  //+2
        }

        return slow;
    }

    public boolean palindrom(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1 - find mid
        Node midNode = findMid();
        // step 2 - reverse second half
        Node prev = null;
        Node nextNode = midNode;
        while(midNode != null){
            nextNode = nextNode.next;
            midNode.next = prev;
            prev = midNode;
            midNode = nextNode;
        }
        // step 3 - left half and right half
        Node left = head;
        Node right = prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void printll(Node node) { // O(n)
        if (node == null) {
            System.out.println("null");
            return;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

//    Detecting the cycle in the Link List.
    public boolean isCycle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

//    Removing cycle
    public static void removeCycle(){
        //cycle exist
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle){
            // finding the meeting point.
            slow = head;
            Node prev = null;
            while(fast != slow){
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }
            // remove cycle
            prev.next = null;
        }
    }

    private static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node rigthMid = mid.next;
        Node leftMid = head;
        mid.next = null;

        Node newLeft = mergeSort(leftMid);
        Node newRight = mergeSort(rigthMid);

        return merge(newLeft , newRight);
    }

    public static Node merge(Node left , Node right){
        Node mergeNode = new Node(-1);
        Node newHead = mergeNode;

        while(left != null && right != null){
            if(left.data>right.data){
                mergeNode.next = right;
                mergeNode = mergeNode.next;
                right = right.next;
            }else{
                mergeNode.next = left;
                mergeNode = mergeNode.next;
                left = left.next;
            }
        }
        if(left != null){
            mergeNode.next = left;
        }
        if(right != null){
            mergeNode.next = right;
        }
        return newHead.next;
    }

    public static void zigzag(){
        // Find Mid Node
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse Right Part
        Node prev = null;
        Node curr = slow.next;
        Node next;
        slow.next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate merging
        Node right = prev;
        Node left = head;
        Node nextR , nextL;
        while(right != null && left != null) {
            // Merging
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            //Update
            right = nextR;
            left = nextL;

        }
    }



//    Using Link List of Java Collection Framework.
    public static void lljcf(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);

    }

    public static void main(String[] arg){
//        linklList a = new linklList();
//        a.addFirstNode(1);
//        a.addLastNode(2);
//        a.addLastNode(3);
//        a.addLastNode(4);
//        printll(head);
//        zigzag();
//        printll(head);


        Doublell dll = new Doublell();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        print();
        dll.reversedll();
        print();


    }
}
