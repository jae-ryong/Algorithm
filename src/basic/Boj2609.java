package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int min = gcd(N,M);
        int max = (N * M) /min;
        System.out.println(min);
        System.out.println(max);
    }
    private static int gcd(int a, int b) {
        while(b!=0){
            int m = a % b;
            a = b;
            b = m;
        }
        return a;
    }
}
