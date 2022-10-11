package SWEA;

import java.io.*;
import java.util.*;

public class SWEA6808_규영이와인영이의카드게임 {
	static int T, win, lose, cnt = 0;
	static int[] kyu, iny, sel;
	static boolean[] cards, v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cards = new boolean[19]; // 0 dummy
			kyu = new int[9]; // 규영이 카드 배열
			iny = new int[9]; // 인영이 카드 배열
			sel = new int[9]; // 인영이 카드 순서
			v = new boolean[9]; // 인영이 카드 선택 여부
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) { // 규영이 카드 정보
				int k = Integer.parseInt(st.nextToken());
				kyu[i] = k;
				cards[k] = true;
			}
			
			int in = 0;
			for (int i = 1; i <= 18; i++) { // 인영이 카드 정보
				if (!cards[i]) iny[in++] = i; // 규영이가 뽑지 않은 카드만 선택
			}
			
			win = 0;
			lose = 0;
			perm(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}
	static void perm(int depth) {
		if (depth == 9) {
			int kSum = 0;
			int iSum = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > sel[i]) // 규영이가 이길 경우
					kSum += kyu[i] + sel[i];
				else // 인영이가 이길 경우
					iSum += kyu[i] + sel[i];
			}
			
			if (kSum > iSum) // 규영이의 점수 합이 더 큰 경우 = 규영 승리
				win++;
			else // 인영이의 점수 합이 더 큰 경우 = 규영 패배
				lose++;
		}
		
		for (int i = 0; i < 9; i++) {
			if (v[i]) continue;
			
			v[i] = true;
			sel[depth] = iny[i];
			perm(depth+1);
			v[i] = false;
		}
	}
}
