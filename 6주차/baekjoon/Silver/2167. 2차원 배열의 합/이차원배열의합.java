import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 이차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력값으로부터 2차원 배열 선언 및 초기화
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int lastX = Integer.parseInt(st.nextToken());
            int lastY = Integer.parseInt(st.nextToken());

            // 입력받은 좌표를 기준으로 배열의 합 구하기
            // 단, 좌표값은 1을 기준으로 하는 반면 배열은 0이 기준이기 때문에
            // 입력받은 좌표값을 각각 1씩 빼준 값을 기준으로 배열의 요소에 접근 필요
            int sum = 0;
            for (int x = firstX - 1; x <= lastX - 1; x++) {
                for (int y = firstY - 1; y <= lastY - 1; y++) {
                    sum += arr[x][y];
                }
            }
            bw.write(sum + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}