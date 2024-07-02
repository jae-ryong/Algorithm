package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15652 {
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
        dfs(0,0);
    }

    private static void dfs(int idx, int L) {
        if(L==M){
            for(int a : ch) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx;i<N;i++){
            ch[L] = i+1;
            dfs(i,L+1);
        }
    }
}

