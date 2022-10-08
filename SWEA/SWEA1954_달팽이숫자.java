package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1954_달팽이숫자 {
	static int T, N;
	static int[][] snail;
	// 우-히-좌-싱
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			snail = new int[N][N];
			int dir = 0; // 현재 방향
			int x = 0, y = 0; // 좌표
			
			// 달팽이 배열에 들어갈 숫자: 1 ~ N*N
			for (int num = 1; num <= N * N; num++) {
				snail[x][y] = num;
				
				// 현재 방향으로 이동
				x += dx[dir];
				y += dy[dir];
				
				// 경계를 벗어나거나 이미 숫자가 채워져 있는 경우
				if (x < 0 || y < 0 || x >= N || y >= N || snail[x][y] != 0) {
					// 이전 지점으로 돌아가기
					x -= dx[dir];
					y -= dy[dir];
					
					// 방향 전환
					dir = (dir + 1) % 4;
					
					// 전환된 방향으로 이동
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
