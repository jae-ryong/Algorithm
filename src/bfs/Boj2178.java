package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj2178 {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] miro;
    static boolean[][] visited;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /*
    * 아이디어 :
    * 1이거나 방문을 안했을 경우 queue에 등록
    * queue에 넣을 때 전 값에 1을 더하기
    * */

    public static void bfs(int x , int y){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx <0 || ny <0 || nx>=N || ny>=M) continue;
                if(!visited[nx][ny] && miro[nx][ny]!=0){
                    visited[nx][ny] = true;
                    miro[nx][ny] = miro[p.x][p.y] + 1;
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(miro[N-1][M-1]);
    }
}