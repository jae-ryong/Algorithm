package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Boj11650 {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            } else {
                return p1.x - p2.x;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
        }
        System.out.println(sb);
    }
}