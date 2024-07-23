import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = null;
        int answerIdx = 0;
        // n의 값에 따라 슬라이싱 동작이 달라진다.
        // n의 값에 따라 슬라이싱된 리스트의 길이가 달라진다.
        // slicer에 주어진 시작 인덱스, 종료 인덱스를 활용해 슬라이싱된 리스트의 길이를 구하는 게 관건이라고 생각함 
        if (n == 1) {
            answer = new int[slicer[1] + 1];
            for (int i = 0; i < slicer[1] + 1; i++) {
                answer[answerIdx] = num_list[i];
                answerIdx++;
            }
        }
        else if (n == 2) {
            answer = new int[num_list.length - slicer[0]];
            for (int i = slicer[0]; i < num_list.length; i++) {
                answer[answerIdx] = num_list[i];
                answerIdx++;
            }
        }
        else if (n == 3) {
            answer = new int[slicer[1] + 1 - slicer[0]];
            for (int i = slicer[0]; i < slicer[1] + 1; i++) {
                answer[answerIdx] = num_list[i];
                answerIdx++;
            }
        }
        else if (n == 4) {
            answer = new int[(slicer[1] - slicer[0]) / 2 + 1];
            for (int i = slicer[0]; i < slicer[1] + 1; i += slicer[2]) {
                answer[answerIdx] = num_list[i];
                answerIdx++;
            }
        }
        return answer;
    }
}