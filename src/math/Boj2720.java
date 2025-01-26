package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] coin = new int[]{25,10,5,1};
        while (T-- > 0) {
            int[] arr = new int[4];
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < 4; i++) {
                arr[i] = N / coin[i];
                N -= arr[i] * coin[i];
            }
            for(int i = 0; i < 4; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}