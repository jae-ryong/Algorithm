package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Boj2667 {
    static int N;
    static int[][] rectangle;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;
    static List<Integer> list = new ArrayList<>();

    public static void dfs(int x, int y) {
        cnt+=1;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx <0 || nx >= N || ny <0 || ny >= N) continue;
            if(visited[nx][ny] || rectangle[nx][ny]==0) continue;
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rectangle = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                rectangle[i][j] = line.charAt(j) -  '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(rectangle[i][j] ==1 && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(int a : list) {
            System.out.println(a);
        }
    }
}
