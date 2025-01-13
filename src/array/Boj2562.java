package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == max) {
                idx = i+1;
                break;
            }
        }
        System.out.println(idx);
    }
}