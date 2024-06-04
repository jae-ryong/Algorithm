package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(N-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push_front":
                    int num1 = Integer.parseInt(st.nextToken());
                    deque.addFirst(num1);
                    break;
                case "push_back":
                    int num2 = Integer.parseInt(st.nextToken());
                    deque.addLast(num2);
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.peekFirst()).append('\n');
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(deque.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}