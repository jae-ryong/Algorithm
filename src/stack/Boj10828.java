package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            switch (type){
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    stack.push(a);
                    break;
                case "pop":
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}