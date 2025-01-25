package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int total = X;
        int cnt = 0;
        int idx = 1;
        int sum = 0;
        while(true){
            if(X <= 0) break;
            sum += idx;
            X -= idx++;
            cnt++;
        }

        int ch = 0;
        for(int i=sum; i>=total; i--){
            ch++;
        }
        if((cnt+1)%2==0){
            System.out.println(ch+"/"+(cnt+1-ch));
        }else{
            System.out.println((cnt+1-ch)+"/"+ch);
        }

    }
}