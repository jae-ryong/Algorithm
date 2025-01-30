package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int result = changeJinbub(N,B);

        System.out.println(result);
    }

    public static int changeJinbub(String N, int B) {
        int sum = 1;
        int result=0;
        for (int i = N.length()-1; i >= 0; i--) {
            if(N.charAt(i) >= '0' && N.charAt(i)<= '9'){
                result += sum * (N.charAt(i) - '0');
            }else {
                result += sum * (N.charAt(i) -'A' +10);
            }
            sum *= B;
        }
        return result;
    }
}