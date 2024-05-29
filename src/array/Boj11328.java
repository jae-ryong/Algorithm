package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            for(int j=0;j<a.length();j++){
                arr1[a.charAt(j)-'a']++;
            }
            for(int j=0;j<b.length();j++){
                arr2[b.charAt(j)-'a']++;
            }

            if(isequal(arr1,arr2)){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }

        }
    }

    private static boolean isequal(int[] arr1, int[] arr2) {
        for(int i=0; i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}