package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 1; i <= N; i++) {
            int num = arr[idx];
            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                sb.append('-').append('\n');
                idx++;
                i--;
            }else{
                stack.push(i);
                sb.append('+').append('\n');
            }
        }

        int len = stack.size();
        for(int i = 0; i < len; i++) {
            int num = arr[idx++];
            if(stack.peek() != num){
                sb.setLength(0);
                sb.append("NO");
                System.out.println(sb);
                return;
            }else{
                stack.pop();
                sb.append('-').append('\n');
            }
        }
        System.out.println(sb);
    }
}