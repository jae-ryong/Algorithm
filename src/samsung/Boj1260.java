package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {

    static int N;
    static int M;
    static int V;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1;i<=N;i++) {
            Collections.sort(graph.get(i));
        }


        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);

    }

    public static void dfs(int V) {
        if(visited[V]) return;
        visited[V] = true;
        System.out.print(V + " ");
        for(int a: graph.get(V)) {
            if(!visited[a]){
                dfs(a);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        System.out.print(V + " ");
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int a: graph.get(v)) {
                if(!visited[a]){
                    q.add(a);
                    visited[a] = true;
                    System.out.print(a + " ");
                }
            }
        }
    }
}
