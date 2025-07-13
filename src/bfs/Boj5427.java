package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5427 {
    static int T;
    static int M;
    static int N;
    static char[][] building;
    static int[][] bull;
    static boolean[][] bullVisited;
    static int[][] sangun;
    static boolean[][] sangunVisited;
    static Queue<Point> bullQueue;
    static Queue<Point> sangunQueue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            building = new char[N][M];
            bull = new int[N][M];
            bullVisited = new boolean[N][M];
            sangun = new int[N][M];
            sangunVisited = new boolean[N][M];
            bullQueue = new LinkedList<>();
            sangunQueue = new LinkedList<>();

            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    building[i][j] = line.charAt(j);
                    if(building[i][j]=='*') {
                        bullQueue.add(new Point(i, j));
                        bullVisited[i][j] = true;
                    } else if (building[i][j] == '@'){
                        sangunQueue.add(new Point(i, j));
                        sangunVisited[i][j] = true;
                    }
                }
            }

            cnt = Integer.MAX_VALUE;
            // 불
            bullBfs();

            // 상근 BFS
            sangunBfs();

            if(cnt == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(cnt);
            }
        }

    }

    public static void bullBfs() {
        while(!bullQueue.isEmpty()) {
            Point p = bullQueue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(bullVisited[nx][ny] || building[nx][ny] == '#') continue;
                bullVisited[nx][ny] = true;
                bullQueue.add(new Point(nx, ny));
                bull[nx][ny] = bull[p.x][p.y] + 1;
            }
        }
    }

    public static void sangunBfs() {
        while(!sangunQueue.isEmpty()) {
            Point p = sangunQueue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) {
                    cnt = Math.min(sangun[p.x][p.y]+1,cnt);
                    continue;
                }
                if(sangunVisited[nx][ny] || building[nx][ny] == '#') continue;
                if(bull[nx][ny]> sangun[p.x][p.y] +1 || !bullVisited[nx][ny]) {
                    sangunVisited[nx][ny] = true;
                    sangunQueue.add(new Point(nx, ny));
                    sangun[nx][ny] = sangun[p.x][p.y] + 1;
                }
            }
        }
    }
}
