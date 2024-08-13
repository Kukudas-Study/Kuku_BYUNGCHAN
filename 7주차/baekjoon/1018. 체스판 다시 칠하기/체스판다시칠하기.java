import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String[][] board = new String[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenzier(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = st.nextToken();
      }
    }


  }
}