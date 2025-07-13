package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] d = new long[100001][4];

        d[1][1] = 1;
        d[2][2] = 1;
        d[3][1] = 1;
        d[3][2] = 1;
        d[3][3] = 1;

        for(int i=4;i<100001;i++){
            d[i][1] = (d[i-1][2] + d[i-1][3]) % 1000000009;
            d[i][2] = (d[i-2][1] + d[i-2][3]) % 1000000009;
            d[i][3] = (d[i-3][1] + d[i-3][2]) % 1000000009;
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println((d[N][1] + d[N][2] + d[N][3]) % 1000000009);
        }
    }
}