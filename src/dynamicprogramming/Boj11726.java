package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 2;
        for(int i =3; i<1001; i++){
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(d[N]);
    }
}