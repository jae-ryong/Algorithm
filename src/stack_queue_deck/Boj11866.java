package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append('<');

        for(int i = 1; i <= N; i++) queue.add(i);

        while(!queue.isEmpty()) {
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            if(queue.size()==1) sb.append(queue.poll()).append('>');
            else sb.append(queue.poll()).append(", ");
        }
        System.out.println(sb);
    }
}