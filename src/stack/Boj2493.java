package stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {

    static class Top{
        int x, idx;
        Top(int x, int idx){
            this.x = x;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(st.nextToken());
            while(true){
                if(stack.isEmpty()){
                    stack.push(new Top(num,i));
                    sb.append(0).append(' ');
                    break;
                }else{
                    if(stack.peek().x < num){
                        stack.pop();
                    }else{
                        sb.append(stack.peek().idx).append(' ');
                        stack.push(new Top(num,i));
                        break;
                    }
                }
            }
        }
        System.out.println(sb);

    }
}