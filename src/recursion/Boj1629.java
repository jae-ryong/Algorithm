package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(gob(A,B,C));

    }

    private static long gob(int a, int b, int c) {
        if(b==1) return a%c;
        long val = gob(a, b/2, c);
        val = val * val % c;
        if(b%2==0) return val;
        return a * val % c;
    }
}
