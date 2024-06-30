package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        ch = new int[M];
        dfs(0);
    }

    private static void dfs(int L) {
        if(L==M){
            for(int a : ch) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                ch[L] = i+1;
                dfs(L+1);
                visited[i] = false;
            }
        }
    }
}

