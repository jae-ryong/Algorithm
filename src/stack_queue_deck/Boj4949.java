package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Boj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;

        while(true){
            String line = br.readLine();
            String answer = "yes";
            stack = new Stack<>();
            if(line.equals(".")) break;
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                if(ch!='(' &&  ch!='[' && ch !=')' && ch!=']') continue;
                if(stack.isEmpty()){
                    if(ch == ')' || ch == ']') {
                        answer = "no";
                        break;
                    }else{
                        stack.push(ch);
                    }
                }else{
                    if(ch == ')' || ch == ']'){
                        if(stack.peek()=='(' && ch ==')') stack.pop();
                        else if(stack.peek()=='(' && ch ==']') {
                            answer = "no";
                            break;
                        }
                        else if(stack.peek()=='[' && ch ==']') stack.pop();
                        else if(stack.peek()=='[' && ch ==')') {
                            answer = "no";
                            break;
                        }
                    }else{
                        stack.push(ch);
                    }
                }
            }
            if(!stack.isEmpty()) answer="no";
            System.out.println(answer);
        }
    }
}