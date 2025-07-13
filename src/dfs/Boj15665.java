package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15665 {
    static int N;
    static int M;
    static int[] arr;
    static int[] ch;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
    private static void dfs(int L) {
        if (L==M) {
            for(int a : ch){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=0; i<N; i++){
            if(before!=arr[i]){
                ch[L] = arr[i];
                dfs(L+1);
                before = arr[i];
            }
        }
    }
}