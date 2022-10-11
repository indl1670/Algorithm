package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1158_요세푸스문제 {
	static int N, K;
	static Queue<Integer> people = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		K = sc.nextInt();
		sb.append("<");
		
		// N명의 사람 원형으로 앉히기
		for (int i = 1; i <= N; i++) {
			people.offer(i);
		}
		
		int cnt = 0;
		while (!people.isEmpty()) {
			int tmp = people.poll();
			cnt++;
			
			if (cnt == K) { // K번째 사람일 경우
				sb.append(tmp).append(", "); // 출력 스트림에 저장
				cnt = 0; // 카운트 초기화
			} else { // K번째에 해당하지 않을 경우 큐의 제일 뒤에 삽입 => 원형
				people.offer(tmp);
			}
		}
		
		// 지정된 출력 형식으로 변환
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

}
