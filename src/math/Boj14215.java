package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr= new int[3];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        Arrays.sort(arr);
        if(arr[2]>=arr[0]+arr[1]){
            System.out.println(2*(arr[0]+arr[1])-1);
        }else{
            System.out.println(A+B+C);
        }
    }
}