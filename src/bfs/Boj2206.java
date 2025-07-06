package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj2206 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static class Point{
        int x,y,cnt;
        boolean isDestroyed;
        Point(int x,int y, int cnt, boolean isDestroyed){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isDestroyed = isDestroyed;
        }
    }

    /*
    * 1. 벽이 아닐경우
    * - visited[][][0]은 벽을 안부수고 방문한 경우
    * - visited[][][1]은 벽을 부수고 방문한 경우
    * 2. 벽일경우
    * - visited[][][0]은 벽을 안부수고 방문한 경우
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        visited[0][0][0] = true;

        queue.add(new Point(0,0,0,false));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x==N-1 && p.y==M-1) {
                System.out.println(p.cnt+1);
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                // 벽이 아닌 경우
                if(map[nx][ny]==0) {
                    // 벽을 파괴한 적이 있을 때
                    if(p.isDestroyed && !visited[nx][ny][1]) {
                        queue.add(new Point(nx,ny,p.cnt+1,true));
                        visited[nx][ny][1] = true;
                    } else if(!p.isDestroyed && !visited[nx][ny][0]) {
                        queue.add(new Point(nx,ny,p.cnt+1,false));
                        visited[nx][ny][0] = true;
                    }
                }
                //벽인 경우
                else if(map[nx][ny]==1) {
                    if(!p.isDestroyed) {
                        queue.add(new Point(nx,ny,p.cnt+1,true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}