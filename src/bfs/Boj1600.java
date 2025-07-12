package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1600 {

    static int K;
    static int H;
    static int W;
    static int[][] dolmulwon;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dx1 = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy1 = {-2, -1, 1, 2, 2, 1, -1,-2};
    static boolean[][][] visited;
    static class Point{
        int x;
        int y;
        int cnt;
        int cho;
        Point(int x, int y, int cnt, int cho) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.cho = cho;
        }
    }
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        dolmulwon = new int[W][H];
        visited = new boolean[W][H][K+1];

        for(int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < H; j++) {
                dolmulwon[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.add(new Point(0,0,K,0));
        visited[0][0][K] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.x == W-1 && p.y == H-1) {
                System.out.println(p.cho);
                return;
            }
            for(int i = 0; i< 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=W || ny>=H) continue;
                if(visited[nx][ny][p.cnt] || dolmulwon[nx][ny]==1) continue;
                queue.add(new Point(nx,ny,p.cnt,p.cho+1));
                visited[nx][ny][p.cnt] = true;
            }

            if(p.cnt>0){
                for(int i = 0; i< 8; i++){
                    int nx = p.x + dx1[i];
                    int ny = p.y + dy1[i];
                    if(nx<0 || ny<0 || nx>=W || ny>=H) continue;
                    if(visited[nx][ny][p.cnt-1] || dolmulwon[nx][ny]==1) continue;
                    queue.add(new Point(nx,ny,p.cnt-1,p.cho+1));
                    visited[nx][ny][p.cnt-1] = true;
                }
            }

        }

        System.out.println(-1);

    }
}
