package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[1000000];
        for(int i=2; i<=N; i++){
            d[i] = d[i-1] + 1;
            if(i%2==0) d[i] = Math.min(d[i/2]+1,d[i]);
            if(i%3==0) d[i] = Math.min(d[i/3]+1,d[i]);
        }
        System.out.println(d[N]);
    }
}