class Solution {
    public int solution(int order) {
        int answer = 0;
        // order 가 10보다 큰 경우와 작은 경우로 나눠서 생각
        if (order >= 10) {
            // 10보다 크면 각 자릿수 별로 분리해서 생각
            // 3, 6, 9 중의 숫자인지 확인
            // int -> String -> split(" ") 메소드 사용 가능
            String[] numArr = Integer.toString(order).split("");
            for (String numStr: numArr) {
                // 이 코드를 빼면 몇 개의 테스트 케이스 실패 왜?
                if (numStr.equals("0")) continue;
                // Integer.valueOf(String): String to Integer 변환
                if (Integer.valueOf(numStr) % 3 == 0) answer++;
            }
        }
        else {
            if (order % 3 == 0) answer++;
        }
        
        return answer;
    }
}