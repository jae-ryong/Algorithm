package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double answer = 0;
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        String operation = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < operation.length(); i++) {
            char ch = operation.charAt(i);
            if(ch>='A' && ch<='Z'){
                stack.push(arr[ch-'A']);
            }else{
                double c1 = stack.pop();
                double c2 = stack.pop();
                switch(ch){
                    case '+':
                        stack.push(c2+c1);
                        break;
                    case '-':
                        stack.push(c2-c1);
                        break;
                    case '*':
                        stack.push(c2*c1);
                        break;
                    case '/':
                        stack.push(c2/c1);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));

    }
}