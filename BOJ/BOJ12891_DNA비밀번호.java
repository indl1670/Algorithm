package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] dna = new char[S]; // DNA 배열
		int[] check = new int[4]; // 최소 DNA 등장 횟수
		Queue<Character> q = new ArrayDeque<>();
		
		dna = br.readLine().toCharArray();
		
		// 0: A, 1: C, 2 : G, 3 : T
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < S; i++) {
			char c = dna[i];
			switch(c) { // 등장하는 DNA 문자에 따라 등장 횟수 감소
			case 'A':
				check[0]--;
				break;
			case 'C':
				check[1]--;
				break;
			case 'G':
				check[2]--;
				break;
			case 'T':
				check[3]--;
				break;
			}
			// 큐에 넣기
			q.add(c);
			
			if (q.size() == P) { // 부분 문자열에 도달할 경우
				// 모든 DNA 문자들의 최소 등장 횟수를 만족 시켰는지 확인
				if (check[0] <= 0 && check[1] <= 0 && check[2] <= 0 && check[3] <= 0) {
					cnt++;
				}
				// 제일 앞의 DNA 문자 제거
				char ac = q.poll();
				switch(ac) { // 제거된 DNA 문자 등장 횟수 되돌리기
				case 'A':
					check[0]++;
					break;
				case 'C':
					check[1]++;
					break;
				case 'G':
					check[2]++;
					break;
				case 'T':
					check[3]++;
					break;
				}
			}			
		}
		System.out.println(cnt);
	}

}
