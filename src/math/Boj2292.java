package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum=1;
        int hap = 0;
        if(N==1){
            System.out.println(1);
            return;
        }
        int cnt = 0;
        while(N>sum){
            hap += 6;
            sum += hap;
            cnt++;
        }

        System.out.println(cnt+1);
    }
}