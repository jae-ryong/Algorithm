package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) return;
        while(N!=1){
            for(int i=2; i<=N; i++){
                if(N%i==0){
                    System.out.println(i);
                    N /= i;
                    break;
                }
            }
        }

    }
}