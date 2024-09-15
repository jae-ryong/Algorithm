package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2460 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int current = 0;
        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int narin = Integer.parseInt(st.nextToken());
            int tan = Integer.parseInt(st.nextToken());
            current -= narin;
            current += tan;
            max = Math.max(max,current);
        }
        System.out.println(max);
    }
}
