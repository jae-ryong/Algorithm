package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* Stack으로 접근
* 1. ( 인경우 stack에 push
* 2. ) 인경우
*   - stack에 맨 마지막에 있는 값이 )이거나 비어있으면 NO return
*   - ( 인경우 pop
* */
public class Boj9012 {
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            stack = new Stack<>();
            String line = br.readLine();
            boolean flag = false;
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if(stack.isEmpty() || stack.peek() == ')') {
                        System.out.println("NO");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!flag) {
                if(!stack.isEmpty()) System.out.println("NO");
                else System.out.println("YES");
            }
        }
    }
}
