import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // N: 바구니의 개수, M: 공을 넣는 횟수
    int N = sc.nextInt();
    int M = sc.nextInt();
    // N: 배열의 길이
    int[] basketArr = new int[N];

    // M: 바깥쪽 루프 도는 횟수
    for (int i = 0; i < M; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int ballNumber = sc.nextInt();
      sc.nextLine();
      // 해당 범위에 속하는 바구니 안에 공 집어넣기
      // 주의! index: 0 => 1번째 바구니, index: N-1 => N번째 바구니
      for (int basket = start; basket <= end; basket++) {
        basketArr[basket - 1] = ballNumber;
      }
    }

    // 결과 출력
    for (int basket : basketArr) {
      System.out.print(basket + " ");
    }

    sc.close();

  }
}