package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열을 두 개 만들어서 진행한 코드 (원래 내가 작성했음)
 * 통과는 했지만 배열을 하나 더 만들었다는 점이 만족 안듬
 */
public class Boj10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i= 1;i<=N;i++){
            arr[i] = i;
        }
        int[] arr2= new int[N+1];

        for(int i=0; i < M; i++){
            copy(arr,arr2);
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==b) continue;
            int num = a;
            for(int j=b; j>=a; j--){
                arr[j] = arr2[num++];
            }
        }

        for(int i= 1 ; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void copy(int[] arr, int[] arr2) {
        for(int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }
    }
}