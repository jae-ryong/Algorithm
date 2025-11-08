package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
* 처음 입력 받을 때
* while문으로 돌면서
* 1. 먼저 queue.poll() 해서 중요도 확인
* 2. 나머지 돌면서 중요도 제일 max 값 찾기
* */
public class Boj1966 {
    static class Printer {
        int x, importance;
        Printer(int x, int importance) {
            this.x = x;
            this.importance = importance;
        }
    }
    static Queue<Printer> queue;
    static int seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            seq = 0;
            queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.add(new Printer(i, Integer.parseInt(st.nextToken())));
            }

            // 여기서 프린터 로직 시작
            while(true) {
                Printer p1 = queue.poll();
                int max = 0;

                for(int i = 0; i< queue.size(); i++) {
                    Printer p2 = queue.poll();
                    max = Math.max(max, p2.importance);
                    queue.add(p2);
                }

                if(p1.importance >= max) {
                    seq++;
                    if(p1.x == K) break;
                } else {
                    queue.add(p1);
                }
            }
            System.out.println(seq);
        }
    }
}
