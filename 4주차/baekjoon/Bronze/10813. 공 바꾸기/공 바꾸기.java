import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    // 배열 선언 및 초기화
    int[] basket = new int[N];
    for (int i = 0; i < basket.length; i++) {
      basket[i] = i + 1;
    }
    // M번 공 교환
    for (int i = 1; i <= M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      // i번째 공과 j번째 공 서로 위치 교환
      int temp = basket[a-1];
      basket[a-1] = basket[b-1];
      basket[b-1] = temp;
    }

    // 결과 출력
    for (int b: basket) {
      System.out.print(b + " ");
    }

    sc.close();
  }
}