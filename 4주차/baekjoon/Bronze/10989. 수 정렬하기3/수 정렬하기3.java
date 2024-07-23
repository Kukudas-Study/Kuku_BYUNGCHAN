import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    // 배열 선언 및 초기화
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();    
    }

    // 오름차순 정렬
    // 인덱스 번호가 커질수록, 작은 수에서 큰 수로
    // 버블 정렬: 시간 초과
    // int i = 0;
    // while (i < N) {
    //   int j = i + 1;
    //   while (j < N) {
    //     if (arr[i] > arr[j]) {
    //       int temp = arr[i];
    //       arr[i] = arr[j];
    //       arr[j] = temp;
    //     }
    //     j++;
    //   }
    //   i++;
    // }

    // 삽입 정렬
    for (int i = 0; i < N; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
    
    // 결과 출력
    for (int num: arr) {
      System.out.println(num);
    }

    sc.close();
  }
}