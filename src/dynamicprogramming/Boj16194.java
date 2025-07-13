package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16194 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] card = new int[N+1];
        int[] d = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.MAX_VALUE;
        }
        d[0] = 0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                d[i] = Math.min(d[i],d[i-j]+card[j]);
            }
        }
        System.out.println(d[N]);
    }
}