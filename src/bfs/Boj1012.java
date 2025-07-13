package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj1012 {
    static int T;
    static int N;
    static int M;
    static int K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] nonjang;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> queue;
    static int cnt;
    /*
    * 아이디어 :
    * for문 돌면서 1인경우 bfs 진행
    * */

    static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i < 4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(nonjang[nx][ny]==0 || nonjang[nx][ny]==2) continue;
                queue.add(new Point(nx, ny));
                nonjang[nx][ny] = 2;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            nonjang = new int[N][M];
            while(K-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nonjang[x][y] = 1;
            }

            queue = new LinkedList<>();
            cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(nonjang[i][j] == 1) {
                        nonjang[i][j] = 2;
                        queue.add(new Point(i, j));
                        bfs();
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}