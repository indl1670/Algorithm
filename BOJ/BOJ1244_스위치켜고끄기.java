package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1244_스위치켜고끄기 {
	static int N, S;
	static int[] switches;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 스위치 수
		switches = new int[N+1]; // 0 dummy
		
		st = new StringTokenizer(br.readLine()); // 스위치의 배열을 받아옴
		for (int i = 1; i <= N; i++) { // 스위치의 번호가 1번부터 시작
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		S = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 학생 성별
			int startNum = Integer.parseInt(st.nextToken()); // 학생이 받은 수
			
			if (gender == 1) // 남학생인 경우
				male(startNum);
			if (gender == 2) // 여학생인 경우
				female(startNum);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i] + " ");
			if (i%20 == 0) System.out.println(); // 한줄에 최대 20개까지만 출력
		}
	}
	
	// 받은 수의 배수만큼 스위치 전환
	static void male(int startNum) {
		for (int i = startNum; i <= N; i++) {
			if (i%startNum == 0) { // 배수에 해당하는 경우
				// 1이면 0으로 전환, 0이면 1로 전환
				switches[i] = switches[i] == 1 ? 0 : 1;
			}
		}
	}
	
	static void female(int startNum) {
		// 받은 수에 해당하는 스위치 먼저 전환
		switches[startNum] = switches[startNum] == 1 ? 0 : 1;

		// 좌우대칭인 구간 스위치 전환
		for (int i = 1; i <= N; i++) {
			if (startNum-i >= 1 && startNum+i <= N) { // 구간 범위 설정
				if (switches[startNum-i] == switches[startNum+i]) { // 좌우 대칭인 경우
					switches[startNum-i] = switches[startNum-i] == 1 ? 0 : 1;
					switches[startNum+i] = switches[startNum+i] == 1 ? 0 : 1;
				}
				else break; // 좌우대칭이 아닐 경우 반복문 종료
			}
		}
	}

}
