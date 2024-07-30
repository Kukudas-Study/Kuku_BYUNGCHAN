import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            // 공백("") 기준 문자열 split
            // 참고) StringTokenizer 는 공백("") 기준 문자열 split 불가
            String[] targets = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            boolean check = true;
            for (String target : targets) {
                if (target.equals("(")) {
                    stack.push(target);
                } else if (target.equals(")")) {
                    if (stack.size() > 0 && stack.peek().equals("(")) {
                        stack.pop();
                        continue;
                    }
                    // ")" 의 검사 대상인 "(" 을 찾으려고 하는데 스택 내에 아무런 요소가 없다면,
                    if (stack.size() == 0) {
                        check = false;
                        sb.append("NO").append("\n");
                        break;
                    }
                }
            }

            // check 가 true 인 경우는 모든 요소 검사가 정상적으로 다 이뤄졌을 때,
            if (check) {
                if (stack.size() == 0) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}