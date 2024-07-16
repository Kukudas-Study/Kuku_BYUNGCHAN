import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // input : 소문자로만 이뤄진 단어 
    // ex) "level"
    // output : 0 or 1
    // 팰린드롬이면 1, 아니면 0을 출력
    // 팰린드롬 : 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어

    // 1. 입력받기
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    int result = 0;
    // 2. 팰린드롬인지 확인하기
    if (isPalindrome(word)) {
      result = 1;
    }
    // 3. 결과 출력
    System.out.println(result);

    sc.close();
  }

  private static boolean isPalindrome(String word) {
    int firstIdx = 0;
    int endIdx = word.length() - 1;

    while (firstIdx < endIdx) {
      if (word.charAt(firstIdx) != word.charAt(endIdx))
        return false;
      firstIdx++;
      endIdx--;
    }
    return true;
  }
}