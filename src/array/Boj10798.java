package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            if(a.length() > max){
                max = a.length();
            }
            for(int j=0; j<a.length(); j++){
                arr[i][j] = a.charAt(j);
            }
        }
        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] == '\0') continue;
                System.out.print(arr[j][i]);
            }
        }
    }
}