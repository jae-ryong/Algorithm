package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        int[] result = new int[N-1];

        int gob=1;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N-1;i++){
            result[i] = arr[i+1] - arr[i];
        }

        int gcd = 0;
        for(int i=0;i<N-1;i++){
            gcd = gcd(result[i],gcd);
        }
        System.out.println((arr[N-1]-arr[0])/gcd - arr.length + 1);
    }

    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}