package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= new int[31];
        for(int i=1; i<29; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num] = 1;
        }
        for(int i=1; i<31; i++){
            if(arr[i] == 0) System.out.println(i);
        }
    }
}