import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 바구니의 총 개수 : N
    // 바구니 번호는 1부터 시작, N이 끝번호.
    // M번 바구니의 순서를 역순으로?
    // 먼저 순서를 역순으로 만들 범위를 정한다.
    // 그 범위에 들어있는 바구니의 순서만 역순으로 만든다.

    // 예시) N: 5, M: 4
    // 5개의 바구니가 있고, 4번 바구니의 순서를 역순으로 만든다.
    // 초기) [1, 2, 3, 4, 5]
    // 1) 1번째 ~ 2번째 바구니의 순서를 역순으로 만든다.
    // [1, 2, 3, 4, 5] -> [2, 1, 3, 4, 5] 
    // 2) 3번째 ~ 4번째 바구니의 순서를 역순으로 만든다.
    // [2, 1, 3, 4, 5] -> [2, 1, 4, 3, 5]
    // 3) 1번째 ~ 4번째 바구니의 순서를 역순으로 만든다.
    // [2, 1, 4, 3, 5] -> [3, 4, 1, 2, 5]
    // 4) 2번째 바구니의 순서를 역순으로 만든다.
    // [3, 4, 1, 2, 5] -> [3, 4, 2, 1, 5]

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    // 배열 초기화
    int[] basket = new int[N];
    for(int i = 0; i < N; i++) {
      basket[i] = i + 1;
    }

    for (int i = 0; i < M; i++) {
      // 입력 처리
      int start = sc.nextInt();
      int end = sc.nextInt();
      // 역순 변환
      int left = start - 1;
      int right = end - 1;
      while (left < right) {
        int temp = basket[left];
        basket[left] = basket[right];
        basket[right] = temp;
        left++;
        right--;
      }
    }
    // 결과 출력
    for (int b: basket) {
      System.out.print(b + " ");
    }

    sc.close();
  }
}