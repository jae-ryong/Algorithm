package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = Math.abs(S-num);
        }
        int gcd = arr[0];
        for(int i = 1; i< N;i++){
            gcd = getGCD(gcd,arr[i]);
        }
        System.out.println(gcd);
    }
    private static int getGCD(int A, int B){
        if(B==0) return A;
        return getGCD(B,A%B);
    }
}