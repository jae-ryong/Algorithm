package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2573 {
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

    static int N;
    static int M;
    static int[][] bingsan;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int totalCount = 1;

    /*
    *
    * 1. 반복문돌면서 0 보다 크면
      - 상하좌우 돌면서 0이 몇개인 지 체크하고 queue 넣기
      그리고 queue 빼면서 빙산 숫자 최신화하기
      2. bfs 이용해서 몇덩어리인지 체크하기
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bingsan = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                bingsan[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            queue = new LinkedList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(bingsan[i][j] > 0){
                        int cnt = checkCount(i,j);
                        queue.add(new Point(i,j,cnt));
                    }
                }
            }
            while(!queue.isEmpty()){
                Point p = queue.poll();
                if(bingsan[p.x][p.y] - p.cnt > 0){
                    bingsan[p.x][p.y] = bingsan[p.x][p.y] - p.cnt;
                } else {
                    bingsan[p.x][p.y] = 0;
                }
            }

            int count = 0;
            visited = new boolean[N][M];
            queue = new LinkedList<>();
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(bingsan[i][j] > 0 && !visited[i][j]){
                        queue.add(new Point(i,j,0));
                        visited[i][j] = true;
                        bfs();
                        count++;
                    }
                }
            }

            int zeroCount = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(bingsan[i][j]==0) zeroCount++;
                }
            }
            if(zeroCount == N*M){
                System.out.println(0);
                return;
            } else {
                if(count > 1) {
                    System.out.println(totalCount);
                    return;
                }
            }
            totalCount++;
        }
    }

    public static int checkCount(int x, int y){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(bingsan[nx][ny] == 0) cnt++;
        }
        return cnt;
    }

    public static void bfs() {
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(bingsan[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.add(new Point(nx,ny,0));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
