import java.util.Scanner;

public class 나머지 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 배열 선언 및 초기화
    int[] numArr = new int[10];
    for (int i = 0; i < numArr.length; i++) {
      numArr[i] = sc.nextInt();
    }

    int[] remainderArr = new int[42];
    // 각 요소를 42로 나눈 나머지를 구한 뒤 각 인덱스에 해당하는 값을 1 증가시킨다.
    for (int i = 0; i < numArr.length; i++) {
      remainderArr[numArr[i] % 42]++;
    }

    int cnt = 0;
    // 값이 0인 요소를 제외한 개수를 카운트한다.
    for (int i = 0; i < remainderArr.length; i++) {
      if (remainderArr[i] != 0) {
        cnt++;
      }
    }

    System.out.println(cnt);

    sc.close();
  }
}