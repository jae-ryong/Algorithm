package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1292 {
    static int A;
    static int B;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[1002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int idx = 1;
        for(int i=1;i<=1000;){
            int cnt = 0;
            while(true){
                if(idx==cnt){
                    idx++;
                    break;
                }
                arr[i++] = idx;
                if(i>=1000) break;
                cnt++;
            }
        }
        int sum = 0;
        for(int i=A;i<=B;i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
