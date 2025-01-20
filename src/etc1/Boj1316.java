package etc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++){
            String word = br.readLine();
            boolean check = false;
            int[] arr = new int[26];
            for(int j=0; j < word.length();j++){
                if(arr[word.charAt(j)-'a'] > 0){
                    if(word.charAt(j-1) != word.charAt(j)){
                        check = true;
                    }
                }else{
                    arr[word.charAt(j)-'a']++;
                }
            }
            if(!check) cnt++;
        }

        System.out.println(cnt);
    }
}