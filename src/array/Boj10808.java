package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int[] alpha = new int[26];

        for(int i=0; i<a.length(); i++){
            alpha[a.charAt(i)-'a'] += 1;
        }
        for(int i=0; i<alpha.length; i++){
            System.out.print(alpha[i] + " ");
        }
    }
}