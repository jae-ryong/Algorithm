package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = N / 4;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i< num; i++){
            answer.append("long ");
        }
        System.out.println(answer.append("int"));
    }
}
