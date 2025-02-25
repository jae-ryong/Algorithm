package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 0;
        for(int i= 666;; i++){
            String num = String.valueOf(i);
            if(num.contains("666")){
                cnt++;
            }
            if(cnt == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
