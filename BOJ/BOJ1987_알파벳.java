package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1987_알파벳 {
	static int R, C, cnt;
	static char[][] board;
	static boolean[] v;
	
	// 상-하-좌-우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		v = new boolean[26]; // 알파벳 26개
		
		// 보드 초기화
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		cnt = Integer.MIN_VALUE; // 말이 지날 수 있는 최대 칸수
		dfs(0, 0, 1);
		System.out.println(cnt);
	}
	
	static void dfs(int r, int c, int sum) {
		cnt = Integer.max(cnt, sum);
		
		// 현재 알파벳 방문 완료
		v[board[r][c] - 'A'] = true;
		
		// 4방탐색 시작
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 내에 있으면서 아직 한번도 방문하지 못한 알파벳일 경우
			if (nr >= 0 && nc >= 0 && nr < R && nc < C && !v[board[nr][nc] - 'A']) {
				dfs(nr, nc, sum+1); // DFS 호출
			}
		}
		
		// 다음 지점이 이미 방문했던 알파벳일 경우 현재 지점 방문 초기화
		// => 다음 방향으로의 탐색 가능
		v[board[r][c] - 'A'] = false;
	}
	
}
