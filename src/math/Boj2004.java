package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N  = Long.parseLong(st.nextToken());
        long M  = Long.parseLong(st.nextToken());

        long cnt5 = five(N) - five(N-M) - five(M);
        long cnt2 = two(N) - two(N-M) - two(M);
        long min = Math.min(cnt2,cnt5);
        System.out.println(min);
    }

    private static long two(long n) {
        long cnt = 0;
        while(n>=2){
            cnt += n/2;
            n /= 2;
        }
        return cnt;
    }

    private static long five(long n) {
        long cnt = 0;
        while(n>=5){
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }
}