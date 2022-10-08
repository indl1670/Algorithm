package SWEA;

import java.io.*;
import java.util.*;

// Kruskal
public class SWEA3124_최소스패닝트리 {
	static int T, V, E;
	static int[] parent;
	static Edges[] edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			edges = new Edges[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges[i] = new Edges(from, to, cost);
			}
			
			makeSet(); // 부모 배열 생성
			
			int cnt = 1; // 시작 정점 1
			long sum = 0; // 비용의 총 합
			for (int i = 0; i < E; i++) {
				Edges e = edges[i];
				if (union(e.from, e.to)) { // 두 집합이 이어져 있는 경우
					cnt++;
					sum += e.cost; // 비용 추가
				}
				if (cnt == V) break; // 모든 정점을 방문 완료한 경우 종료
					
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	static int findSet(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		if (pa == pb) // cycle이 될 경우 false를 리턴
			return false; 
		// cycle이 안될 경우 하나의 부모 집합에 담기
		if (pb > pa) parent[pb] = pa;
		else parent[pa] = pb;
		return true;
	}
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	static class Edges {
		int from, to, cost;

		public Edges(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
	}

}