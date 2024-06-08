package stackofuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String word = br.readLine();
            stack.push(word.charAt(0));
            for(int i = 1; i < word.length(); i++) {
                if(stack.isEmpty()){
                    stack.push(word.charAt(i));
                }else{
                    char check = stack.peek();
                    char ch = word.charAt(i);
                    if(ch != check){
                        stack.push(ch);
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
