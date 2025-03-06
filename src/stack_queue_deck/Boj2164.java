package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while(true) {
            if(queue.size()==1) break;
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }
}