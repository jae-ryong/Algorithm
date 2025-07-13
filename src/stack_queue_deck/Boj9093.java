package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for(int i=0; i<len; i++){
                StringBuilder sb1 = new StringBuilder(st.nextToken());
                sb.append(sb1.reverse() + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}