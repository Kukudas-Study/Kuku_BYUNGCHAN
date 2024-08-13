import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int n = 0; n < commands.length; n++) {
            int[] command = commands[n];
            // array의 i번째부터 j번째 숫자까지
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2] - 1;
            
            int[] slicedArr = getSlicedArr(array, i, j);
            Arrays.sort(slicedArr);
            
            answer[n] = slicedArr[k];
        }
        return answer;
    }
    
    public static int[] getSlicedArr(int[] array, int start, int end) {
        int[] slicedArr = new int[end - start];
        
        for (int i = 0; i < slicedArr.length; i++) {
            slicedArr[i] = array[start + i];
        }
        
        return slicedArr;
    }
}
