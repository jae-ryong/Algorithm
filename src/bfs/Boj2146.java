package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2146 {

    static int N;
    static int[][] jido;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static Queue<Point> queue;
    static Queue<Point> queue2;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        jido = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                jido[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue = new LinkedList<>();
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(jido[i][j] == 1 && !visited[i][j]){
                    queue2 = new LinkedList<>();
                    visited2 = new boolean[N][N];
                    visited[i][j] = true;
                    visited2[i][j] = true;
                    queue.add(new Point(i, j, 0));
                    // 일단 한 구역 bfs 탐색
                    bfs();
                    // 외각 값 qeuue에 놓고 bfs돌면서 최솟 값 찾기
                    bfs2();
                }
            }
        }
        System.out.println(min);
    }

    public static void bfs() {
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || jido[nx][ny]==0) {
                    if(jido[nx][ny]==0){
                        queue2.add(new Point(nx, ny, 0));
                        visited2[nx][ny] = true;
                    }
                    continue;
                }
                visited[nx][ny] = true;
                visited2[nx][ny] = true;
                queue.add(new Point(nx, ny, 0));
            }
        }
    }

    public static void bfs2() {
        while(!queue2.isEmpty()){
            Point p = queue2.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited2[nx][ny]) continue;
                if(jido[nx][ny]==1){
                    min = Math.min(min,p.cnt+1);
                    continue;
                }
                visited2[nx][ny] = true;
                queue2.add(new Point(nx, ny, p.cnt+1));
            }
        }
    }
}
