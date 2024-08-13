import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 깊이우선탐색 {
  // 노드 방문 순서 추적
	static int cnt;
  // 노드를 방문한 순서 저장 
	static int[] checked;
  // 그래프를 인접 리스트로 표현
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드의 수
		int m = Integer.parseInt(st.nextToken()); // 간선의 수
		int r = Integer.parseInt(st.nextToken()); // 시작 노드

    // 노드 방문 순서 저장할 배열 초기화(1부터 시작한다고 가정해 크기를 n+1 로 설정)
		checked = new int[n + 1];

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>()); // 각 노드에 대한 인접 리스트 초기화
		}

		// 그래프에 간선 정보 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); // 간선의 시작 노드
			int v = Integer.parseInt(st.nextToken()); // 간선의 끝 노드

			graph.get(u).add(v); // 시작 노드의 리스트에 끝 노드 추가
			graph.get(v).add(u); // 끝 노드의 리스트에 시작 노드 추가(간선은 양방향임)
		}

    // 각 노드의 인접 리스트를 오름차순 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		cnt = 1; // 방문 순서를 1로 초기화
		dfs(r);

		for (int i = 1; i < checked.length; i++) {
			sb.append(checked[i]).append("\n");
		}
		System.out.println(sb);

	}

  // DFS 수행
	private static void dfs(int node) {

		checked[node] = cnt;

		for (int i = 0; i < graph.get(node).size(); i++) {
			int newNode = graph.get(node).get(i); // 인접 노드
			if (checked[newNode] == 0) { // 아직 방문하지 않은 노드라면,
				cnt++; // 방문 순서 증가
				dfs(newNode); // 해당 노드에 대해 DFS 를 재귀적으로 수행
			}
		}

	}
}
