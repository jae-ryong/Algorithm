package etc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double jungongSum = 0;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double hakjum = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            double gradeNum=0.0;
            if(grade.equals("P")) continue;
            switch(grade){
                case "A+":
                    gradeNum = 4.5;
                    break;
                case "A0":
                    gradeNum = 4.0;
                    break;
                case "B+":
                    gradeNum = 3.5;
                    break;
                case "B0":
                    gradeNum = 3.0;
                    break;
                case "C+":
                    gradeNum = 2.5;
                    break;
                case "C0":
                    gradeNum = 2.0;
                    break;
                case "D+":
                    gradeNum = 1.5;
                    break;
                case "D0":
                    gradeNum = 1.0;
                    break;
                case "F":
                    gradeNum = 0.0;
                    break;
            }
            sum += hakjum;
            jungongSum += hakjum * gradeNum;
        }
        System.out.println(jungongSum/sum);
    }
}