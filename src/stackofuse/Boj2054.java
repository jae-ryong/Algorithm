package stackofuse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj2054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gualho = br.readLine();
        boolean check = proper(gualho);
        if (!check) {
            System.out.println(0);
        } else {
            int answer = gesan(gualho);
            System.out.println(answer);
        }
    }

    private static int gesan(String gualho) {
        int answer = 0;
        int gob = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < gualho.length(); i++) {
            char ch = gualho.charAt(i);
            if (ch == '(' || ch == '[') {
                if(ch=='(') gob *= 2;
                else gob *= 3;
                stack.push(ch);
            }
            else{
                if(ch==')'){
                    if(gualho.charAt(i-1)=='('){
                        answer += gob;
                    }
                    gob /= 2;
                    stack.pop();
                }else{
                    if(gualho.charAt(i-1)=='['){
                        answer += gob;
                    }
                    gob /= 3;
                    stack.pop();
                }
            }
        }
        return answer;
    }

    private static boolean proper(String gualho) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < gualho.length(); i++) {
            char ch = gualho.charAt(i);
            if (ch == '(' || ch == '[') stack.push(ch);
            else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (ch == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (ch == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if(stack.size()>0) return false;
        return true;
    }
}
