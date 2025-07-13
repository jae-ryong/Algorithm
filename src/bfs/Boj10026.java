package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj10026 {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] grid;
    static boolean[][] visited;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> queue = new LinkedList<>();

    /*
    * 아이디어 :
    * 반복문 돌면서 방문하지 않으면 bfs 돔 (bfs 돌때 각 해당하는 문자 파악)
    * 적록색약이 아닌 사람인 경우 위처럼 풀면되고
    * 적록색약인경우
    * 배열을 반복문 돌면서 R을 G로 변경하기
    * 그리고 똑같이 bfs
    * */

    public static void bfs(char color) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(grid[nx][ny] != color || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        grid = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    bfs(grid[i][j]);
                    cnt++;
                }
            }
        }

        sb.append(cnt).append(" ");
        // 적록색약인경우
        queue = new LinkedList<>();
        visited = new boolean[N][N];
        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j] == 'R') {
                    grid[i][j] = 'G';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Point(i, j));
                    bfs(grid[i][j]);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}