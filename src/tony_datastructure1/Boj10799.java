package tony_datastructure1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* ( 인경우 stack push
*
* )인 경우
*  - 전이 ( 일때 stack.pop()하고 스택에 쌓아져 있는걸 count
*  - 전이 ) 일때 statck.pop()하고 count + 1
* */
public class Boj10799 {
    static Stack<Character> stack = new Stack<Character>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '(') {
                stack.push('(');
            } else if(line.charAt(i) == ')') {
                if(line.charAt(i-1) == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
