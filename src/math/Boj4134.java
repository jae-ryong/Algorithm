package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long N = Long.parseLong(br.readLine());
        for(int i=0;i<N;i++){
            long num = Long.parseLong(br.readLine());
            if(num==0 || num==1){
                sb.append(2).append("\n");
                continue;
            }
            while (true){
                long cnt=0;
                for(long j=2;j*j<=num;j++){
                    if(num%j==0){
                        cnt++;
                        break;
                    }
                }
                if(cnt==0){
                    sb.append(num).append("\n");
                    break;
                }
                num++;
            }
        }
        System.out.println(sb);
    }
}