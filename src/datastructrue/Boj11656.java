package datastructrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        String[] arr= new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = word.substring(i, len);
        }

        Arrays.sort(arr,(o1,o2)->o1.compareTo(o2));
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}