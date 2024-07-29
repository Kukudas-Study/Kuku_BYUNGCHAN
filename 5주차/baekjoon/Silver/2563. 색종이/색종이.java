import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 100 * 100 정사각형 2차원 배열로 선언 및 초기화
        boolean[][] whitePaper = new boolean[101][101];

        int area = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int dx = Integer.parseInt(st.nextToken()); // 좌측 아래쪽 꼭짓점 x 좌표
            int dy = Integer.parseInt(st.nextToken()); // 좌측 아래쪽 꼭짓점 y 좌표

            // 좌측 아래쪽 꼭짓점 기준 길이가 10인 정사각형의 영역 차지
            for (int x = dx; x < dx + 10; x++) {
                for (int y = dy; y < dy + 10; y++) {
                    // true 값으로 초기화된 곳은 이미 다른 정사각형이 차지하고 있다는 뜻.
                    if (whitePaper[x][y] == true)
                        continue;
                    whitePaper[x][y] = true;
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}
