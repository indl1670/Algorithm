package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2805_농작물수확하기 {
	static int T, N, sum;
	static int[][] farm;
	static boolean[][] v;
	// 4방 탐색
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			v = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
			
			sum = 0;
			bfs(N/2, N/2); // 가운데 지점부터 BFS 시작
			System.out.println("#" + tc + " " + sum);
		}
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		sum += farm[x][y];
		v[x][y] = true;
		q.offer(new int[] {x, y});
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny]) {
					if (cnt == 4) return; // 4방 경계면에 다 닿일 경우(카운트가 4일 경우) 종료
					
					// 경계면에 닿일 경우 카운트 증가
					if (nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
						cnt++;
					}
					
					sum += farm[nx][ny]; // 수익 증가
					v[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}

}
