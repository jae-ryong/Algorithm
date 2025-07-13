package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17103 {
    static boolean[] check = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        make_prime();
        for(int i = 0; i < T; i++) {
            int cnt = 0;
            int num = Integer.parseInt(br.readLine());
            for(int j=2; j<=num/2;j++){
                if(!check[j] && !check[num-j]){
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void make_prime() {
        check[0] = true;
        check[1] = true;

        for(int i=2; i*i<=1000001;i++){
            if(check[i]==true) {
                continue;
            }
            for(int j=i*i; j<1000001; j+=i) {
                check[j] = true;
            }
        }
    }
}