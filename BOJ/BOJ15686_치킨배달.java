package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15686_치킨배달 {
	static int N, M, minDist;
	static List<int[]> house, chicken, select;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		M = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수
		house = new ArrayList<>(); // 집 정보
		chicken = new ArrayList<>(); // 치킨집 정보
		select = new ArrayList<>(); // 선택한 치킨집 정보
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());
				// 0: 빈칸, 1: 집, 2: 치킨집
				if (info == 1) {
					house.add(new int[] {i, j}); // 집 정보 저장
				} else if (info == 2) {
					chicken.add(new int[] {i, j}); // 치킨집 정보 저장
				}
			}
		}
		// 도시의 치킨거리 최솟값
		minDist = Integer.MAX_VALUE;
		subs(0, 0);
		System.out.println(minDist);
	}
	static void subs(int depth, int start) {
		if (start == M) {
			int sum = 0; // 집마다의 최소 치킨 거리의 합
			for (int i = 0; i < house.size(); i++) {
				int dist = Integer.MAX_VALUE; // 집과 치킨집 사이의 거리
				int[] h = house.get(i);
				for (int j = 0; j < M; j++) {
					int[] c = select.get(j);
					// 선택된 치킨집과 나머지 집들 사이의 최솟값 저장
					dist = Math.min(dist, Math.abs(h[0]-c[0]) + Math.abs(h[1] - c[1]));
				}
				sum += dist;
			}
			// 도시의 최소 치킨 거리
			minDist = Math.min(minDist, sum);
			return;
		}
		if (depth == chicken.size()) return;
		
		// 치킨집 선택 O
		select.add(chicken.get(depth));
		subs(depth+1, start+1);
		// 치킨집 선택 X
		select.remove(chicken.get(depth));
		subs(depth+1, start);
	}
}
