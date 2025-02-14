package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        int[] counting = new int[2000001];
        int[] result = new int[2000001];
        boolean check = false;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine()) + 1000000;
            if(arr[i]==0) {
                check = true;
            }
        }

        for(int i=0;i<N;i++){
            counting[arr[i]]++;
        }

        for(int i=1;i<counting.length;i++){
            counting[i] += counting[i-1];
        }

        for(int i=0;i<N;i++){
            int val = arr[i];
            counting[val]--;
            result[counting[val]] = val;
        }

        for(int i=0;i<result.length;i++){
            if(check){
                System.out.println(-1000000);
                check = false;
                continue;
            }
            if(result[i]!=0) System.out.println(result[i]-1000000);
        }
    }
}