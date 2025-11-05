package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/*
* 1. queue의 사이즈가 1이 아닌경우
* flag가 true이면 q에서 빼서 다시 집어놓고
* flag가 false이면 q에서 빼기
* 2. queue의 사이즈가 1인 경우
* 출력
* */
public class Boj2164 {
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag = false;
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        while(!q.isEmpty()) {
            if(q.size() == 1) {
                System.out.println(q.poll());
                break;
            } else {
                if(!flag) {
                    q.poll();
                    flag = true;
                } else {
                    q.add(q.poll());
                    flag = false;
                }
            }
        }
    }
}
