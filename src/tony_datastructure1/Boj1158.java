package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/*
* Queue 자료구조를 이용
* 1. 먼저 queue에 다 넣는다.
* 2. queue가 빌때까지 반복한다.
*   - K전까지 빼고 다시 넣는다
*   - K가 되면 빼면서 출력한다.
* */

public class Boj1158 {
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        sb.append('<');

        while (!q.isEmpty()) {
            int cnt = 1;
            for(int i = 0; i < K; i++) {
                if(cnt==K){
                    if(q.size()==1) {
                        sb.append(q.poll()).append(">");
                    } else {
                        sb.append(q.poll()).append(", ");
                    }
                } else {
                    q.add(q.poll());
                    cnt++;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
