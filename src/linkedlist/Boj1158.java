package linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<N;i++){
            queue.add(i+1);
        }

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(!queue.isEmpty()){
            if(cnt==K){
                if(queue.size()==1){
                    sb.append(queue.poll());
                }else{
                    sb.append(queue.poll());
                    sb.append(", ");
                    cnt = 1;
                }
            }else{
                queue.add(queue.poll());
                cnt++;
            }
        }

        sb.append('>');
        System.out.println(sb.toString());
    }
}