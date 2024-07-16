import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // input: 연도
    // 1 <= 연도 && 연도 <= 4000
    // output: 윤년이면 1, 아니면 0
    int year = sc.nextInt();

    // 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
    // 윤년일 조건
    // i) 연도가 4의 배수이면서 100의 배수가 아니면서 400의 배수인 경우
    // ii) 연도가 4의 배수이면서 100의 배수가 아니면서 400의 배수가 아닌 경우
    // ii) 연도가 4의 배수이면서 100의 배수이면서 400의 배수인 경우
    int answer = 0;
    // year % 4 == 0 && year % 100 != 0
    // year % 4 == 0 && year % 100 == 0 && year % 400 == 0
    if (
      (year % 4 == 0 && year % 100 != 0) ||
      (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
    ) {
      answer = 1;
    }

    System.out.println(answer);
    
    sc.close();
  }
}