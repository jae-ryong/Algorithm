package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {

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
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();
        for(int i=0;i<N;i++){
            String a = br.readLine();
            for(int j=0;j<M;j++){
                miro[i][j] = a.charAt(j)-'0';
            }
        }
        bfs();
        System.out.println(miro[N-1][M-1]);
    }
    private static void bfs() {
        queue.add(new Point(0,0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(miro[nx][ny]==0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;

                miro[nx][ny] = miro[a.x][a.y] + 1;
                queue.add(new Point(nx,ny));
            }
        }
    }
}
