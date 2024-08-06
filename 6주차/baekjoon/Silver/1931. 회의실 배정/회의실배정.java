import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // parseMeetings 메소드를 호출하여 회의 리스트를 가져옴
        List<Map<String, Integer>> meetings = parseMeetings(br, N);

        // 최대 회의 개수 계산
        int maxMeetings = getMaxMeetings(meetings);

        // 결과 출력
        System.out.println(maxMeetings);
    }

    // 사용자 입력값을 파싱하여 List<Map<String, Integer>> 형태로 반환하는 메소드
    private static List<Map<String, Integer>> parseMeetings(BufferedReader br, int commandCnt) throws IOException {
        List<Map<String, Integer>> meetings = new ArrayList<>();
        StringTokenizer st;

        while (commandCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Map<String, Integer> meeting = new HashMap<>();
            meeting.put("start", start);
            meeting.put("end", end);

            meetings.add(meeting);
        }

        return meetings;
    }

    // 최대 회의 개수 계산
    private static int getMaxMeetings(List<Map<String, Integer>> meetings) {
        // 회의 정렬
        // 회의가 일찍 끝나야, 최대한 많은 회의를 할 수 있다.
        // end 기준 오름차순 정렬, end 값이 같다면 start 기준 오름차순 정렬
        // Collections.sort(meetings, new Comparator<Map<String, Integer>>() {
        // @Override
        // public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
        // int start1 = o1.get("start");
        // int end1 = o1.get("end");
        // int start2 = o2.get("start");
        // int end2 = o2.get("end");

        // int endComparison = Integer.compare(end1, end2);

        // // end 값이 동일하지 않은 경우,
        // if (endComparison != 0) {
        // return endComparison;
        // }

        // // end 값이 같다면 start 값 비교
        // return Integer.compare(start1, start2);
        // }
        // });
        meetings.sort((o1, o2) -> {
            if (o1.get("end") != o2.get("end")) {
                return Integer.compare(o1.get("end"), o2.get("end"));
            } else {
                return Integer.compare(o1.get("start"), o2.get("start"));
            }
        });

        // 그리디 선택
        // 현재 회의의 종료 시간보다 다음 회의의 시작 시간이 더 늦은 경우, 그 회의를 선택
        int cnt = 1, i = 0;
        int lastEndTime = meetings.get(i).get("end");
        while (i < meetings.size() - 1) {
            if (meetings.get(i + 1).get("start") >= lastEndTime) {
                cnt++;
                lastEndTime = meetings.get(i + 1).get("end");
            }
            i++;
        }

        return cnt;
    }
}