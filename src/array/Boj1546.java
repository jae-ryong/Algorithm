package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        double answer = (sum / (max * N)) * 100;
        System.out.println(answer);
    }
}