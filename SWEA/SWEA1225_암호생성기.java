package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1225_암호생성기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			boolean isDone = false; // 종료 여부
			
			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (!isDone) { // 0 이하의 숫자를 만날 경우 종료
				for (int i = 1; i <= 5; i++) { // 1부터 5까지 차례대로 빼줌
					int next = q.poll() - i; // 다음에 올 암호 숫자 변경
					if (next <= 0) { // 0보다 작거나 같을 경우
						q.offer(0); // 0으로 삽입
						isDone = true; // 종료
						break;
					} else { // 0보다 클 경우 큐에 다시 삽입
						q.offer(next);
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
