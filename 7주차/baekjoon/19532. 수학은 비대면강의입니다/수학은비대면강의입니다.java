import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {
        // int[][] arr = new int[2][3];

        // arr = [[1, 3, -1], [4, 1, 7]];

        // [[4, 12, -4], [4, 1, 7]]

        // x1 = arr[0][0], y1 = arr[0][1], r1 = arr[0][2];
        // x2 = arr[1][0], y2 = arr[1][1], r2 = arr[1][2];

        // 케이스를 나누기.
        // i) x1 > x2
        // ii) x1 == x2
        // iii) x1 < x2

        // i) x1 > x2 에 대하여 서브 케이스 나누기.
        // i) x1 % x2 == 0 (x1:3, x2:1 혹은 x1: 6, x2: 3 인 케이스)
        // x2, y2, r2 에 대해 각각 (x1 / x2) 을 곱한다.
        // ansY = (r1 - r2) / (y1 - y2) 이다.
        // ansX = (r1 - y1*ansY) / x1 이다.
        // ii) x1 % x2 != 0 (x1:3, x2:2 인 케이스)
        // x1, y1, r1 에 대해 각각 x2 를 곱한다.
        // x2, y2, r2 에 대해 각각 x1 을 곱한다.
        // ansY = (r1 - r2) / (y1 - y2) 이다.
        // ansX = (r1 - y1*ansY) / x1 이다.
        // ii) x1 < x2 에 대하여 서브 케이스 나누기
        // i) x2 % x1 == 0 (x2:3, x1:1 혹은 x2: 6, x1: 3 인 케이스)
        // x1, y1, r1 에 대해 각각 (x2 / x1) 을 곱한다.
        // ansY = (r1 - r2) / (y1 - y2) 이다.
        // ansX = (r1 - y1*ansY) / x1 이다.
        // ii) x2 % x1 != 0 (x2:3, x1:2 인 케이스)
        // x1, y1, r1 에 대해 각각 x2 를 곱한다.
        // x2, y2, r2 에 대해 각각 x1 을 곱한다.
        // ansY = (r1 - r2) / (y1 - y2) 이다.
        // ansX = (r1 - y1*ansY) / x1 이다.
        // iii) x1 == x2 인 경우(2x + 3y = 5, 2x + 5y = 3)
        // ansY = (r1 - r2) / (y1 - y2)
        // ansX = (r1 - y1*ansY) / x1

        // a == b && b == d && d == e => (0, 0)
        // a == 0 && b == 0 => (0, 0)
        // d == 0 && e == 0 => (0, 0)
        // a == 0 && d == 0 => (0, 0)
        // b == 0 && e == 0 => (0, 0)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] nums = new int[2][3];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x1 = nums[0][0], y1 = nums[0][1], r1 = nums[0][2];
        int x2 = nums[1][0], y2 = nums[1][1], r2 = nums[1][2];

        int ansX = 0, ansY = 0;

        if ((x1 == y1 && y1 == x2 && x2 == y2) || (x1 == 0 && y1 == 0) || (x2 == 0 && y2 == 0) || (x1 == 0 && x2 == 0)
                || (y1 == 0 && y2 == 0)) {
            ansX = 0;
            ansY = 0;
        } else if (x1 > x2) {
            int x1DivX2 = x1 / x2;
            if (x2 == 0) {
                ansY = r2 / y2;
                ansX = (r1 - y1 * ansY) / x1;
            } else if (x1 % x2 == 0) {
                ansY = (r1 - r2 * (x1DivX2)) / (y1 - y2 * x1DivX2);
                ansX = (r1 - y1 * ansY) / x1;
            } else {
                ansY = (r1 * x2 - r2 * x1) / (y1 * x2 - y2 * x1);
                ansX = (r1 - (y1 * ansY)) / x1;
            }
        } else if (x1 < x2) {
            int x2DivX1 = x2 / x1;
            if (x1 == 0) {
                ansY = r1 / x1;
                ansX = (r2 - y2 * ansY) / x2;
            } else if (x2 % x1 == 0) {
                ansY = (r1 * x2DivX1 - r2) / (y1 * x2DivX1 - y2);
                ansX = (r1 - y1 * ansY) / x1;
            } else {
                ansY = (r1 * x2 - r2 * x1) / (y1 * x2 - y2 * x1);
                ansX = (r1 - y1 * ansY) / x1;
            }
        } else {
            ansY = (r1 - r2) / (y1 - y2);
            ansX = (r1 - y1 * ansY) / x1;
        }

        System.out.println(ansX + " " + ansY);
    }
}