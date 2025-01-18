package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dial = new String[12];
        dial[3] = "ABC";
        dial[4] = "DEF";
        dial[5] = "GHI";
        dial[6] = "JKL";
        dial[7] = "MNO";
        dial[8] = "PQRS";
        dial[9] = "TUV";
        dial[10] = "WXYZ";

        String word = br.readLine();
        int sum = 0;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean check = false;
            for(int j=3; j<dial.length; j++) {
                if(check) break;
                for(char ch : dial[j].toCharArray()) {
                    if(c == ch) {
                        sum += j;
                        check = true;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}