package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int C1 = (A1*B2)+(A2*B1);
        int C2 = A2*B2;

        int gcd = gcd(C2,C1);

        System.out.print(C1/gcd + " " + C2/gcd);

    }

    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}