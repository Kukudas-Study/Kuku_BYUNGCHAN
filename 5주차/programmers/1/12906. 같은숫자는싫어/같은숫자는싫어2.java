import java.util.*;

public class 같은숫자는싫어2 {
    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 3, 3, 0, 1, 1 };
        int[] answer1 = solution(arr1);

        int[] arr2 = { 4, 4, 4, 3, 3 };
        int[] answer2 = solution(arr2);

        System.out.print("answer1 : ");
        for (int num : answer1) {
            System.out.print(num + " ");
        }
        System.out.print("answer2 : ");
        for (int num : answer2) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            if (stack.size() == 0 || stack.peek() != num) {
                stack.add(num);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}
