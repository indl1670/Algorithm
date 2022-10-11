package SWEA;

import java.io.*;
import java.util.*;

public class SWEA9229_한빈이와SpotMart {
	static int T, N, M, max;
	static int[] snack, select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N]; // 스팟마트 내의 과자 무게
			select = new int[2]; // 한빈이가 선택한 과자 무게
			max = -1; // 출력값 -1로 초기화
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			// N개중에 2개 선택(조합)
			comb(0, 0);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	static void comb(int depth, int start) {
		if (depth == 2) { // 2봉지를 고를 경우
			int sum = select[0] + select[1];
			if (sum <= M) // M보다 무게가 작을 경우
				max = Math.max(max, sum); // 최댓값 저장
			return;
		}
		
		for (int i = start; i < N; i++) {
			select[depth] = snack[i]; // 과자 선택
			comb(depth+1, i+1);
		}
	}

}