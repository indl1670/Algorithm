package SWEA;

import java.io.*;
import java.util.*;

public class SWEA5644_무선충전 {
	static int T, M, A, maxSum, aX, aY, bX, bY;
	static int[] pathA, pathB;
	static Battery[] BC;
	
	// 제자리 - 상 - 우 - 하 - 좌
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			pathA = new int[M];
			pathB = new int[M];
			BC = new Battery[A];
			
			StringTokenizer stA = new StringTokenizer(br.readLine());
			StringTokenizer stB = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathA[i] = Integer.parseInt(stA.nextToken()); // 사용자 A의 이동 경로
				pathB[i] = Integer.parseInt(stB.nextToken()); // 사용자 B의 이동 경로
			}
			
			// BC의 정보 저장
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				BC[i] = new Battery(y, x, c, p);
			}
			
			maxSum = 0;
			aX = aY = 1; // 사용자 A의 초기 위치
			bX = bY = 10; // 사용자 B의 초기 위치
			
			charge(); // 시작 위치에서 충전량 확인
			
			for (int i = 0; i < M; i++) {
				aY += dy[pathA[i]];
				aX += dx[pathA[i]];
				bY += dy[pathB[i]];
				bX += dx[pathB[i]];
				
				charge(); // 이동한 위치에서 충전량 확인
			}
			
			System.out.println("#" + tc + " " + maxSum);
		}
	}
	static void charge() {
		int max = 0; // 충전량 합의 최댓값
		for (int a = 0; a < A; a++) { // 사용자 A가 충전하려는 BC
			for (int b = 0; b < A; b++) { // 사용자 B가 충전하려는 BC
				int sum = 0; // 충전량 합
				int chargeA = getCharge(BC[a], aY, aX);
				int chargeB = getCharge(BC[b], bY, bX);
				
				// A와 B 모두 충전량이 0인 경우 패스
				if (chargeA == 0 && chargeB == 0) continue;
				// 둘 중 하나라도 충전량이 0이 아닌 경우
				if (a != b) { // A와 B가 사용한 BC가 서로 다른 경우
					sum = chargeA + chargeB;
				} else { // A와 B가 동일한 BC를 사용한 경우
					sum = Math.max(chargeA, chargeB); // 충전량의 최댓값 선택
				}
				max = Math.max(max, sum);
			}
		}
		maxSum += max;
	}
	static int getCharge(Battery bc, int y, int x) {
		// 현재 위치가 충전소의 범위 내에 있는 경우
		if ((Math.abs(bc.x - x) + Math.abs(bc.y - y)) <= bc.c)
			return bc.p;
		return 0;
	}
	static class Battery {
		int y, x, c, p;
		
		public Battery(int y, int x, int c, int p) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
}
