import java.util.Scanner;

public class 분해합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int answer = 0;

    // 생성자는 입력받은 값인 N보다 작기 때문에 탐색 범위는 N보다 작은 경우에만 해당
    for (int i = 1; i < N; i++) {
      int sum = 0;
      sum += i;
      // 각 자릿수 합 계산
      for (char c : String.valueOf(i).toCharArray()) {
        sum += c - '0';
      }
      // N의 생성자가 존재하는 경우,
      if (sum == N) {
        answer = i;
        break;
      }
    }

    // 결과 출력
    System.out.println(answer);

    sc.close();
  }
}