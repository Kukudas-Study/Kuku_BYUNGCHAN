import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 배열 선언
    int[][] numArr = new int[9][9];
    // 사용자 입력값으로 배열 초기화
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        numArr[i][j] = sc.nextInt();
      }
    }

    // 최대값 및 위치 변수 선언 및 초기화
    int maxNum = Integer.MIN_VALUE;
    int maxRow = 0, maxColumn = 0;
    // 최대값 및 위치 찾기
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (maxNum < numArr[i][j]) {
          maxNum = numArr[i][j];
          maxRow = i + 1; // 인덱스 번호 대신 행 번호 저장
          maxColumn = j + 1; // 인덱스 번호 대신 열 번호 저장
        }
      }
    }

    // 결과 출력
    System.out.println(maxNum);
    System.out.println(maxRow + " " + maxColumn);

    sc.close();
  }
}