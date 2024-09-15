package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2504 {
    static String N;
    static Stack<Character> stack= new Stack<Character>();
    static int result = 1;
    static int value = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        for(int i=0;i<N.length();i++){
            if(N.charAt(i)=='('){
                stack.push('(');
                result *= 2;
            }else if(N.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    result = 0;
                    break;
                }else if(N.charAt(i-1)=='('){
                    value += result;
                }
                stack.pop();
                result /= 2;
            }else if(N.charAt(i)=='['){
                stack.push('[');
                result *= 3;
            }else if(N.charAt(i)==']'){
                if(stack.isEmpty() || stack.peek()!='['){
                    result = 0;
                    break;
                }else if(N.charAt(i-1)=='['){
                    value += result;
                }
                stack.pop();
                result /= 3;
            }
        }
        if(result==0 || !stack.isEmpty()) System.out.println(0);
        else System.out.println(value);
    }
}
