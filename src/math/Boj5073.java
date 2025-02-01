package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            int A = Integer.parseInt(st.nextToken());
            max = Math.max(max, A);
            arr[0] = A;
            int B = Integer.parseInt(st.nextToken());
            max = Math.max(max, B);
            arr[1] = B;
            int C = Integer.parseInt(st.nextToken());
            max = Math.max(max, C);
            arr[2] = C;
            if(A==0 && B==0 && C==0){
                break;
            }else{
                if(A==B && A==C && B==C){
                    System.out.println("Equilateral");
                }else if(A!=B && A!=C && B!=C){
                    int sum = 0;
                    for(int i = 0; i < 3; i++){
                        if(arr[i]!=max) sum += arr[i];
                    }
                    if(max>=sum) System.out.println("Invalid");
                    else System.out.println("Scalene");
                }else{
                    int sum = 0;
                    int cnt = 0;
                    for(int i = 0; i < 3; i++){
                        if(arr[i]!=max) {
                            sum += arr[i];
                            cnt++;
                        }
                    }
                    if(cnt==1) sum += max;
                    if(max>=sum) System.out.println("Invalid");
                    else System.out.println("Isosceles");
                }
            }
        }
    }
}