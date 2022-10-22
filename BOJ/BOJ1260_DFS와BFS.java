package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static int N, M, V;
	static boolean[][] map;
	static boolean[] v; // 정점 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		V = Integer.parseInt(st.nextToken()); // 시작 정점 번호
		
		map = new boolean[N+1][N+1]; // 0 dummy

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 시작 정점과 끝 정점 연결
			map[start][end] = map[end][start] = true;
		}
		
		// 시작 정점 출력
		sb.append(V).append(" ");
		// 방문 배열 초기화
		v = new boolean[N+1]; // 0 dummy
		dfs(V); // DFS 시작
		
		// DFS 끝 => 줄바꿈 & 시작 정점 출력
		sb.append("\n").append(V).append(" ");
		// 방문 배열 초기화
		v = new boolean[N+1]; // 0 dummy
		bfs(V); // BFS 시작
		
		System.out.println(sb);
	}
	static void dfs(int start) {
		v[start] = true; // 현재 정점 방문 완료

		for (int i = 1; i <= N; i++) {
			if (!v[i] && map[start][i]) { // 아직 방문하지 않은 정점이면서 현재 정점과 연결된 정점일 경우
				v[i] = true; // 방문 완료
				sb.append(i).append(" ");
				dfs(i); // DFS 탐색 반복
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		v[start] = true; // 현재 정점 방문 완료
		q.add(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) { 
				if (!v[i] && map[cur][i]) { // 아직 방문하지 않은 정점이면서 현재 정점과 연결된 정점일 경우
					q.add(i); // 위의 조건을 만족하는 정점 정보 저장
					v[i] = true; // 방문 완료
					sb.append(i).append(" ");
				}
			}
		}
	}
}
