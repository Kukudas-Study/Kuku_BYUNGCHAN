import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // input: 
    // N, M: 각각 행렬의 행과 열 크기
    // 두 행렬 A, B
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] A = new int[N][M];
    int[][] B = new int[N][M];
    int[][] C = new int[N][M];
    // N*M 행렬 생성
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        A[i][j] = sc.nextInt();    
      }
    }
    // N*M 행렬 생성
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        B[i][j] = sc.nextInt();
      }
    }

    // 두 행렬의 덧셈
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        C[i][j] =  A[i][j] + B[i][j];
      }
    }

    // 결과 출력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(C[i][j] + " ");
      }
      System.out.println();
    }

    sc.close();

    
  }
}