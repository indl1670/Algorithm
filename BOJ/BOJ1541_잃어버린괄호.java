package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int min = 0;
		String[] str = br.readLine().split("-"); // '-'를 기준으로 연산식 분리

		for (int i = 0; i < str.length; i++) {
			String[] str2 = str[i].split("+"); // '+'를 기준으로 연산식 재분리
			int tmp = 0;
			for (int j = 0; j < str2.length; j++) {
				tmp += Integer.parseInt(str2[j]); // '+'로 묶인 수들 먼저 계산
			}
			
			if (i == 0) min += tmp; // '-' 이전 숫자들 => 다 더함
			else min -= tmp; // '-' 이후의 숫자들 => 다 뺌
		}
		System.out.println(min);
	}

}
