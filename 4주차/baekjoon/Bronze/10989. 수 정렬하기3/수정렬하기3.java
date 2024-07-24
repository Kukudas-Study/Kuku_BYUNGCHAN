import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 수정렬하기3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 배열 선언 및 초기화
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] result = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    // Counting Sort(계수 정렬) 구현
    // 최대값 찾기
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
      if (num > max) {
        max = num;
      }
    }

    // array 의 value 값을 index 로 하는 counting 배열 값 1 증가
    int[] counting = new int[max + 1];
    for (int num : arr) {
      counting[num]++;
    }

    // 누적 합
    // 누적 합을 이용하면 정확히 해당 값이 몇 번째로 작은 요소인지를 알 수 있다.
    for (int i = 1; i < counting.length; i++) {
      counting[i] += counting[i - 1];
    }

    for (int i = N - 1; i >= 0; i--) {
      /*
       * i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤
       * counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
       */
      int targetNum = arr[i];
      int targetNumPosAfterAscSort = counting[targetNum] - 1;
      result[targetNumPosAfterAscSort] = targetNum;
      /*
       * counting 배열의 값을 감소시킴으로써 중복된 값도 올바르게 처리할 수 있다.
       * 예를 들어, 동일한 값을 가진 요소들이 여러 개 있을 때,
       * counting 배열을 이용하여 각 요소의 위치를 정확히 찾아 배치할 수 있다.
       */
      counting[targetNum]--;
    }

    // 결과값 출력
    for (int num : result) {
      bw.write(num + "\n");
    }

    bw.flush(); // 남아있는 데이터 모두 출력
    // 스트림 닫음
    bw.close();
    br.close();

  }
}