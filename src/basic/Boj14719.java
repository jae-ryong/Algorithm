package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14719 {
    static int H;
    static int W;
    static int[] arr;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new int[W];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < W; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<W-1;i++){
                int idx = arr[i];
                int left = Integer.MIN_VALUE;
                int right = Integer.MIN_VALUE;
                for(int j=0;j<i;j++){
                    left = Math.max(left,arr[j]);
                }
                for(int j=i+1;j<W;j++){
                    right = Math.max(right,arr[j]);
                }
                if(left > idx && right > idx){
                    int min = Math.min(left,right);
                    answer += min - arr[i];
                }
            }

            System.out.println(answer);
        }
    }
