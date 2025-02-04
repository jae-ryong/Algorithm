package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(N==1) {
            System.out.println(4);
            return;
        }
        long retangleCnt = 0;
        long silsunCnt = 0;
        for(long i=1; i<=N; i++){
            retangleCnt += i;
            silsunCnt += i-1;
        }
        System.out.println(4*retangleCnt - silsunCnt * 4);
    }
}