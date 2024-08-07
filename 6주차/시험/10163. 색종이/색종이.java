import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        List<List<Integer>> rectangles = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            List<Integer> rectangle = new ArrayList<>();
            while (st.hasMoreTokens()) {
                rectangle.add(Integer.parseInt(st.nextToken()));
            }
            rectangles.add(rectangle);
        }

        int[][] board = new int[1001][1001];
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rectangles.size(); i++) {
            List<Integer> rectangle = rectangles.get(i);
            int startX = rectangle.get(0);
            int startY = rectangle.get(1);
            int width = rectangle.get(2);
            int height = rectangle.get(3);

            for (int x = startX; x <= startX + width - 1; x++) {
                if (minX > x)
                    minX = x;
                if (x > maxX)
                    maxX = x;
                for (int y = startY; y <= startY + height - 1; y++) {
                    if (minY > y)
                        minY = y;
                    if (y > maxY)
                        maxY = y;
                    board[x][y] = i + 1;
                }
            }
        }

        for (int i = 0; i < rectangles.size(); i++) {
            int cnt = 0;
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++) {
                    if (board[x][y] == i + 1)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }

    }

}
