import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // input: x, y
    // 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 
    // 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)
    // output: n
    // n 은 n 사분면을 의미함.
    // n은 1, 2, 3, 4

    // x, y 입력받기
    int x = sc.nextInt();
    int y = sc.nextInt();

    // 각각 x, y 가 양수냐 음수냐에 따라 몇 사분면에 있는 좌표인지 결정된다.
    // x > 0, y > 0 : 1사분면
    // x < 0, y > 0 : 2사분면
    // x < 0, y < 0 : 3사분면
    // x > 0, y < 0 : 4사분면
    int n = -1;
    if (x > 0 && y > 0) n = 1;
    if (x < 0 && y > 0) n = 2;
    if (x < 0 && y < 0) n = 3;
    if (x > 0 && y < 0) n = 4;

    // 결과 출력
    System.out.println(n);

    sc.close();

      
  }
}