package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2581 {
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for(int i=N;i<=M;i++){
            if(isPrime(i)){
                min = Math.min(min,i);
                sum += i;
            }
        }
        if(sum==0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
