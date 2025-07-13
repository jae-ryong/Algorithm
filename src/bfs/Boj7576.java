package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj7576 {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] tomato;
    static boolean[][] visited;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> q = new LinkedList<>();

    /*
    * 아이디어 :
    * 반복문 돌면서 1인 경운 queue에 저장
    * queue while 돌면서 0인 경우에만 queue add
    * */

    public static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx <0 || ny <0 || nx >= M || ny >= N || visited[nx][ny]) continue;
                if(tomato[nx][ny] == 0) {
                    q.add(new Point(nx, ny));
                    tomato[nx][ny] = tomato[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomato = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(tomato[i][j] == 1){
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(tomato[i][j] == 0) cnt++;
                max = Math.max(max, tomato[i][j]);
            }
        }

        if (cnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(max-1);
        }
    }
}