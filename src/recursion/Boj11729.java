package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double v = Math.pow(2, N) - 1;
        sb.append((int)v).append('\n');
        hanoi(N,1,3);
        System.out.println(sb);
    }

    public static void hanoi(int pan,int a, int b) {
        if(pan==1){
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        hanoi(pan-1,a,6-a-b);
        sb.append(a).append(" ").append(b).append('\n');
        hanoi(pan-1,6-a-b, b);
    }
}