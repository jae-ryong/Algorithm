package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10870 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[21];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=20;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[N]);
    }
}
