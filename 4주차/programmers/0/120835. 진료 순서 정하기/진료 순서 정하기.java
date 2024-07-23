import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] descEmergency = Arrays.copyOf(emergency, emergency.length);
        // 내림차순 정렬
        // emergency: [3, 76, 24], descEmergency: [76, 24, 3]
        for (int i = 1; i < descEmergency.length; i++) {
            int key = descEmergency[i];
            int j = i - 1;
            while (j >= 0 && descEmergency[j] < key) {
                descEmergency[j+1] = descEmergency[j];
                j--;
            }
            descEmergency[j+1] = key;
        }
        
        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < descEmergency.length; j++) {
                if (descEmergency[j] == emergency[i]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}