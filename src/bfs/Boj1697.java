package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;


public class Boj1697 {

    static class Point{
        int x;
        int cnt;
        Point(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N,0));
        visited[N] = true;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p.x==K){
                cnt = p.cnt;
                break;
            }
            if (p.x + 1 <= 100000 && !visited[p.x + 1]) {
                visited[p.x + 1] = true;
                q.add(new Point(p.x + 1, p.cnt + 1));
            }

            if (p.x * 2 <= 100000 && !visited[p.x * 2]) {
                visited[p.x * 2] = true;
                q.add(new Point(p.x * 2, p.cnt + 1));
            }
            if (p.x - 1 >= 0 && !visited[p.x - 1]) {
                visited[p.x - 1] = true;
                q.add(new Point(p.x - 1, p.cnt + 1));
            }
        }

        System.out.println(cnt);
    }
}