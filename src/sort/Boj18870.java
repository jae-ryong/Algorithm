package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = arr[i];
        }
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i],cnt++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(result[i]) + " ");
        }
        System.out.println(sb);
    }
}

// 시간초과 오류 코드
//public class Boj18870 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//        int[] result = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//            result[i] = arr[i];
//        }
//        Arrays.sort(result);
//
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < N; i++){
//            int num = arr[i];
//            List<Integer> list = new ArrayList<>();
//            for(int j=0;j<N;j++){
//                if(num > result[j]){
//                    if(!list.contains(result[j])){
//                        list.add(result[j]);
//                    }
//                }else{
//                    break;
//                }
//            }
//            sb.append(list.size()).append(" ");
//        }
//        System.out.println(sb);
//    }
//}