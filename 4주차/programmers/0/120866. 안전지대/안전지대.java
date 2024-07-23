import java.util.ArrayList;

class Solution {
    public int solution(int[][] board) {
        ArrayList<int[]> mine = new ArrayList<>();
        
        // 지뢰 주변 좌표값 8군데 지정
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        int answer = 0;
        
        // 지뢰 위치 값 찾기
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j] == 1) {
                    int[] temp = {i, j};
                    mine.add(temp);
                }
            }
        }
        
        for (int i=0; i<mine.size(); i++) {
            int x = mine.get(i)[0];
            int y = mine.get(i)[1];
            
            for (int j=0; j<8; j++) {
                // board 배열을 벗어나지 않은 곳에 대해서만,
                if (x+dx[j] >= 0 && y+dy[j] >= 0 && x+dx[j] <= board.length-1 && y+dy[j] <= board.length-1) {
                    board[x+dx[j]][y+dy[j]] = 2;
                }
            }
        }
        
        // 지뢰가 없는 지역 개수 count
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}