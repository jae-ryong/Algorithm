package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        int total = 1;
        for(int i=0; i<3; i++){
            total *= Integer.parseInt(br.readLine());
        }
        String answer = String.valueOf(total);
        for(int i=0; i<answer.length(); i++){
            num[answer.charAt(i)-'0'] += 1;
        }

        for(int i=0; i<num.length; i++){
            System.out.println(num[i]);
        }
    }
}