import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 피보나치수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int firstIdx = 0, secondIdx = 1;
        List<Integer> numArr = new ArrayList<Integer>();
        numArr.add(0);
        numArr.add(1);

        pibonacci(numArr, firstIdx, secondIdx, n);

        System.out.println(numArr.get(n));
    }

    public static List<Integer> pibonacci(List<Integer> arr, int firstIdx, int secondIdx, int n) {
        if (secondIdx == n)
            return arr;
        else {
            int nextVal = arr.get(firstIdx) + arr.get(secondIdx);
            arr.add(nextVal);

            return pibonacci(arr, firstIdx + 1, secondIdx + 1, n);
        }
    }
}