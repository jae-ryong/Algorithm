package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15686 {
    static int N;
    static int M;
    static int[][] chicken;
    static ArrayList<Point> list = new ArrayList<Point>();
    static ArrayList<Point> dosi = new ArrayList<Point>();
    static int[] ch;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                chicken[i][j] = Integer.parseInt(st.nextToken());
                if(chicken[i][j] == 2) list.add(new Point(i, j));
                if(chicken[i][j] == 1) dosi.add(new Point(i, j));
            }
        }
        ch = new int[M];

        dfs(0,0);
        System.out.println(minValue);
    }

    public static void dfs(int idx, int L){
        if(L==M){
            int answer = 0;
            for(int i=0;i<dosi.size();i++){
                int distance = Integer.MAX_VALUE;
                for(int j: ch){
                    Point a = list.get(j);
                    distance = Math.min(distance,Math.abs(a.x-dosi.get(i).x)+Math.abs(a.y-dosi.get(i).y));
                }
                answer += distance;
            }
            minValue = Math.min(minValue, answer);
            return;
        }

        for(int i=idx;i<list.size();i++){
            ch[L] = i;
            dfs(i+1,L+1);
        }
    }
}
