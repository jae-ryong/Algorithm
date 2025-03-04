package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int idx = 1;
        for(int i=0; i< list.size(); i++) {
            if(list.get(i) != idx) {
                int len = stack.size();
                for(int j=0;j<len;j++){
                    if(stack.peek()==idx) {
                        stack.pop();
                        idx++;
                    }
                }
                stack.push(list.get(i));
            }else{
                idx++;
            }
        }
        String result = "Nice";
        int len = stack.size();
        for(int i=0; i<len;i++){
            int num = stack.pop();
            if(num != idx++){
                result = "Sad";
                break;
            }
        }
        System.out.println(result);
    }
}