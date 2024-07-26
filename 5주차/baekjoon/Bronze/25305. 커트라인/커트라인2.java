import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class 커트라인2 {
    public static void main(String[] args) throws IOException, NullPointerException, NoSuchElementException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 응시자 수
        int k = Integer.parseInt(st.nextToken()); // 상 받는 사람의 수
        st = new StringTokenizer(br.readLine());

        // 응시자 점수 배열 선언 및 초기화
        Integer[] scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.valueOf(st.nextToken());
        }

        // 응시자 점수 배열 내림차수 정렬
        // scores 내림차순 정렬
        // 주의! Arrays.sort 의 대상은 int[] X, Integer[] O
        Arrays.sort(scores, Collections.reverseOrder());
        // 결과 출력
        // 상 받는 k 명의 커트라인 점수인 k-1 번째 점수 저장
        int awardLimitScore = scores[k - 1];
        System.out.println(awardLimitScore);
    }
}
