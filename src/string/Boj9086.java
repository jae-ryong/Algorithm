package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb;
        for(int i = 0; i < T; i++){
            String line = br.readLine();
            sb = new StringBuilder();
            sb.append(line.charAt(0)).append(line.charAt(line.length()-1));
            System.out.println(sb);
        }
    }
}