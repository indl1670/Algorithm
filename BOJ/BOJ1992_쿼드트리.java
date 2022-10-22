package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb.toString());
	}
	static void quadTree(int x, int y, int n) {
		if (check(x, y, n)) {
			sb.append(map[x][y]);
			return;
		}
		
		int size = n/2;
		
		// map을 기준으로 각 1사분면, 2사분면, 3사분면, 4사분면에 대해서 쿼드트리 진행 반복
		sb.append("(");
		quadTree(x, y, size);
		quadTree(x, y+size, size);
		quadTree(x+size, y, size);
		quadTree(x+size, y+size, size);
		sb.append(")");
	}
	static boolean check(int x, int y, int n) {
		int tmp = map[x][y];
		
		// 주어진 사분면에 대해
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (tmp != map[i][j]) { // 통일되지 않은 숫자가 나올 경우
					return false;
				}
			}
		}
		// 사분면의 숫자가 모두 동일할 경우 해당 번호로 압축 시작
		return true;
	}
}
