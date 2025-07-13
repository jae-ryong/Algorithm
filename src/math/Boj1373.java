package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int cnt = 0;
        int sum = 1;
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(int i= num.length()-1; i>=0; i--){
            if(cnt==2){
                result += sum * (num.charAt(i) - '0');
                sb.append(result);
                cnt=0;
                sum = 1;
                result = 0;
            }else{
                result += sum * (num.charAt(i) - '0');
                cnt++;
                sum *= 2;
            }
        }
        if(cnt!=0) sb.append(result);
        System.out.println(sb.reverse());
    }
}