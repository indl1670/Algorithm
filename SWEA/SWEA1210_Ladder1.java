package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1210_Ladder1 {
	static final int S = 100;
	static int ans, startX, startY;
	static int[][] ladder = new int[S][S];
	static boolean[][] v;
	// 좌-우-상
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 1; tc++) {
			br.readLine();
			
			for (int i = 0; i < S; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < S; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			
			ans = 0;
			v = new boolean[S][S];
			dfs(startX, startY);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	static void bfs(int x, int y) {
		v = new boolean[S][S]; // 방문배열 초기화
		Queue<int[]> q = new ArrayDeque<>();
		
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 3; i++) {
				// 다음 방문할 지점 정보 저장
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < S && ny < S && !v[nx][ny] && ladder[nx][ny] == 1) {
					cur[0] = nx; // 다음 direction 확인을 위해 저장
					cur[1] = ny; // 다음 direction 확인을 위해 저장
					
					v[nx][ny] = true;
					q.offer(new int[] {nx, ny});

					if (nx == 0) { // 출발 row에 도착한 경우
						ans = ny; // 해당 column 저장
						return;
					}
				}
			}
		}
	}
	static void dfs(int x, int y) {
		if (x == 0) {
			ans = y;
			return;
		}
		
		v[x][y] = true;
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < S && ny < S && !v[nx][ny] && ladder[nx][ny] == 1) {
				x = nx;
				y = ny;
				
				dfs(x, y);
			}
			
		}
	}
}
