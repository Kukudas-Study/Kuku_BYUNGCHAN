import java.util.Scanner;

public class 달팽이 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int num = sc.nextInt();
    int[][] board = new int[N][N];

    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {1, 1, 1, 0, 0, 1, 1, 1};

    // 가장 중심부에 1 위치.
    board[N/2][N/2] = 1;

    // 어디서부터 접근해야 할 지 감이 잡히지 않음...

    sc.close();


  }
}
