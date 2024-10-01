package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2294 {
    static int N;
    static int K;
    static int[] d;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new int[K+1];
        num = new int[N];

        for(int i = 0; i < N; i++) num[i] = Integer.parseInt(br.readLine());
        for(int i=1; i<=K; i++) d[i] = Integer.MAX_VALUE-1;

        for(int i=0;i<N;i++){
            int idx = num[i];
            for(int j=idx;j<=K;j++){
                d[j] = Math.min(d[j],d[j-idx]+1);
            }
        }

        if(d[K]==Integer.MAX_VALUE-1) System.out.println(-1);
        else System.out.println(d[K]);
    }
}
