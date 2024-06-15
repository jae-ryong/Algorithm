package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10026 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Point> queue;
    static char[][] saram;
    static char[][] jucsaram;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        saram = new char[N][N];
        jucsaram = new char[N][N];
        StringBuilder sb= new StringBuilder();

        for(int i = 0; i < N; i++){
            String a = br.readLine();
            for(int j = 0; j < N; j++){
                saram[i][j] = a.charAt(j);
            }
        }

        // 적록색약 처리 R을 G로 바꿈
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(saram[i][j] == 'R'){
                    jucsaram[i][j] = 'G';
                }else{
                    jucsaram[i][j] = saram[i][j];
                }
            }
        }

        //적록색약 아닌 경우 bfs
        int cnt = 0;
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    bfs1();
                    cnt++;
                }
            }
        }
        sb.append(cnt).append(" ");


        //적록색약인경우 bfs
        cnt = 0;
        visited = new boolean[N][N];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    bfs2();
                    cnt++;
                }
            }
        }

        sb.append(cnt);

        System.out.println(sb);
    }

    public static void bfs1(){
        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || saram[a.x][a.y] != saram[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }

    public static void bfs2(){
        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny] || jucsaram[a.x][a.y] != jucsaram[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }
}
