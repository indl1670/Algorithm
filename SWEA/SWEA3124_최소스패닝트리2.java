package SWEA;

import java.io.*;
import java.util.*;

public class SWEA3124_최소스패닝트리2 {
	static int T, V, E;
	static long sum;
	static ArrayList<ArrayList<Edges>> vertex;
	static boolean[] v;
	// 비용을 기준으로 정렬
	static PriorityQueue<Edges> pq = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			v = new boolean[V+1];
			
			vertex = new ArrayList<ArrayList<Edges>>();
			for (int i = 0; i <= V; i++) {
				vertex.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				// 양방향 트리 생성
				vertex.get(from).add(new Edges(to, cost));
				vertex.get(to).add(new Edges(from, cost));
			}
			
			// 전역변수 초기화
			sum = 0;
			pq.clear();
			
			// Prim 알고리즘 시작
			prim();
			
			System.out.println("#" + tc + " " + sum);
		}

	}
	static void prim() {
		int cnt = 1; // 시작 정점 1
		v[1] = true; // 정점 1 방문 완료
		pq.addAll(vertex.get(1));
		
		while (!pq.isEmpty()) {
			Edges e = pq.poll();
			if (v[e.v]) continue; // 이미 방문한 정점일 경우 Pass
			
			v[e.v] = true; // 현재 정점 방문 완료
			cnt++; // 방문한 정점 개수 증가
			sum += e.cost; // 비용 추가
			
			if (cnt == V) break; // 방문한 정점 개수가 총 정점 개수와 동일할 경우 중단
			
			pq.addAll(vertex.get(e.v));
		}
	}
	static class Edges {
		int v, cost;

		public Edges(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
	}

}
