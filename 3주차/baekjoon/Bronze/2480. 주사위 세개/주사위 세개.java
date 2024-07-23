import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] inputs = sc.nextLine().split(" ");
    int a = Integer.parseInt(inputs[0]);
    int b = Integer.parseInt(inputs[1]);
    int c = Integer.parseInt(inputs[2]);

    int reward = getReward(a, b, c);
    System.out.println(reward);
  }

  public static int getReward(int a, int b, int c) {
    // 상금
    int reward = 0;
    // 상금 조건
    // 같은 눈이 3개 나오면
    if (a == b && b == c) {
      reward = 10000 + a * 1000;
    }
    // 같은 눈이 2개만 나오는 경우
    // a, b 가 같지만 c 가 다른 경우, a, c 가 같지만 b 가 다른 경우
    else if ((a == b && a != c) || (a == c && a != b)) {
      reward = 1000 + a * 100;
    }
    // b, c 가 같지만 a 가 다른 경우
    else if ((b == c && b != a)) {
      reward = 1000 + b * 100;
    } else {
      reward = getMax(a, b, c) * 100;
    }

    return reward;
  }

  public static int getMax(int a, int b, int c) {
    return a > b && a > c ? a : b > c ? b : c;
  }
}