import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // N번째 줄에는 별 N개를 찍는 문제
    // 각 줄 별로, 공백과 별 차례대로 출력하는데,
    // 공백 개수 : N-(각 라인 번호)
    // 별 개수 : 각 라인 번호
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String output = "";
    for (int i = 1; i <= n; i++) {
      output += " ".repeat(n - i);
      output += "*".repeat(i);
      output += "\n";
    }

    System.out.println(output);

    sc.close();
  }
}