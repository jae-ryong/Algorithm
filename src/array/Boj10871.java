package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num < 0){
                arr[Math.abs(num)+100]++;
            }else{
                arr[num]++;
            }
        }
        int v = Integer.parseInt(br.readLine());
        if(v<0){
            System.out.println(arr[Math.abs(v)+100]);
        }else{
            System.out.println(arr[v]);
        }
    }
}
