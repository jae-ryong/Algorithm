package timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj24267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        for(long i=N-1; i>1;i--){
            sum += ((i*(i-1))/2);
        }
        System.out.println(sum);
        System.out.println(3);
    }
}