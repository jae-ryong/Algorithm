package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] ch = new int[26];
        Arrays.fill(ch,-1);
        for (int i = 0; i < word.length(); i++) {
            if(ch[word.charAt(i)-'a']==-1){
                ch[word.charAt(i) - 'a'] = i;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
    }
}