package SWEA;

import java.io.*;
import java.util.*;

public class SWEA7465_창용마을무리의개수 {
	static int T, N, M, cnt; // N = 정점, M = 간선
	static int[] parent;
	static boolean[] isParty;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1]; // 부모 배열
			isParty = new boolean[N+1]; // 무리인지 확인하는 배열
			cnt = 0;
			
			makeSet(); // 부모 배열 초기화
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				union(from, to); // 서로 알고있는 두 사람들과의 무리 생성
			}
			
			// 단순히 union만 할 경우 최상위 부모값만 바뀌고 하위는 바뀌지 않는다.
			// 따라서 findSet을 한번 더 실행시켜 하위 부모들까지 변경해주어야 함
			for (int i = 1; i <= N; i++) {
				int p = findSet(i); // 해당 정점의 부모 == 무리
				
				if (!isParty[p]) { // 하나의 무리가 발견된 경우
					isParty[p] = true; // 무리로 판단
					cnt++; // 무리 개수 증가
				}
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	static void union(int f, int t) {
		int pf = findSet(f);
		int pt = findSet(t);
		
		if (pf == pt) return; // 이미 무리(Cycle)로 판정난 경우 return
		
		// 두 집합이 무리가 아닌 경우
		if (pt < pf) parent[pf] = pt;
		else parent[pt] = pf;
		
		return;
	}
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
}
