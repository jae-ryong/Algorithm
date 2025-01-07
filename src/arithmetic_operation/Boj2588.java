package arithmetic_operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int gob = A * B;
        System.out.println(A * (B%10));
        B /= 10;
        System.out.println(A * (B%10));
        B /= 10;
        System.out.println(A * (B%10));
        System.out.println(gob);
    }
}
