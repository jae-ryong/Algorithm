package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj7562 {
    static int N;
    static int T;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] chess;
    static boolean[][] visited;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> queue;

    /*
    * 아이디어 :
    * 테스트케이스만큼 반복문 돌면서
    * 입력 값 받고
    * 이동할 때마다 전 값에 +1 해서 마지막에 그 위치 배열 값 출력
    * */


    public static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i =0; i<8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                chess[nx][ny] = chess[p.x][p.y] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            chess = new int[N][N];
            visited = new boolean[N][N];
            queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Point(x, y));
            visited[x][y] = true;

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bfs();
            System.out.println(chess[x][y]);
        }
    }
}