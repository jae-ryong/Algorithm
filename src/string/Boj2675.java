package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<word.length();j++){
                for(int k=0; k<M; k++){
                    sb.append(word.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}