package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < a.length(); i++) {
            left.push(a.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            switch (c){
                case 'P':
                    char b = st.nextToken().charAt(0);
                    left.push(b);
                    break;
                case 'L':
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case 'B':
                    if(!left.isEmpty()) left.pop();
                    break;
                case 'D':
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}