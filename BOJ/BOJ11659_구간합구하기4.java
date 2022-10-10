package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11659_구간합구하기4 {
	static int N, M;
	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1]; // 0 dummy
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken()); // 구간 합 구하기
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(nums[end] - nums[start - 1]).append("\n"); // 결과 도출
		}
		
		System.out.println(sb.toString());

	}

}
