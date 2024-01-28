import java.util.*;

public class Queueb {
    static class Queues{
        static int arr[];
        static int rear;
        static int size;

        Queues(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        static boolean isEmpty(){
            return rear == -1;
        }

        // add
        public static void add(int data){ // O(1)
            if(rear == size-1){
                System.out.println("Queues is Full");
                return;
            }
            rear = rear +1;
            arr[rear] = data;

        }

        // remove
        public static int remove(){ // O(n)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];
            for(int i = 0 ; i<rear ; i++){
                arr[i] = arr[i+1];
            }
            rear=  rear-1;
            return front;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }

    }

    // Circular Queues
    static class circularQueues{
        static int arr[];
        static int front;
        static int rear;
        static int size;

        circularQueues(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        // add
        public static void add(int data){ // O(1)
            if(isFull()){
                System.out.println("Queues is Full");
                return;
            }
            // for 1st element
            if(front == -1){
                front = 0;
            }

            rear = (rear+1) % size;
            arr[rear] = data;

        }

        // remove
        public static int remove(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[0];
            //last element delete
            if(rear == front){
                rear = front = -1;
            }else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }
    //Node
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    // Que using LinkList
    static class Queuell{
        static Node head = null;
        static Node tail = null;

        static boolean isEmpty(){
            return head == null && tail == null ;
        }

        // add
        public static void add(int data){ // O(1)
            Node node = new Node(data);
            if(head == null){
                head =tail= node;
                return;
            }
            tail.next = node;
            tail = node;
        }

        // remove
        public static int remove(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = head.data;
            if(tail == head){
                head  = tail = null;
                return result;
            }
            head = head.next;
            return result;
        }

        // peek
        public static int peek(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }

    }

    public static void interleave(Queue<Integer> q){
        Queue<Integer> q1= new LinkedList<>();
        int n = q.size()/2;
        while(q.size() != n){
            q1.add(q.remove());
        }
        System.out.println(q);
        System.out.println(q1);
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
    }
    public static void revarsal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.add(q.remove());
        }
        while(!s.empty()){
            q.add(s.pop());
        }
    }

    public static void binary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");
            String s2 = s1;
            q.add(s1+ "0");
            q.add(s2 + "1");
        }
    }

    public static int ropeMinCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int i : arr){
            pq.add(i);
        }
        System.out.println(pq);
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            System.out.println(first + " " + second);
            res += first+second;
            pq.add(first+second);
      }

        System.out.println(res);
        return res;
    }

    public static void reverseK(Queue<Integer> q , int k){
        int n = q.size()-k;
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i<k ; i++){
            s.push(q.remove());
        }
        for(int i = 0 ; i<k ; i++){
            q.add(s.pop());
        }
        for(int i = 0 ; i<n ; i++){
            q.add(q.remove());
        }
    }

    static class Job{
        char job_id;
        int deadline;
        int profit;
        Job(char job_id , int deadline ,int profit){
            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    public static void jobSceduling(ArrayList<Job> job){
//        System.out.println(a.job_id +" "+ b.job_id + " " + (a.deadline - b.deadline));
        int n = job.size();
        Collections.sort(job,(a,b) -> {
            return a.deadline - b.deadline;} );



    }

    public static void num(String str){
        
    }

    public static void main(String[] arg){
        ArrayList<Job> job = new ArrayList<>();
        job.add(new Job('a', 2, 100));
        job.add(new Job('b', 1, 19));
        job.add(new Job('c', 2, 27));
        job.add(new Job('d', 1, 25));
        job.add(new Job('e', 3, 15));

        for(Job i : job){
            System.out.print(i.job_id + " ");
        }
        System.out.println();

        jobSceduling(job);
        Stack s = new Stack();
    }
}





























