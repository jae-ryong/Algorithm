package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
    static int N;
    static int M;
    static int[][] computer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        computer = new int[N + 1][N + 1];
        StringTokenizer st;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer[a][b] = 1;
            computer[b][a] = 1;
        }
        bfs(1);
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);
        int cnt = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1; i<=N; i++) {
                if(computer[cur][i]==1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
