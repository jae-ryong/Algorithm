package etc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        boolean flag = false;
        for(int i=0; i<=word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-i-1)){
                flag = true;
                break;
            }
        }

        if(flag) System.out.println(0);
        else System.out.println(1);
    }
}