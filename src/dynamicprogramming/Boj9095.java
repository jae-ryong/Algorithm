package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {
    static int[] d = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i=4;i<11;i++){
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(d[N]);
        }
    }
}