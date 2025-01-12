package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=N-1; i>=0; i--){
            for(int j=0; j < i; j++){
                System.out.print(" ");
            }
            for(int k=N-1; k >= i; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
