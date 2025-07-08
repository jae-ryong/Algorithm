package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549 {

    static int N;
    static int K;
    static class Point{
        int x, cho;
        Point(int x, int cho){
            this.x =x ;
            this.cho = cho;
        }
    }
    static boolean[] visited;
    static Queue<Point> queue;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        queue = new LinkedList<>();
        visited[N] = true;
        queue.add(new Point(N, 0));
        bfs();
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x==K ){
                System.out.println(p.cho);
                return;
            }

            if(p.x*2 <= 100000 && !visited[p.x*2]){
                visited[p.x*2] = true;
                queue.add(new Point(p.x*2, p.cho));
            }

            if(p.x-1 >= 0 && !visited[p.x-1]){
                visited[p.x-1] = true;
                queue.add(new Point(p.x-1, p.cho+1));
            }
            if(p.x+1 <= 100000 && !visited[p.x+1]){
                visited[p.x+1] = true;
                queue.add(new Point(p.x+1, p.cho+1));
            }

        }
    }
}
