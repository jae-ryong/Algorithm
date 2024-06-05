package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for(int i=1; i<=N; i++) deque.add(i);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
                int half_idx;
                if(deque.size() %2 ==0){
                    half_idx = deque.size()/2 - 1;
                }else{
                    half_idx = deque.size()/2;
                }

                Deque<Integer> deque2 = new LinkedList<>(deque);

                int idx = check(deque2, num);
                if(half_idx >= idx){
                    while(idx>0){
                        cnt++;
                        deque.addLast(deque.pollFirst());
                        idx -= 1;
                    }
                }else{
                    while(deque.size()-idx>0){
                        cnt++;
                        deque.addFirst(deque.pollLast());
                        idx += 1;
                    }
                }
                deque.pollFirst();
        }
        System.out.println(cnt);
    }

    private static int check(Deque<Integer> deque, int num) {
        int idx = 0;
        for (int val : deque) {
            if (val == num) {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}