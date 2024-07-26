import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 커트라인 {
    public static void main(String[] args) throws IOException, NullPointerException, NoSuchElementException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 응시자 수
        int k = Integer.parseInt(st.nextToken()); // 상 받는 사람의 수

        st = new StringTokenizer(br.readLine());

        // 응시자 점수 배열 선언 및 초기화
        List<Integer> scores = new ArrayList<>();
        while (st.hasMoreTokens()) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        // 응시자 점수 배열 내림차수 정렬 후 상 받는 k 명의 커트라인 점수인 k-1 번째 점수 저장
        int awardLimitScore = scores.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList())
                .get(k - 1);
        System.out.println(awardLimitScore);
    }
}
