package SWEA;

import java.io.*;
import java.util.*;

public class SWEA2001_파리퇴치 {
	static int T, N, M, max;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = 0; // 최댓값 초기화
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// M 배열이 N 배열 속에 전제 다 있지 못하면 절대 최댓값이 없으므로 해당 부분 제외
			for (int i = 0; i < N-(M-1); i++) {
				for (int j = 0; j < N-(M-1); j++) {
					FlyCatch(i, j); // 파리 잡기 시작
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	static void FlyCatch(int x, int y) {
		int sum = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[x+i][y+j]; // M 영역 내의 파리의 합
			}
		}
		max = Integer.max(max, sum); // 최댓값 찾기
	}
}