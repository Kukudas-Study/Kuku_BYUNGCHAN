import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int money = Integer.parseInt(br.readLine());
            if (stack.size() != 0 && money == 0) {
                stack.pop();
            } else {
                stack.push(money);
            }
        }

        // stack 루프해 요소의 합 구하기
        int sum = calculateStackSum(stack);
        System.out.println(sum);
    }

    // 스택의 모든 요소의 합을 계산하는 메소드
    public static int calculateStackSum(Stack<Integer> stack) {
        int sum = 0;

        // 스택이 비어있지 않을 때까지 반복
        while (!stack.isEmpty()) {
            // 스택에서 요소를 꺼내어 합계에 더하기
            sum += stack.pop();
        }

        return sum;
    }
}