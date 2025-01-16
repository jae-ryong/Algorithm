package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            if(arr[word.charAt(i) - 'a'] != -1) continue;
            arr[word.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}