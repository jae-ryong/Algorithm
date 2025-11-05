package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/*
* ArrayDeque를 이용해서 진행
* 1. 양수면 앞에서 빼서 뒤로하고 앞에 poll
* 2. 음수면 뒤에서 빼서 앞으로하고 뒤에 poll
* - poll한다음에 절대값 +1 만큼 위에걸 진행
* */
public class Boj2346 {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static class Balloon {
        int x, move;

        Balloon(int x, int move) {
            this.x = x;
            this.move = move;
        }
    }

    static ArrayDeque<Balloon> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            deque.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        // 첫번째는 그냥 진행
        if(deque.size() == 1) {
            System.out.println(deque.poll().x);
            return;
        }
        Balloon balloon = deque.pollFirst();
        boolean flag = false;
        // true 일경우 양수
        if(balloon.move > 0) {
            flag = true;
        } else {
            flag = false;
        }
        cnt = Math.abs(balloon.move)-1;
        sb.append(1).append(" ");
        while(deque.size() >1) {

            Balloon b1;
            if(flag) {
                for(int i = 0; i < cnt; i++) {
                    deque.offer(deque.pollFirst());
                }
                b1 = deque.pollFirst();
            } else {
                for(int i = 0; i < cnt; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                b1 = deque.pollLast();
            }
            sb.append(b1.x).append(" ");
            if (b1.move > 0) {
               flag = true;
               cnt = Math.abs(b1.move)-1;
            } else {
                flag = false;
                cnt = Math.abs(b1.move)-1;
            }

        }
        sb.append(deque.poll().x);
        System.out.println(sb.toString());
    }
}
