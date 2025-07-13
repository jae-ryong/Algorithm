package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15655 {
    static int N;
    static int M;
    static int[] ch;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[M];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    static void dfs(int idx, int L) {
        if(L==M){
            for(int a : ch){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=idx;i<N;i++) {
            ch[L] = arr[i];
            dfs(i+1,L+1);
        }
    }
}