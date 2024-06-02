package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n ==0){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(n);
            }
        }
        int sum = 0;
        for(int i=0;i<stack.size();i++){
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}