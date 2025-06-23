package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Boj1926 {
    static int N;
    static int M;
    static int[][] paper;
    static boolean[][] visited;
    static int max = 0;
    static int cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        int res = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny <0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || paper[nx][ny]==0) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                res+=1;
            }
        }
        max = Math.max(res, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(paper[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i,j);
                    cnt +=1;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }
}