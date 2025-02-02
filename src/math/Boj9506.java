package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N== -1) break;
            int sum = 0;
            int check = 0;
            for(int i = 1; i < N; i++){
                if(N%i == 0) {
                    sum+=i;
                    check = i;
                }
            }
            if(sum==N){
                System.out.print(N + " = ");
                for(int i = 1; i < N; i++){
                    if(N%i == 0) {
                        if(check == i ) System.out.print(i);
                        else System.out.print(i +" + ");
                    }
                }
                System.out.println();
            }else{
                System.out.println(N + " is NOT perfect.");
            }
        }
    }
}