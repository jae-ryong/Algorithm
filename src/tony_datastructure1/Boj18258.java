package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18258 {

    static StringBuilder sb = new StringBuilder();
    static int[] q = new int[2000000];
    static int front = 0;
    static int back = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(N --> 0) {
           st = new StringTokenizer(br.readLine());
           String type = st.nextToken();
           switch (type) {
               case "push":
                   push(Integer.parseInt(st.nextToken()));
                   break;
               case "pop":
                   pop();
                   break;
               case "size":
                   size();
                   break;
               case "empty":
                   empty();
                   break;
               case "front":
                    front();
                   break;
               case "back":
                   back();
                   break;
           }
        }
        System.out.println(sb.toString());

    }
    public static void push(int x) {
        size++;
        q[back] = x;
        back++;
    }

    public static void pop() {
        if(size == 0) {
            sb.append(-1).append('\n');
            return;
        }
        sb.append(q[front]).append('\n');
        size--;
        front++;
    }

    public static void size(){
        sb.append(size).append('\n');
    }

    public static void empty(){
        if (size == 0) {
            sb.append(1).append('\n');
        } else {
            sb.append(0).append('\n');
        }
    }

    public static void front(){
        if (size == 0) {
            sb.append(-1).append('\n');
        } else {
            sb.append(q[front]).append('\n');
        }
    }

    public static void back(){
        if (size == 0) {
            sb.append(-1).append('\n');
        } else {
            sb.append(q[back-1]).append('\n');
        }
    }

}
