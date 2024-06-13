package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1679 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] line = new int[100001];
        int[] ck = {1,-1,2};
        line[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for(int i=0;i<3;i++){
                int a = 0;
                if(i==2) a = idx * ck[i];
                else a = idx + ck[i];
                if(a<0 || a>=100001 || line[a]>0) continue;
                line[a] = line[idx] + 1;
                queue.add(a);
            }
        }

        System.out.println(line[X]-1);
    }
}
