package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11660_구간합구하기5 {
	static int N, M;
	static int[][] nums;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				nums[i][j] = nums[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nums[i][j] += nums[i-1][j];
			}
		}
		
		int ans = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			ans = nums[endX][endY] - nums[startX-1][endY] - nums[endX][startY-1] + nums[startX-1][startY-1];
			sb.append(ans).append("\n");			
		}
		System.out.println(sb.toString());
	}

}
