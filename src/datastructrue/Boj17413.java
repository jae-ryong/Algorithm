package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c==' '){
                while(!stack.isEmpty())sb.append(stack.pop());
                sb.append(c);
            }else if(c=='<'){
                while(!stack.isEmpty()) sb.append(stack.pop());
                while(sentence.charAt(i)!='>') sb.append(sentence.charAt(i++));
                sb.append('>');
            } else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}