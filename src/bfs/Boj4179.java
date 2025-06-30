package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj4179 {
    static int N;
    static int M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] miro;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int[][] fire;
    static int[][] jihun;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int time = Integer.MAX_VALUE;
    static Queue<Point> q1 = new LinkedList<>();
    static Queue<Point> q2 = new LinkedList<>();
    /*
    * 아이디어 :
    * 불이 난 공간부터 bfs돌리면서 시간 체크
    * 지훈이 bfs하면서 불보다 시간이 작은 경우와 방문안한경우에만 가기
    * 사방이 막혀 탈출을 하지 못하는 경우 Impossible
    *
    * 자료구조
    * char[][] miro
    * int[][] fire : 불이 번지는 속도를 파악하기 위함
    * boolean[][] visited (초기화해서 같이 이용)
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M];
        fire = new int[N][M];
        jihun = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                miro[i][j] = line.charAt(j);
                if(miro[i][j] == 'F'){
                    q1.add(new Point(i, j));
                    visited[i][j] = true;
                }else if(miro[i][j] == 'J'){
                    q2.add(new Point(i, j));
                    visited2[i][j] = true;
                }
            }
        }

        // 불
        while(!q1.isEmpty()){
            Point p = q1.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if(miro[nx][ny]=='#' || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q1.add(new Point(nx, ny));
                fire[nx][ny] = fire[p.x][p.y] + 1;
            }
        }

        boolean check = false;
        //지훈
        while(!q2.isEmpty()){
            Point p = q2.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M ) {
                    check = true;
                    time = Math.min(jihun[p.x][p.y] + 1,time);
                    continue;
                }
                if(miro[nx][ny]=='#' || visited2[nx][ny]) continue;
                if(fire[nx][ny] > jihun[p.x][p.y] + 1 || !visited[nx][ny]){
                    visited2[nx][ny] = true;
                    q2.add(new Point(nx, ny));
                    jihun[nx][ny] = jihun[p.x][p.y] + 1;
                }
            }
        }

        if(check){
            System.out.println(time);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }
}