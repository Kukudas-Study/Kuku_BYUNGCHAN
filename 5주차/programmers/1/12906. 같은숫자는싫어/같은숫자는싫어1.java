import java.util.*;

public class 같은숫자는싫어1 {
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
        // Set 을 사용해 간단하게 구현하려고 했는데 순서를 보장하지 않아 적용 불가.
        // Array 를 사용하면 처음부터 크기를 정해줘야 하고, 처음에 모든 값이 0으로 초기화되기 때문에 적합하지 않다고 판단.
        List<Integer> rmDuplicatedNumList = new ArrayList<>();
        int cnt = 0;
        // arr[0]의 비교 대상이 존재하지 않아 바로 추가
        rmDuplicatedNumList.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int targetNum = arr[i];
            // targetNum 이 rmDuplicatedNumList 안에 존재하지 않는 경우에만,
            if (rmDuplicatedNumList.get(cnt) != targetNum) {
                rmDuplicatedNumList.add(targetNum);
                cnt++;
            }
        }

        // 리턴값은 Array 를 요구하기 때문에 ArrayList 를 Array 로 변환 필요
        int[] answer = new int[rmDuplicatedNumList.size()];
        for (int i = 0; i < answer.length; i++) {
            // 주의! Integer to int 변환 필요
            answer[i] = rmDuplicatedNumList.get(i).intValue();
        }

        return answer;
    }
}
