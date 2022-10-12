package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1010_다리놓기 {
	static int T, N, M;
	static int[][] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			memoi = new int[M+1][N+1];
			
			// M개 중에서 N개 선택 - 순서는 자동으로 할당됨
			System.out.println(comb(M, N));
		}
	}
	static int comb(int depth, int start) {
		if (memoi[depth][start] != 0)
			return memoi[depth][start]; // 이미 계산된 값이 있다면 그대로 리턴
		
		// nCn 이거나 nC1일  경우
		if (depth == start || start == 0)
			return memoi[depth][start] = 1;
		
		// nCm = n-1Cm + n-1Cm-1
		return memoi[depth][start] = comb(depth-1, start) + comb(depth-1, start-1);
	}
}
