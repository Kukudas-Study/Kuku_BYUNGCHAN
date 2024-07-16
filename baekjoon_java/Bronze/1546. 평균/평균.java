import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // input: 세준이의 과목 별 시험점수
    // output: 새로 구한 평균
    
    // 1. 세준이의 시험점수는 고친 점수가 소수점 이하 숫자가 존재해 실수일 가능성이 높으므로 실수형 데이터로 관리하기 쉽도록 입력받고 배열로 관리
    Scanner sc = new Scanner(System.in);
    int subjectCnt = sc.nextInt();
    double[] score = new double[subjectCnt];
    for (int i = 0; i < subjectCnt; i++) {
      score[i] = sc.nextDouble();
    }
    
    // 2. 세준이의 시험점수 중 최댓값을 구한다.
    double M = getMax(score);
    
    // 3. 세준이의 시험점수 중 최댓값을 제외한 모든 점수를 점수/M*100로 변경한다.
    for (int i = 0; i < subjectCnt; i++) {
      score[i] = (score[i] / M) * 100;
    }
    
    // 4. 평균을 구한다.
    double avg = (double) getSum(score) / subjectCnt;
    // 5. 결과를 출력한다.
    System.out.println(avg);

    sc.close();
  }

  private static double getMax(double[] numArr) {
    double max = numArr[0];
    for (int i = 1; i < numArr.length; i++) {
      if (max < numArr[i]) {
        max = numArr[i];
      }
    }
    return max;
  }
  private static double getSum(double[] numArr) {
    double result = 0;
    for (double num: numArr) {
      result += num;
    }
    return result;
  }
}