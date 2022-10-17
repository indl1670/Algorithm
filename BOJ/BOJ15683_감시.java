package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15683_감시 {
	static int N, M, cnt, ans;
	static int[][] office, copy;
	static int[] select;
	static List<CCTV> cctv = new ArrayList<>();
	
	// 시계방향 : 상 -> 우 -> 하 -> 좌 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		
		// 0: 바닥, 1: cctv1, 2: cctv2, 3: cctv3, 4: cctv4, 5: cctv5, 6: 벽
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				
				// CCTV 정보만 담기
				if (office[i][j] != 0 && office[i][j] != 6) {
					cctv.add(new CCTV(office[i][j], i, j));
				}
				
			}
		}
		cnt = cctv.size(); // cctv 개수
		select = new int[cnt]; // 선택된 CCTV 배열 방향
		ans = Integer.MAX_VALUE;
		perm(0);
		
		System.out.println(ans);

	}
	static void perm(int depth) {
		// 기저조건
		if (depth == cnt) { // 전체 CCTV에 대해서 방향 설정 시작
			// 사각지대 확인을 위한 office 배열 복사
			copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = office[i][j];
				}
			}
			
			// 방향 설정
			for (int i = 0; i < cnt; i++) {
				setDirection(cctv.get(i), select[i]);
			}
			
			// 사각지대 개수 구하기
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 0) { // 사각지대일 경우
						sum++;
					}
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			select[depth] = i;
			perm(depth+1);
		}
	}
	static void setDirection(CCTV cctv, int dir) {
		int num = cctv.num;
		
		switch(num) {
		case 1: // 상 / 우 / 하 / 좌
			if (dir == 0) getDirection(cctv, 0); // 상
			else if (dir == 1) getDirection(cctv, 1); // 우
			else if (dir == 2) getDirection(cctv, 2); // 하
			else if (dir == 3) getDirection(cctv, 3); // 좌
			break;
		case 2: // 상하 / 좌우
			if (dir == 0 || dir == 2) {
				getDirection(cctv, 0); // 상하
				getDirection(cctv, 2);
			} else {
				getDirection(cctv, 1); // 좌우
				getDirection(cctv, 3);
			}
			break;
		case 3: // 상우 / 우하 / 하좌 / 좌상
			if(dir == 0) {
				getDirection(cctv, 0); // 상우 
				getDirection(cctv, 1);
			} else if(dir == 1) { 
				getDirection(cctv, 1); // 우하 
				getDirection(cctv, 2);
			} else if(dir == 2) { 
				getDirection(cctv, 2); // 하좌 
				getDirection(cctv, 3);
			} else if(dir == 3) { 
				getDirection(cctv, 0); // 좌상 
				getDirection(cctv, 3);
			}
			break;
		case 4: // 좌상우 / 상우하 / 좌하우 / 상좌하
			if(dir == 0) {
				getDirection(cctv, 0); // 좌상우 
				getDirection(cctv, 1);
				getDirection(cctv, 3);
			} else if(dir == 1) {
				getDirection(cctv, 0); // 상우하 
				getDirection(cctv, 1);
				getDirection(cctv, 2);
			} else if(dir == 2) {
				getDirection(cctv, 1); // 좌하우 
				getDirection(cctv, 2);
				getDirection(cctv, 3);
			} else if(dir == 3) {
				getDirection(cctv, 0); // 상좌하 
				getDirection(cctv, 2);
				getDirection(cctv, 3);
			}
			break;
		case 5: // 상하좌우(4방 전체)
			getDirection(cctv, 0);
			getDirection(cctv, 1);
			getDirection(cctv, 2);
			getDirection(cctv, 3);
			break;
		}
	}
	// 감시할 수 있는 범위 확인
	static void getDirection(CCTV cctv, int dir) {
		Queue<CCTV> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		
		v[cctv.x][cctv.y] = true;
		q.offer(cctv);
		
		while (!q.isEmpty()) {
			CCTV c = q.poll();
			int nx = c.x + dx[dir];
			int ny = c.y + dy[dir];
			
			// 경계에 닿거나 벽을 만나면 종료
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || copy[nx][ny] == 6)
				break;
			
			// 0(빈칸)일 경우 감시 가능
			if (copy[nx][ny] == 0) {
				copy[nx][ny] = -1; // 감시된 공간으로 설정
				q.offer(new CCTV(cctv.num, nx, ny));
			} else { // 다른 cctv가 존재하거나 이미 감시된 공간일 경우 pass
				q.offer(new CCTV(cctv.num, nx, ny));
			}
 		}
	}
	static class CCTV {
		int num, x, y;

		public CCTV(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
		
	}

}
