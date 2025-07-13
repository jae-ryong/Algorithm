package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int cnt = 0;
            for(int i=N+1; i<=2*N; i++){
                if(isPrime(i)) {
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
    public static boolean isPrime(int num){
        if(num==0 || num==1) return false;
        if(num==2) return true;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}