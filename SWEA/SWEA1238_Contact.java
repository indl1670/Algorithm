package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1238_Contact {
	static int N, start, maxNum, maxDepth;
	static boolean[][] contact;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			contact = new boolean[101][101]; // 0 dummy
			maxNum = 0;
			maxDepth = 0;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken()); // 시작 번호
			
			
			// 비상 연락망 구성
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) { // from과 to 두 번 연속으로 받기 때문에 N/2만큼 실행
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from][to] = true;
			}
			
			bfs();
			System.out.println("#" + tc + " " + maxNum);
		}
	}
	
	static void bfs() {
		// 시작번호부터
		contact[start][0] = true; // 연락 완료
		Queue<Person> q = new ArrayDeque<>();
		q.offer(new Person(start, 0));
		
		while (!q.isEmpty()) {
			Person p = q.poll();
			
			// max값보다 깊이가 깊은 경우
			if (p.depth > maxDepth) {
				// 최종 깊이, 최종 번호 재설정
				maxDepth = p.depth;
				maxNum = p.num;
			} else if (p.depth == maxDepth) { // 깊이가 동일할 경우
				// 번호의 최댓값 저장
				maxNum = Math.max(maxNum, p.num);
			}
			
			for (int i = 1; i <= 100; i++) {
				// 연락받을 번호가 없거나 이미 연락을 한 번호일 경우 Pass
				if (!contact[p.num][i] || contact[i][0]) continue;
				// 연락받을 번호가 있거나 아직 연락하지 않은 번호일 경우
				contact[i][0] = true; // 연락 완료
				q.offer(new Person(i, p.depth+1)); // 깊이 증가
			}
		}
	}
	
	static class Person {
		int num, depth;

		public Person(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
		
	}

}
