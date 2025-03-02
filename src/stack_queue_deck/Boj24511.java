package stack_queue_deck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr= new int[N][2];

        for(int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        int[] arr2 = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            if(arr[i][0]==0){
                deque.addFirst(arr[i][1]);
            }
        }

        for(int i=0; i<K;i++){
            deque.addLast(arr2[i]);
            sb.append(deque.pollFirst() + " ");
        }

        System.out.println(sb);
    }
}