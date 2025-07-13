package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){

                result -= stack.pop();
            }else{
                result += num;
                stack.push(num);
            }
        }
        System.out.println(result);
    }
}