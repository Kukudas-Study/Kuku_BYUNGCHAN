import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 5개의 단어, 최대 15개의 알파벳으로 이뤄짐.
        // 5*15 크기를 가지는 2차원 배열 선언 및 초기화
        List<List<Character>> words = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            List<Character> wordArr = new ArrayList<Character>();

            for (int j = 0; j < word.length(); j++) {
                wordArr.add(word.charAt(j));
            }
            words.add(wordArr);
        }

        // 위에서 아래로 세로로 글자들 읽기
        for (int i = 0; i < 15; i++) {
            int nullCnt = 0;
            for (int j = 0; j < 5; j++) {
                // 길이를 초과한 인덱스에 접근해 읽을 수 있는 글자가 더 이상 존재하지 않는 경우,
                if (words.get(j) != null && i >= words.get(j).size()) {
                    nullCnt++;
                    continue;
                }
                sb.append(words.get(j).get(i));
            }
            // 다섯 개의 단어에 대해 모두 읽을 수 있는 글자 존재하지 않는 경우,
            if (nullCnt == 5) {
                break;
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}