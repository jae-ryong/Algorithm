package stackofuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String sege = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            if (sege.length() == 1 && sege.charAt(0) == '.') {
                break;
            }
            boolean check = true;
            for (int i = 0; i < sege.length(); i++) {
                char ch = sege.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == ']') {
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }
                    char top = stack.peek();
                    if ((top == '(' && ch == ')') || (top == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if (check && stack.isEmpty()) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }
        System.out.println(sb);
    }
}
