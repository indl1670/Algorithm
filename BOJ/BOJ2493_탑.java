package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2493_탑 {
	static int N;
	static int[] tower, ans;
	static Stack<int[]> s = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 현재 탑의 크기
			int current = Integer.parseInt(st.nextToken());
			
			while (!s.isEmpty()) {
				if (s.peek()[1] >= current) { // 현재 탑의 크기가 이전 탑보다 클 경우
					sb.append(s.peek()[0]).append(" "); // 현재 탑의 위치 저장
					break;
				}
				s.pop(); // 스택 정리
			}
			
			if (s.isEmpty()) { // 첫번째 탑일 경우
				sb.append("0 "); // 0 출력
			}
			// 현재 위치와 탑의 최대 높이 저장
			s.push(new int[] {i, current});
		}
		System.out.println(sb.toString());

	}

}
