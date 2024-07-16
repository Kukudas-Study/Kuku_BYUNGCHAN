import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // input : 총 9줄 각 줄 별 하나의 자연수 
    // 주어지는 자연수는 100 보다 작다.
    // output : 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[9];
    for (int i = 0; i < 9; i++) {
      arr[i] = sc.nextInt();
    }

    // 최댓값을 구한다.
    int maxValue = Integer.MIN_VALUE; // 정수형 데이터 중 가장 작은 값으로 초기화
    int maxIndex = -1; // 최댓값의 인덱스를 저장할 변수
    for (int i = 0; i < 9; i++) {
      if (maxValue < arr[i]) {
        maxIndex = i;
        maxValue = arr[i];
      }
    }
    // 결과 출력
    System.out.println(maxValue);
    System.out.println(maxIndex + 1);
    
    sc.close();
  }
}