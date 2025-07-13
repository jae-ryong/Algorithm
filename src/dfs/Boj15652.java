package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15652 {
    static int N;
    static int M;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[M];
        dfs(0,0);
        System.out.println(sb);
    }
    private static void dfs(int idx, int L) {
        if (L==M){
            for(int a : ch){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = idx; i < N; i++){
            ch[L] = i+1;
            dfs(i, L+1);
        }
    }
}