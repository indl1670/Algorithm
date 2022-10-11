package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1233_사칙연산유효성검사 {
	static int N, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 1;
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				char node = st.nextToken().charAt(0);
				
				if (st.hasMoreTokens()) { // 단말노드가 아닐 때 = 사칙연산
					if (node >= '0' && node <= '9') { // 숫자가 들어올 경우 유효하지 않음
						ans = 0;
					}
				} else { // 단말노드일 때 = 숫자
					if (node < '0' || node > '9') { // 숫자가 아닌 문자가 들어올 경우 유효하지 않음
						ans = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
