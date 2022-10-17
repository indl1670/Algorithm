package SWEA;

import java.io.*;
import java.util.*;

public class SWEA14510_나무높이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int maxHeight = 0; // 최대 나무 높이
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Integer.max(maxHeight, tree[i]);
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (tree[i] == maxHeight) {
					cnt++;
				}
			}
			// 모든 나무의 높이가 동일한 경우 0 출력
			if (cnt == N) sb.append("#").append(tc).append(" ").append(0).append("\n");
			else { // 모든 나무의 높이가 다른 경우
				if (maxHeight%2 == 0) { // 최대 높이가 짝수일 때
					// sum: 필수로 들어가야되는 cnt
					// odd, even: 바뀔 수 있는 cnt
					// odd: 홀수날 +1, even: 짝수날 +2
					int sum = 0, odd = 0, even = 0;
					for (int i = 0; i < N; i++) {
						// 최대 높이가 짝수일 경우 나머지 모든 나무들의 높이 또한 짝수로 변환시켜야됨
						if (tree[i] != maxHeight && tree[i]%2 == 1) {
							tree[i]++;
							// +1 했을때 최대높이와 같아지거나 짝수로 변환시켜야 하는 경우 => 필수
							if (tree[i] == maxHeight) sum++;
							else { // +1 했을때 최대높이가 아닌 경우 odd 추가
								odd++;
								sum++;
							}
						}
					}
					// maxHeight = tree[i] + N*2 
					// => N = (maxHeight - tree[i])/2
					for (int i = 0; i < N; i++) {
						if (tree[i] != maxHeight) {
							int t = tree[i];
							even += (maxHeight - t)/2;
						}
					}
					if (sum > odd) { // 필수 요소가 변동 요소보다 큰 경우 필수 요소 선택
						if (sum == even) odd = sum; // +1한 경우와 +2한 경우가 동일할 때 odd = sum
						if (even > sum) { // +2한 경우가 더 많을 경우
							while (sum < even) { // +1한 경우가 더 커질때까지 even-1, sum+2
								even -= 1;
								sum += 2;
							}
							odd = sum;
						}
					} else { // 필수 요소가 변동 요소보다 작거나 경우 변동 요소 선택
						if (even > odd) {
							while(odd < even) { // +1한 경우가 더 커질때까지 even-1, sum+2
								even -= 1;
								odd += 2;
							}
						}
					}
					if (odd == 0) odd = sum; // +1했을때 전부 최대높이와 같아지는 경우 변동 요소 = 필수 요소
					sb.append("#").append(tc).append(" ").append(odd+even).append("\n");
				} else { // 최대 높이가 홀수일 때
					int sum = 0, odd = 0, even = 0;
					for (int i = 0; i < N; i++) {
						// 최대 높이가 짝수일 경우 나머지 모든 나무들의 높이 또한 짝수로 변환시켜야됨
						if (tree[i] != maxHeight && tree[i]%2 == 0) {
							tree[i]++;
							// +1 했을때 최대높이와 같아지거나 짝수로 변환시켜야 하는 경우 => 필수
							if (tree[i] == maxHeight) sum++;
							else { // +1 했을때 최대높이가 아닌 경우 odd 추가
								odd++;
								sum++;
							}
						}
					}
					// maxHeight = tree[i] + N*2 
					// => N = (maxHeight - tree[i])/2
					for (int i = 0; i < N; i++) {
						if (tree[i] != maxHeight) {
							int t = tree[i];
							even += (maxHeight - t)/2;
						}
					}
					if (sum > odd) { // 필수 요소가 변동 요소보다 큰 경우 필수 요소 선택
						// +1한 경우와 +2한 경우가 동일할 때 odd = sum
						// 짝수날로 끝나는 테스트케이스 만족
						if (sum-1 == even) odd = sum; 
						if (sum > even) { // 필수 요소가 +2한 경우보다 큰 경우
							odd = sum + (sum-even-1);
						}
						if (even > sum) { // +2한 경우가 더 많을 경우
							while (sum < even) { // +1한 경우가 더 커질때까지 even-1, sum+2
								even -= 1;
								sum += 2;
							}
							odd = sum;
						}
					} else { // 필수 요소가 변동 요소보다 작거나 경우 변동 요소 선택
						if (even > odd) {
							while(odd < even) { // +1한 경우가 더 커질때까지 even-1, sum+2
								even -= 1;
								odd += 2;
							}
						}
					}
					if (odd == 0) odd = sum; // +1했을때 전부 최대높이와 같아지는 경우 변동 요소 = 필수 요소
					sb.append("#").append(tc).append(" ").append(odd+even).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
