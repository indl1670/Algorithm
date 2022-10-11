package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1228_암호문1 {
	static int N, cmd;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			// 암호문 초기화
			List<Integer> pwd = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pwd.add(Integer.parseInt(st.nextToken()));
			}
			
			cmd = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd; i++) {
				st.nextToken(); // 명령어 I
				int index = Integer.parseInt(st.nextToken()); // x 위치에
				int cnt = Integer.parseInt(st.nextToken()); // y개의 암호문 삽입
				
				for (int j = 0; j < cnt; j++) {
					// x 위치에서 시작해서 차례대로 y개의 암호문 삽입
					pwd.add(index + j, Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) { // 암호문의 처음 10개 항만 출력
				sb.append(pwd.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
