package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String result = "YES";
            stack = new Stack<Character>();
            String gualho = br.readLine();
            for(int j = 0; j < gualho.length(); j++) {
                char ch = gualho.charAt(j);
                if(ch=='(') {
                    stack.push(ch);
                }
                else{
                    if(stack.isEmpty()){
                        result = "NO";
                        break;
                    }else{
                        if(stack.peek()=='('){
                            stack.pop();
                        }else{
                            result = "NO";
                            break;
                        }
                    }
                }
            }
            if(!stack.isEmpty()) result = "NO";
            System.out.println(result);
        }
    }
}