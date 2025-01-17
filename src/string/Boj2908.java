package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int reverseA = reverse(A);
        int reverseB = reverse(B);

        int answer = Math.max(reverseA, reverseB);
        System.out.println(answer);
    }

    public static int reverse(int num){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(num % 10);
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}