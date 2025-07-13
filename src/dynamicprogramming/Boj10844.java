package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] d= new long[N+1][10];

        for(int i=1;i<=9;i++){
            d[1][i]=1;
        }

        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                if(j==0){
                    d[i][0] = d[i-1][1] % 1000000000;
                }else if(j==9){
                    d[i][9] = d[i-1][8] % 1000000000;
                }else{
                    d[i][j] = (d[i-1][j-1] + d[i-1][j+1]) % 1000000000;
                }
            }
        }
        long result = 0;
        for(int i=0;i<=9;i++){
            result += d[N][i];
        }
        System.out.println(result % 1000000000);
    }
}