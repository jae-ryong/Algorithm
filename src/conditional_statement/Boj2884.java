package conditional_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minute = M - 45;
        if(minute < 0 ){
            M = 60 + minute;
            if(H-1 < 0) H = 23;
            else H -= 1;
            System.out.println(H + " " + M);
        }else{
            System.out.println(H + " " + minute);
        }
    }
}
