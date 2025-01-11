package conditional_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int plus =Integer.parseInt(br.readLine());

        int hap = M + plus;
        if( hap < 60){
            System.out.println(H + " " + hap);
        }else{
            int hour = hap / 60;
            int min = hap % 60;
            if(hour+H >=24){
                System.out.println(H+hour-24 + " " + min);
            }else{
                System.out.println(H+hour + " " + min);
            }
        }

    }
}
