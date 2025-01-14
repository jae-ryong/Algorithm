package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내가 작성한 코드가 마음에 들지 않아서 인터넷 참고한 코드
 * 참고하고 구현은 내가 함
 */
public class Boj10811_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i= 1;i<=N;i++){
            arr[i] = i;
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(left==right) continue;
            while(left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }

        for(int i= 1 ; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}