package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1789 {
    static Long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long start = 1;
        long hap = 0;
        while(true){
            hap += start;
            if(hap > N){
                break;
            }
            start +=1;
        }
        System.out.println(start-1);
    }
}
