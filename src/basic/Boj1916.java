package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916 {
    static int N;
    static int M;
    static int start;
    static int end;
    static int[] d;
    static boolean[] check;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        d = new int[N+1];
        check = new boolean[N+1];
        Arrays.fill(d,Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end,weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int answer = dijkstra(start , end);
        System.out.println(answer);
    }

    public static int dijkstra(int start , int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!check[cur.end]){
                check[cur.end] = true;
                for(Node n : graph.get(cur.end)){
                    if(!check[n.end] && d[n.end] > n.weight + d[cur.end]){
                        d[n.end] = n.weight + d[cur.end];
                        pq.add(new Node(n.end,d[n.end]));
                    }
                }
            }
        }
        return d[end];
    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
