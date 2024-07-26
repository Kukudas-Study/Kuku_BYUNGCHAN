import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String numStr = br.readLine();
        // numStr.chars() : IntStream of char type values
        // sorted() 내부 콜백 함수에서 각 매개변수 타입이 int 여야 비교 가능?
        Stream<Character> charStream = numStr.chars().mapToObj(i -> (char) i);
        // 내림차순 정렬
        charStream = charStream.sorted((n1, n2) -> n2.compareTo(n1));
        // Stream<Character> to List<Character>
        List<Character> charList = charStream.collect(Collectors.toList());

        for (Character c : charList) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
