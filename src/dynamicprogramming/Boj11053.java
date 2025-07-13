package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] d = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            d[i] = 1;
            for(int j=0; j<i; j++) {
                if(seq[j] < seq[i] && d[i] < d[j] +1){
                    d[i] = d[j] +1;
                }
            }
        }
        int result = 0;
        for(int i : d){
            result = Math.max(result,i);
        }
        System.out.println(result);
    }
}