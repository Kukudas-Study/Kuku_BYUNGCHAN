import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean play = true;
        char[] board = br.readLine().toCharArray();

        int i = 0;
        while (i < board.length) {
            // AAAA 로 덮을 수 있는 조건
            if (board.length > (i + 3) && board[i] == 'X' && board[i + 1] == 'X' && board[i + 2] == 'X'
                    && board[i + 3] == 'X') {
                i += 4;
                sb.append("AAAA");
            }
            // BB 로 덮을 수 있는 조건
            else if (board.length > (i + 1) && (board[i] == 'X' && board[i + 1] == 'X')) {
                i += 2;
                sb.append("BB");
            } else if (board[i] == '.') {
                sb.append(".");
                i++;
            } else {
                play = false;
            }

            if (!play)
                break;
        }

        if (play) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}