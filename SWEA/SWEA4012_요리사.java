package SWEA;

import java.io.*;
import java.util.*;

public class SWEA4012_요리사 {
	static int T, N, minDiff;
	static int[][] ingredient;
	static int[] dishA, dishB;;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ingredient = new int[N][N];
			dishA = new int[N/2]; // A 요리
			dishB = new int[N/2]; // B 요리
			select = new boolean[N]; // 선택된 재료
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minDiff = Integer.MAX_VALUE;
			subs(0, 0);
			System.out.println("#" + tc + " " + minDiff);
		}
	}
	static void subs(int depth, int start) {
		if (start == N/2) {
			int A = 0, B = 0, tasteA = 0, tasteB = 0;
			
			for (int i = 0; i < N; i++) {
				if (select[i]) // 선택된 재료는 A 요리에 
					dishA[A++] = i;
				else // 선택되지 못한 재료는 B 요리에
					dishB[B++] = i;
			}
			
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N/2; j++) {
					tasteA += ingredient[dishA[i]][dishA[j]]; // A 요리의 맛
					tasteB += ingredient[dishB[i]][dishB[j]]; // B 요리의 맛
				}
			}
			// 두 요리의 맛 차이의 최솟값 저장
			minDiff = Math.min(minDiff, Math.abs(tasteA - tasteB));
		}
		if (depth == N) return;
		
		// A 요리에 현재 재료 선택
		select[depth] = true;
		subs(depth+1, start+1);
		// B 요리에 현재 재료 선택
		select[depth] = false;
		subs(depth+1, start);
	}
}
