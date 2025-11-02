package tony_datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10828 {
    public static int cnt = 0;
    public static int back = 0;
    public static int[] stack = new int[100000];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            switch (type) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }
        System.out.println(sb.toString());

    }

    private static void push(int num) {
        stack[back] = num;
        back++;
        cnt++;
    }

    private static void pop() {
        if(cnt == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack[back-1]).append("\n");
            back--;
            cnt--;
        }
    }

    private static void size() {
        sb.append(cnt).append('\n');
    }

    private static void empty() {
        if(cnt == 0) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static void top() {
        if (cnt == 0) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack[back-1]).append("\n");
        }
    }

}
