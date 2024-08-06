import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 숫자야구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 입력: 조건의 수
        int N = Integer.parseInt(br.readLine());

        // 조건을 파싱하여 리스트로 저장
        List<List<String>> conditions = parseConditions(br, N);

        // 111 ~ 999 범위의 IntStream 생성
        IntStream numStream = IntStream.rangeClosed(111, 999);

        // 각 자리 숫자가 모두 동일한 경우 삭제
        List<Integer> filteredNums = numStream
                .filter(num -> hasNotZeroDigits(num)) // 숫자에 0이 포함되지 않은지 필터링
                .filter(num -> hasDistinctDigits(num)) // 각 자리 숫자가 모두 동일하지 않은지 필터링
                .boxed()
                .collect(Collectors.toList());

        List<Integer> expectedNums = new ArrayList<>();

        // 필터링된 숫자들을 조건과 비교하여 유효한 숫자 찾기
        for (int i = 0; i < filteredNums.size(); i++) {
            int targetNum = filteredNums.get(i);

            int passCnt = 0; // 조건을 만족한 개수

            // 모든 조건을 체크
            for (List<String> condition : conditions) {
                int inputNum = Integer.parseInt(condition.get(0));
                int expectedStrikeCnt = Integer.parseInt(condition.get(1));
                int expectedBallCnt = Integer.parseInt(condition.get(2));

                // 스트라이크와 볼의 개수 계산
                int strikeCnt = countStrike(targetNum, inputNum);
                int ballCnt = countBall(targetNum, inputNum);

                if ((strikeCnt == expectedStrikeCnt && ballCnt == expectedBallCnt)) {
                    passCnt++;
                }
            }

            // 모든 조건을 만족하는 숫자를 expectedNums에 추가
            if (passCnt == conditions.size()) {
                expectedNums.add(targetNum);
            }
        }

        System.out.println(expectedNums.size());
    }

    // 볼 검사
    private static int countBall(int target, int input) {
        int ballCnt = 0;
        // 각 자리의 숫자를 분리
        int tHundreds = target / 100;
        int tTens = (target % 100) / 10;
        int tOnes = target % 10;
        int iptHundreds = input / 100;
        int iptTens = (input % 100) / 10;
        int iptOnes = input % 10;

        // 각 자리의 숫자가 서로 다른 위치에 존재하면 볼 수 증가
        if (tHundreds == iptTens || tHundreds == iptOnes)
            ballCnt++;
        if (tTens == iptHundreds || tTens == iptOnes)
            ballCnt++;
        if (tOnes == iptHundreds || tOnes == iptTens)
            ballCnt++;
        return ballCnt;
    }

    // 스트라이크 검사
    private static int countStrike(int target, int input) {
        int strikeCnt = 0;
        // 각 자리의 숫자를 분리
        int tHundreds = target / 100;
        int tTens = (target % 100) / 10;
        int tOnes = target % 10;
        int iptHundreds = input / 100;
        int iptTens = (input % 100) / 10;
        int iptOnes = input % 10;

        // 자리별 숫자가 일치하면 스트라이크 수 증가
        if (tHundreds == iptHundreds)
            strikeCnt++;
        if (tTens == iptTens)
            strikeCnt++;
        if (tOnes == iptOnes)
            strikeCnt++;

        return strikeCnt;
    }

    // 각 자리 숫자에 0 포함 여부 확인
    private static boolean hasNotZeroDigits(int number) {
        int tens = (number % 100) / 10;
        int ones = number % 10;
        return !(tens == 0 || ones == 0);
    }

    // 각 자리 숫자가 모두 동일한지 확인
    private static boolean hasDistinctDigits(int number) {
        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int ones = number % 10;

        // 모든 자리 숫자가 동일하거나 두 자리 이상이 동일한 경우 false 반환
        return !((hundreds == tens && tens == ones) || (hundreds == tens || tens == ones || hundreds == ones));
    }

    // 입력으로 주어진 조건들을 파싱하여 리스트로 반환
    private static List<List<String>> parseConditions(BufferedReader br, int commandCnt) throws IOException {
        List<List<String>> conditions = new ArrayList<>();
        StringTokenizer st = null;

        // 각 조건을 읽어 리스트에 저장
        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            List<String> condition = new ArrayList<>();
            while (st.hasMoreTokens()) {
                condition.add(st.nextToken());
            }
            conditions.add(condition);
        }
        return conditions;
    }

}
