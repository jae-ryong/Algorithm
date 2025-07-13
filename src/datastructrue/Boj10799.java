package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gualho = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < gualho.length(); i++){
            if(gualho.charAt(i) == '('){
                stack.push(gualho.charAt(i));
            }else{
                stack.pop();
                if(gualho.charAt(i-1) == '('){
                    cnt += stack.size();
                }else{
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}