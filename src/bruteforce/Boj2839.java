package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean check = false;
        int result = 0;
        for(int i=0;i<=N/5;i++){
            for(int j=0;j<=N/3;j++){
                if(5*i+3*j==N){
                    result = i+j;
                    check = true;
                    break;
                }
            }
        }
        if(check) System.out.println(result);
        else System.out.println(-1);
    }
}
