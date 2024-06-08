package stackofuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            boolean check = true;
            if(s.charAt(0) == ')'){
                check = false;
            }
            stack.push(s.charAt(0));

            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if(stack.isEmpty()) {
                    if(c == ')') {
                        check = false;
                        break;
                    }
                    stack.push(c);
                }
                else {
                    char ch = stack.peek();
                    if(ch!=c) stack.pop();
                    else stack.push(c);
                }
            }
            if(stack.isEmpty() && check) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
