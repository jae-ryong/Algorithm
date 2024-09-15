package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3460 {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while(N!=0){
                sb.append(N%2);
                N /= 2;
            }
            for(int i = 0 ; i < sb.length() ; i++){
                if(sb.charAt(i) == '1'){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
