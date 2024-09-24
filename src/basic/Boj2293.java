package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2293 {
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
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        d[0] = 1;
        for(int i = 0; i < N; i++){
            for(int j=num[i]; j<=K; j++){
                d[j] += d[j-num[i]];
            }
        }

        System.out.println(d[K]);
    }
}
