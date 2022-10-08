package BOJ;

import java.io.*;
import java.util.*;

public class BOJ13023_ABCDE {
	static int N, M, max = 4;
	static List<ArrayList<Integer>> friends = new ArrayList<>();
	static boolean[] v;
	static boolean isDone;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 외부 ArrayList 틀 생성
		for (int i = 0; i < N; i++) {
			friends.add(new ArrayList<>());
		}
		
		// 친구관계 설정
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			friends.get(from).add(to);
			friends.get(to).add(from);
		}
		
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			dfs(i, 0);
			if (isDone) break; // 탐색 도중 주어진 조건을 만족시킬 경우 바로 종료
		}
		// 조건을 만족시키면 1, 아니면 0 출력
		System.out.println(isDone ? 1 : 0);
	}
	
	static void dfs(int start, int cnt) {
		if (cnt == 4) { // 주어진 조건을 만족시킬 경우 종료
			isDone = true;
			return;
		}
		
		v[start] = true; // 현재 지점 방문 완료
		for (int i : friends.get(start)) {
			if (isDone) return; // 탐색 도중 주어진 조건을 만족시킬 경우 바로 종료
			if (!v[i]) dfs(i, cnt+1); // 아직 방문하지 않으면서 친구관계인 경우 DFS 탐색
		}
		v[start] = false; // Cycle인 경우도 있기 때문에 해당 지점을 다시 초기화
	}

}
