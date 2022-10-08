package SWEA;

import java.io.*;
import java.util.*;

public class SWEA3289_서로소집합 {
	static int T, N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) { // 합집합으로 변환
					union(a, b);
				} else if (op == 1) { // 두 집합 비교
					if (findSet(a) == findSet(b)) // 두 집합의 부모가 같은 경우
						sb.append(1); // 1 출력
					else sb.append(0); // 두 집합의 부모가 다른 경우 0 출력
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	// 부모 집합 생성
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	// 두 집합을 하나의 부모 집합으로 합침
	static void union(int a, int b) {
		int pa = findSet(a); // a의 부모 집합
		int pb = findSet(b); // b의 부모 집합
		// 부모 집합이 더 큰곳으로 합쳐짐
		if (pb > pa) parent[pb] = pa;
		else parent[pa] = pb;
	}
	static int findSet(int x) {
		if (parent[x] == x) return x; // 받은 집합과 부모 집합이 동일한 경우 그대로 리턴
		else return parent[x] = findSet(parent[x]); // 다를 경우 부모 집합에 조부모 집합을 넣어주고 리턴
	}
}
