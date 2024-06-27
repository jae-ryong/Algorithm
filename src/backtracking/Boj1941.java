package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1941 {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static Character[][] student;
    static boolean[][] visited;
    static int answer = 0;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        student = new Character[5][5];
        visited = new boolean[5][5];
        for(int i=0;i<5;i++){
            String a = br.readLine();
            for(int j=0; j< 5; j++){
                student[i][j] = a.charAt(j);
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int index, int L){
        if(L==7){
            if(checkGongju()){
                answer++;
            }
            return;
        }
        for(int i=index; i<25; i++){
            visited[i/5][i%5] = true;
            dfs(i+1,L+1);
            visited[i/5][i%5] = false;
        }
    }

    private static boolean checkGongju() {
        boolean[][] copyvisited = new boolean[5][5];
        for(int i=0; i<5;i++){
            copyvisited[i] = visited[i].clone();
        }
        int x = 0;
        int y = 0;
        int cnt = 0;
        int scnt=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(copyvisited[i][j]){
                    x = i;
                    y = j;
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while(!queue.isEmpty()){
            Point a = queue.poll();
            for(int i=0;i<4;i++){
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;
                if(copyvisited[nx][ny]){
                    if(student[nx][ny]=='S') scnt++;
                    cnt++;
                    queue.add(new Point(nx,ny));
                    copyvisited[nx][ny] = false;
                }
            }
        }
        if(cnt==7 && scnt>=4) return true;
        return false;
    }
}

