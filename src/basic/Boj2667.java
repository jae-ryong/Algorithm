package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2667 {
    static int N;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String a = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(a.charAt(j)));
            }
        }
        list = new ArrayList<>();
        int total = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 1){
                    bfs(i,j);
                    total++;
                }
            }
        }
        System.out.println(total);
        list.stream().sorted().forEach(System.out::println);
    }
    private static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        arr[x][y] = 0;
        int cnt =0;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(arr[nx][ny] == 0) continue;
                q.add(new Point(nx, ny));
                arr[nx][ny] = 0;
            }
            cnt++;
        }
        list.add(cnt);
    }
}
