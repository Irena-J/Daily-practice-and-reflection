import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] credit = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            credit[i] = sc.nextInt();
            sum += credit[i];
        }
        int[] score = new int[n];
        for (int j = 0; j < n; ++j) {
            score[j] = sc.nextInt();
        }
        float point = sumGpa(score,credit);
        System.out.printf("%.2f",point/sum);
    }
    
    public static float sumGpa(int[] score,int[] credit) {
        float sum = 0f;
        for (int k = 0; k < score.length; ++k) {
            if (score[k] >= 90) {
                sum += 4.0 * credit[k];
            } else if (score[k] >= 85 && score[k] < 90) {
                sum += 3.7 * credit[k];
            } else if (score[k] >= 82 && score[k] < 85) {
                sum += 3.3 * credit[k];
            } else if (score[k] >= 78 && score[k] < 82) {
                sum += 3.0 * credit[k];
            } else if (score[k] >= 75 && score[k] < 78) {
                sum += 2.7 * credit[k];
            } else if (score[k] >= 72 && score[k] < 74) {
                sum += 2.3 * credit[k];
            } else if (score[k] >= 68 && score[k] < 72) {
                sum += 2.0 * credit[k];
            } else if (score[k] >= 64 && score[k] < 68) {
                sum += 1.5 * credit[k];
            } else if (score[k] >= 60 && score[k] < 64) {
                sum += credit[k];
            } else {
                sum += 0;
            }
        }
        return sum;
    }
}