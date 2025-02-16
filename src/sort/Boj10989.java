package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        int[] counting = new int[10000001];
        int[] result = new int[10000001];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            counting[arr[i]]++;
        }

        for(int i = 1; i < 10000001; i++) {
            counting[i] += counting[i - 1];
        }

        for(int i = 0; i < N; i++) {
            int val = arr[i];
            counting[val]--;
            result[counting[val]] = val;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10000001; i++) {
            if(result[i] != 0){
                sb.append(result[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}