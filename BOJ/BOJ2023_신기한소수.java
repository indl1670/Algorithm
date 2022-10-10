package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2023_신기한소수 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int start = (int) Math.pow(10, N-1);
		// 시작 숫자와 자릿수
		result(0, 0);
		
		System.out.println(sb);
	
	}
	static void result(int num, int digit) {
		if (digit == N) { // 입력된 자릿수에 도달한 경우
			if (isPrime(num)) // 해당 숫자까지 소수인 경우
				sb.append(num).append("\n"); // 출력
			return;
		}
		for (int i = 0; i < 10; i++) {
			int next = num * 10 + i; // 왼쪽 자릿수부터
			if (isPrime(next)) // 소수일 경우
				result(next, digit+1); // 오른쪽으로 한칸씩 자릿수를 키워가며 다시 소수 판별
		}
	}
	// 소수 판별 함수
	static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

}