class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int index = 0; // numbers 값을 가져올 때 사용할 인덱스 번호
        
        // k 번째로 공을 던지는 사람을 구하려고 함.
        // 첫 번째로 공을 던지는 사람은 index: 0 으로 정해져 있음.
        for (int i = 1; i < k; i++) {
            index += 2;
        }
        // index 값이 배열의 길이보다 커지는 것을 방지하기 위해 배열의 크기로 나눠 index 는 항상 배열의 길이보다 작음.
        index %= numbers.length;
        // 공을 던지는 사람의 번호 획득
        answer = numbers[index];
        return answer;
    }
}