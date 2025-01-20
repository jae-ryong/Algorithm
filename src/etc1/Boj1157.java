package etc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String word = br.readLine();
        word = word.toUpperCase();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'A']++;
        }

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==max) cnt++;
        }
        if(cnt>1){
            System.out.println("?");
        }else{
            for(int i = 0; i < arr.length; i++){
                if(arr[i]==max) {
                    System.out.println((char) (i+'A'));
                }
            }
        }

    }
}