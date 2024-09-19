package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {
    static int N;
    static int S;
    static int[] suyal;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        suyal = new int[N+1];
        for(int i=0;i<N; i++){
            suyal[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int hap = 0;
        while(start<=N && end<=N){
            if(hap >= S && min > end-start){
                min = end-start;
            }
            if(hap > S){
                hap -= suyal[start++];
            }else{
                hap += suyal[end++];
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);

    }
}
