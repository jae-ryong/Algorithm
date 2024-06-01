package linkedlist;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String bimilbunho = br.readLine();
            char[] c = bimilbunho.toCharArray();
            for(char ch : c) {
                switch (ch){
                    case('<'):
                        if(!left.empty()) right.push(left.pop());
                        break;
                    case('>'):
                        if(!right.empty()) left.push(right.pop());
                        break;
                    case('-'):
                        if(!left.empty()) left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }
            while (!left.empty()) right.push(left.pop());

            while (!right.empty()) bw.write(right.pop());
            bw.write('\n');
        }
        bw.flush();
        bw.close();

    }
}