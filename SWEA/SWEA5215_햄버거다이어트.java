package SWEA;

import java.io.*;
import java.util.*;

public class SWEA5215_햄버거다이어트 {
	static int T, N, L, maxScore;
	static int[][] hamburger;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			hamburger = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				hamburger[i][0] = score;
				hamburger[i][1] = calorie;
			}
			maxScore = 0;
			subSet(0, 0, 0);
			System.out.println("#" + tc + " " + maxScore);
		}
	}
	static void subSet(int depth, int score, int calorie) {
		if (calorie > L) return; // 제한된 칼로리보다 높은 경우 리턴
		else maxScore = Math.max(maxScore, score); // 낮거나 같은 경우 최대점수 저장
		if (depth == N) return; // 전체 재료를 선택한 경우
		
		// 현재 재료 선택 O
		subSet(depth+1, score + hamburger[depth][0], calorie + hamburger[depth][1]);
		// 현재 재료 선택 X
		subSet(depth+1, score, calorie);
	}
}
