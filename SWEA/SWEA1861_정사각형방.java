package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1861_정사각형방 {
	static int T, N, cnt;
	static int[][] square;
	static boolean[][] v;	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			square = new int[N][N];
			int maxCnt = Integer.MIN_VALUE; // 이동 횟수 최대
			int minValue = Integer.MAX_VALUE; // 방에 적힌 숫자 최소
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					v = new boolean[N][N];
					// 4방탐색 BFS
					bfs(i, j);
					
					if (maxCnt < cnt) { // 현재 이동 횟수가 더 큰 경우
						maxCnt = cnt;
						minValue = square[i][j];
					}
					// 이동횟수는 동일하지만 방에 적힌 숫자가 현재 방이 더 작은 경우
					if (maxCnt == cnt && minValue > square[i][j]) { 
						minValue = square[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + minValue + " " + maxCnt);
		}
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		while (!q.isEmpty()) {
			cnt++;
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				// 다음 방의 좌표가 전체 방 범위를 넘지 않고, 방문한 적 없는 방이면서 현재 방의 번호에 +1한 값과 같을 경우
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny] && (square[cx][cy] + 1 == square[nx][ny])) {
					v[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return;
	}
}
