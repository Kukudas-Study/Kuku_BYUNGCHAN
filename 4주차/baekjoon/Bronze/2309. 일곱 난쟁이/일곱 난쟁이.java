import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] numArr = new int[9];
        try {
            for (int i=0; i<9; i++) {
                // br.readLine() 은 IOException 예외 발생 가능성 있음.
                numArr[i] = Integer.parseInt(br.readLine());
            }
            
            int sum = 0;
            for (int i=0; i<9; i++) {
                sum += numArr[i];
            }
        
            // 9명의 키의 합에서 2명의 키를 뺀 값이 100인 경우 오름차순 정렬 후 결과 출력
            for (int i=0; i<8; i++) {
                for (int j=i+1; j<9; j++) {
                    if (sum - numArr[i] - numArr[j] == 100) {
                        numArr[i] = 0;
                        numArr[j] = 0;
                        Arrays.sort(numArr);
                    
                        for (int k=2; k<9; k++) {
                            System.out.println(numArr[k]);
                        }
                        return;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}