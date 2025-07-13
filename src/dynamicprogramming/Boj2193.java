package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2193 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] d = new long[N+2];
        d[1] = 1;
        d[2] = 1;
        for(int i=3; i<=N; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[5]);
    }
}