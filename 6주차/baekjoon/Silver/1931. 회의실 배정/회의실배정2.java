import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 회의 리스트를 가져옴
        List<List<Integer>> meetings = parseMeetings(br, N);

        // 최대 회의 개수 계산
        int maxMeetins = getMaxMeetings(meetings);

        // 결과 출력
        System.out.println(maxMeetins);
    }

    // 사용자 입력값을 파싱하여 List<List<Integer>> 형태로 반환하는 메소드
    private static List<List<Integer>> parseMeetings(BufferedReader br, int commandCnt) throws IOException {
        List<List<Integer>> meetings = new ArrayList<>();
        StringTokenizer st;

        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            List<Integer> meeting = new ArrayList<>();
            meeting.add(Integer.valueOf(st.nextToken()));
            meeting.add(Integer.valueOf(st.nextToken()));
            meetings.add(meeting);
        }
        return meetings;
    }

    // 회의 정렬
    private static void sortMeetings(List<List<Integer>> meetings) {
        // 회의 개수가 최대값이 되기 위해서는,
        // 회의가 일찍 끝나야 더 많은 회의를 할 수 있다.
        // 종료 시간 기준 오름차순 정렬:
        // 종료 시간이 빠를수록 우선적으로 정렬합니다.
        // 종료 시간이 같은 경우, 시작 시간 기준 오름차순 정렬:
        // 종료 시간이 동일한 회의들 사이에서는 시작 시간이 이른 순서로 정렬.
        meetings.sort((m1, m2) -> {
            if (m1.get(1) != m2.get(1)) {
                return Integer.compare(m1.get(1), m2.get(1));
            } else {
                return Integer.compare(m1.get(0), m2.get(0));
            }
        });
    }

    // 최대 회의 개수 계산
    private static int getMaxMeetings(List<List<Integer>> meetings) {
        // 회의 정렬
        sortMeetings(meetings);
        // 최대 회의 개수 계산
        return calculateMaxMeetings(meetings);
    }

    // 최대 회의 개수를 계산하는 메소드
    private static int calculateMaxMeetings(List<List<Integer>> meetings) {
        int cnt = 0;
        int lastEndTime = 0;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).get(0) >= lastEndTime) {
                cnt++;
                lastEndTime = meetings.get(i).get(1);
            }
        }
        return cnt;
    }
}
