package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj6588 {
    static boolean[] check = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makePrime();
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            StringBuilder sb = new StringBuilder();
            boolean ch = false;
            for(int i=2;i<N;i++){
                if(check[i] == false && check[N-i] == false){
                    sb.append(N + " = ").append(i + " + ").append(N-i);
                    ch = true;
                    break;
                }
            }
            if(!ch) sb.append("Goldbach's conjecture is wrong.");
            System.out.println(sb);
        }
    }
    private static void makePrime() {
        check[0] = true;
        check[1] = true;

        for(int i=2;i*i<=1000001;i++){
            if(check[i] == true) continue;

            for(int j=i*i;j<1000001;j+=i){
                check[j] = true;
            }
        }
    }
}