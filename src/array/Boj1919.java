package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char c : str1){
            arr1[c - 'a']++;
        }

        for(char c : str2){
            arr2[c - 'a']++;
        }
        int cnt = 0;
        for(int i=0;i<26;i++){
            cnt += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(cnt);

    }

}