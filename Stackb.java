import java.util.ArrayList;
import java.util.Stack;

public class Stackb{

//    Stack Using ArrayList
    static class StackAl{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // Push
        public static void push(int data){
            list.add(data);
        }
        // Pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() -1 );
            list.remove(list.size()-1);
            return top;
        }
        // Peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() -1 );
        }

    }

// Stack using LinkList
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static Nodec headn = null;
    static class Nodec{
        Character data;
        Nodec next;
        Nodec(Character data){
            this.data = data;
            next = null;
        }
        void add(Character n){
            if(headn == null){
                headn = new Nodec(n);
            }else{
                Nodec node= new Nodec(n);
                node.next = headn;
                headn = node;
            }
        }
    }
    static Node head = null;
    static class StackLl{

        public static boolean isEmpty(){
            return head == null;
        }

        // Push
        public static void push(int data){
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
        // Pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        // Peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }

    }

    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s,data);
        s.push(top);

    }

    public static void stockSpan(int stock[] ,int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i = 1 ; i<stock.length ; i++){
            int curr = stock[i];
            while(!s.empty() && curr > stock[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                span[i] = i+1;
            }else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    public static void nextGreater(int arr[] , int nextgreat[]){
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1 ; i>-1 ; i--) {
            while (!s.empty() && arr[i] > s.peek()) {
                s.pop();
            }
            if (s.empty()) {
                nextgreat[i] = -1;
            } else {
                nextgreat[i] = s.peek();
            }
            s.push(arr[i]);
        }
    }

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        int n = str.length();
        for(int i = 0 ; i<n ; i++){

            // For closing ')'.

            if(str.charAt(i) == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count == 0){
                    return true;
                }

            }else{
                s.push(str.charAt(i));
            }

        }
        return false;
    }

    public static void AreaHistogram(int[] arr){
        int[] nlarr = new int[arr.length];
        int[] nrarr = new int[arr.length];

        // Next smaller Right:-
        Stack<Integer> s = new Stack();
        for(int i = arr.length-1 ; i>=0 ; i--){

            while(!s.empty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            if(s.empty()){
                nrarr[i] = arr.length;
            }else{
                nrarr[i] = s.peek();
            }
            s.push(i);
        }

        // Next Smaller Left :-
        s = new Stack();
        for(int i = 0 ; i < arr.length; i++){

            while(!s.empty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            if(s.empty()){
                nlarr[i] = -1;
            }else{
                nlarr[i] = s.peek();
            }
            s.push(i);
        }
        printarr(nlarr);
        printarr(nrarr);

        // Area:-
        int maxArea = 0;
        for(int i = 0 ; i< arr.length ; i++){

            int height = arr[i];
            int width = nrarr[i] - nlarr[i] -1;
            int area = height*width;
            maxArea = Math.max(maxArea , area);
            System.out.print(area + " ");

        }
        System.out.println();
        System.out.println("Maximum area Rectangle is :- " + maxArea);

    }

    public static boolean palidrom(Nodec head){
        Stack<Character> s = new Stack<>();
        Nodec node = head;

        while(node != null){
            s.push(node.data);
            node = node.next;
        }

        while(!s.empty()){
            if(s.pop() != head.data){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static int trappingRainWater(int arr[] ){
        Stack<Integer> s = new Stack<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        // Highest Max left
        for(int i = 0 ; i<arr.length ; i++){
            while(!s.empty() && s.peek() < arr[i]){
                s.pop();
            }
            if(s.empty()){
                left[i] = arr[i];
                s.push(arr[i]);
            }else{
                left[i] = s.peek();
            }
        }

        // Highest Max Right
        s = new Stack<>();
        for(int i = arr.length-1 ; i>=0 ; i--){
            while(!s.empty() && s.peek() < arr[i]){
                s.pop();
            }
            if(s.empty()){
                right[i] = arr[i];
                s.push(arr[i]);
            }else{
                right[i] = s.peek();
            }

        }
        printarr(left);
        printarr(right);

        // Max Trap Water
        int maxTrapWater = 0;
        for(int i = 0 ; i<arr.length ; i++){
            int min = Math.min(left[i] , right[i]);
            maxTrapWater += min - arr[i];
        }
        return maxTrapWater;
    }

    public static void DecodeString(String str){
        StringBuilder stb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Stack<Character> s = new Stack<>();
        
        for(int i = str.length()-1 ; i>=0 ; i--){
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z'){
                s.push(str.charAt(i));
            } else if (str.charAt(i) == '[') {
                while(!s.empty()){
                    temp.append(s.pop());
                }
                stb.insert(0 , temp);
                i--;
                temp = new StringBuilder(stb);
                int n = str.charAt(i) -  48;
                while(n>1){
                    stb.append(temp);
                    --n;
                }
                temp = new StringBuilder();
                
            }
        }
        System.out.println(stb);
        
    }

    public static void printarr(int[] arr){
        for(int i = 0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] a){
        String str = "2[2[q]3[a]]";
        DecodeString(str);


    }
}

