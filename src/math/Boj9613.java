package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            for (int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++){
                    int A = arr[i];
                    int B = arr[j];
                    result += getGCD(A,B);
                }
            }
            System.out.println(result);
        }
    }

    public static long getGCD(int a, int b){
        if(b == 0) return a;
        return getGCD(b, a % b);
    }
}