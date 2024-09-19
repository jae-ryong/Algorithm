package basic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1700 {
    static int N;
    static int K;
    static int[] mulgun;
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        mulgun = new int[K];
        st = new StringTokenizer(br.readLine());
        check = new boolean[K+1];
        for(int i = 0; i < K; i++){
            mulgun[i] = Integer.parseInt(st.nextToken());
        }
        int put = 0;
        for(int i = 0; i < K; i++){
            int mul = mulgun[i];
            // 플러그 안 꽂혀있는 경우
            if(!check[mul]) {
                if (put < N) {
                    check[mul] = true;
                    put++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (int j = i; j < K; j++) {
                        if (check[mulgun[j]] && !list.contains(mulgun[j])) {
                            list.add(mulgun[j]);
                        }
                    }

                    if(list.size() == N) {
                        check[list.get(list.size()-1)] = false;
                    }else{
                        for(int j=0;j<check.length;j++){
                            if(check[j] && !list.contains(j)){
                                check[j] = false;
                                break;
                            }
                        }
                    }
                    check[mul] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
