import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Input: 
    // A (0 <= A <= 23) : 시
    // B (0 <= B <= 59) : 분
    // C (0 <= C <= 1000) : 요리하는 데 필요한 시간(분)

    // 1. 각각 주어진 입력값을 받아 정수로 변환한다.
    String[] currentDate = sc.nextLine().split(" ");
    int A = Integer.parseInt(currentDate[0]);
    int B = Integer.parseInt(currentDate[1]);
    int C = Integer.parseInt(sc.nextLine());
    
    // 2. 요리하는 데 필요한 시간을 각각 시간과 분 단위로 변환한다.
    int cookHours = C / 60;
    int cookMinutes = C % 60;
    
    // 3. 요리가 끝나는 시각 중 분 구하기
    // B 에 요리하는 데 필요한 시간 중 분을 더한다.
    // 만약 바로 위 값이 60을 넘는다면,
    // 요리가 끝나는 시각 중 시간에 이 값을 60으로 나눈 몫을 더한다.
    // 그리고 분은 이 값을 60으로 나눈 나머지를 더한다.
    int totalMinutes = B + cookMinutes;
    if (totalMinutes > 59) {
      cookHours += totalMinutes / 60;
      totalMinutes %= 60;
    }
    
    // 4. 요리가 끝나는 시각 중 시간 구하기
    // A 에 요리하는 데 필요한 시간 중 시간을 더한다.
    // 만약 바로 위 값이 24를 넘는다면,
    // 시간은 이 값을 24로 나눈 나머지이다.
    int totalHours = A + cookHours;
    if (totalHours > 23) {
      totalHours %= 24;
    }

    // 5. 결과 출력
    System.out.println(totalHours + " " + totalMinutes);

    sc.close();
  }
}