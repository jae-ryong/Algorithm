package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if(A==0 && B==0) break;
                if(A>B){
                    if(A%B==0) System.out.println("multiple");
                    else System.out.println("neither");
                }else{
                    if(B%A==0) System.out.println("factor");
                    else System.out.println("neither");
                }
            }
    }
}