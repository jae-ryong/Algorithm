package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2346 {
    static class Item {
        int idx, num;
        public Item(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Item> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) deque.add(new Item(i,Integer.parseInt(st.nextToken())));

        // false가 오른쪽
        boolean direction = false;
        while (!deque.isEmpty()) {
            Item item;
            if(direction) item = deque.pollLast();
            else item = deque.pollFirst();

            if(item.num<0) direction = true;
            else direction = false;
            if(direction) {
                for(int i=0;i<Math.abs(item.num)-1;i++){
                    if(deque.isEmpty()) break;
                    deque.addFirst(deque.pollLast());
                }
            }else{
                for(int i=0;i<item.num-1;i++){
                    if(deque.isEmpty()) break;
                    deque.addLast(deque.pollFirst());
                }
            }
            sb.append(item.idx + " ");
        }
        System.out.println(sb);
    }
}