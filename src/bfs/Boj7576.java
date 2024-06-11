package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {

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
    static int[][] tomato;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomato = new int[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0; i<4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                if(visited[nx][ny] || tomato[nx][ny] == -1 || tomato[nx][ny]>0) continue;
                visited[nx][ny] = true;
                tomato[nx][ny] = tomato[a.x][a.y] + 1;
                queue.add(new Point(nx, ny));
            }
        }
        int max = 0;
        int cnt = 0;
        int cnt2 = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                max = Math.max(max, tomato[i][j]);
                if(tomato[i][j] == 1) cnt++;
                if(tomato[i][j] == 0) cnt2++;
            }
        }
        if(cnt==N*M){
            System.out.println(0);
        }else if(cnt2>0) System.out.println(-1);
        else{
            System.out.println(max-1);
        }

    }
}
