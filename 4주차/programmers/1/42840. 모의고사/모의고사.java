import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자 별 정답 개수 count
        int[] score = new int[3];
        // 각 수포자들의 점수 패턴
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        // 수포자 점수 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) score[0]++;
            if (answers[i] == second[i % 8]) score[1]++;
            if (answers[i] == third[i % 10]) score[2]++;
        }
        
        // 최대 점수 구하기
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        // 최대 점수를 가진 수포자 리스트 생성
        ArrayList<Integer> maxScorePersonArr = new ArrayList<>();
        for (int i=0; i<score.length; i++) {
            if (maxScore == score[i]) {
                maxScorePersonArr.add(i+1);
            }
        }
        
        // ArrayList 를 고정 길이의 Array 로 변환
        int[] answer = new int[maxScorePersonArr.size()];
        for (int i=0; i<maxScorePersonArr.size(); i++) {
            answer[i] = maxScorePersonArr.get(i);
        }
        
        return answer;
    }
}