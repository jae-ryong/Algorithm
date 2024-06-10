package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1926 {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static Queue<Point> queue;
    static int[][] dohwaji;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int cnt = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dohwaji = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dohwaji[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(dohwaji[i][j]==1){
                    queue = new LinkedList<>();
                    queue.add(new Point(i,j));
                    bfs();
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);

    }

    static void bfs() {
        int count = 0;
        while(!queue.isEmpty()){
            Point a = queue.poll();
            dohwaji[a.x][a.y] = 2;
            for(int i=0; i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0|| nx>=N || ny>=M) continue;
                if(dohwaji[nx][ny]==0 || dohwaji[nx][ny]==2) continue;
                queue.add(new Point(nx,ny));
                dohwaji[nx][ny] = 2;
            }
            count++;
        }
        max = Math.max(max,count);
    }
}
