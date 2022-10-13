package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2961_도영이가만든맛있는음식 {
	static int N, S, B, minDiff;
	static Taste[] ingredient;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ingredient = new Taste[N];
		select = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ingredient[i] = new Taste(s, b);
		}
		
		minDiff = Integer.MAX_VALUE;
		subs(0);
		System.out.println(minDiff);
	}
	static void subs(int depth) {
		if (depth == N) {
			int sour = 1, bitter = 0, cnt = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) { // 선택한 재료에 한해서 신맛, 쓴맛 구하기
					sour *= ingredient[i].s;
					bitter += ingredient[i].b;
					cnt++;
				}
			}
			if (cnt > 0) { // 선택된 재료가 하나 이상일 경우에만 맛 차이 구하기
				minDiff = Integer.min(minDiff, Math.abs(sour - bitter));
			}
			return;
		}
		// 현재 재료 선택 O
		select[depth] = true;
		subs(depth+1);
		// 현재 재료 선택 X
		select[depth] = false;
		subs(depth+1);
	}
	static class Taste {
		int s, b;
		public Taste(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
}
