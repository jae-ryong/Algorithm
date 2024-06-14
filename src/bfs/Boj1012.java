package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T;
    static int N;
    static int M;
    static int K;
    static int[][] baechu;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int cnt =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            baechu = new int[M][N];
            visited = new boolean[M][N];
            queue = new LinkedList<>();
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                baechu[x][y] = 1;
            }

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(baechu[i][j]==1 && !visited[i][j]){
                        queue.add(new Point(i,j));
                        visited[i][j] = true;
                        bfs();
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);

        }
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0||ny<0||nx>=M||ny>=N) continue;
                if(visited[nx][ny] || baechu[nx][ny]==0) continue;
                queue.add(new Point(nx,ny));
                visited[nx][ny] = true;
            }
        }
    }
}
