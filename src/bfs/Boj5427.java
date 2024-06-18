package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5427 {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int T;
    static int N;
    static int M;
    static Queue<Point> fireQueue;
    static Queue<Point> sanguenQueue;
    static char[][] building;
    static int[][] fireTime;
    static int[][] sanguenTime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            building = new char[N][M];
            fireTime = new int[N][M];
            sanguenTime = new int[N][M];
            fireQueue = new LinkedList<>();
            sanguenQueue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    building[i][j] = line.charAt(j);
                    if (building[i][j] == '*') {
                        fireQueue.add(new Point(i, j));
                        fireTime[i][j] = 1;
                    } else if (building[i][j] == '@') {
                        sanguenQueue.add(new Point(i, j));
                        sanguenTime[i][j] = 1;
                    }
                }
            }

            // 불퍼짐
            while (!fireQueue.isEmpty()) {
                Point fire = fireQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fire.x + dx[i];
                    int ny = fire.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (fireTime[nx][ny] > 0 || building[nx][ny] == '#') continue;
                    fireQueue.add(new Point(nx, ny));
                    fireTime[nx][ny] = fireTime[fire.x][fire.y] + 1;
                }
            }

            // 상근
            boolean escaped = false;
            while (!sanguenQueue.isEmpty() && !escaped) {
                Point sanguen = sanguenQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = sanguen.x + dx[i];
                    int ny = sanguen.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(sanguenTime[sanguen.x][sanguen.y]);
                        escaped = true;
                        break;
                    }
                    if (sanguenTime[nx][ny] > 0 || building[nx][ny] == '#' || (fireTime[nx][ny] != 0 && fireTime[nx][ny] <= sanguenTime[sanguen.x][sanguen.y] + 1)) continue;
                    sanguenQueue.add(new Point(nx, ny));
                    sanguenTime[nx][ny] = sanguenTime[sanguen.x][sanguen.y] + 1;
                }
            }

            if (!escaped) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
