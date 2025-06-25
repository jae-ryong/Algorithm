package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {
    static int N;
    static int M;
    static int[] ch;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[M];
        visited = new boolean[N];
        dfs(0);
    }
    static void dfs(int L) {
        if (L==M){
            for(int i=0; i<ch.length; i++){
                System.out.print(ch[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<N;i++){
            if(!visited[i]){
                ch[L] = i+1;
                visited[i] = true;
                dfs(L+1);
                visited[i] = false;
            }
        }
    }
}