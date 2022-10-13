package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2839_설탕배달 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if (N == 4 || N == 7) { // 3kg과 5kg으로 만들 수 없는 무게일 경우
			System.out.println(-1);
		}
		else if (N % 5 == 0) { // 5kg으로 나누어 떨어지는 경우
			System.out.println(N / 5);
		}
		// 5kg으로 나누어 떨어지지 않는 경우
		// 3kg으로만 만들 수 있거나 5kg을 최대로 선택하고 나머지를 3kg으로 만들 수 있는 무게인 경우
		else if (N % 5 == 1 || N % 5 == 3) { 
			System.out.println((N / 5) + 1);
		}
		else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println((N / 5) + 2);
		}

	}

}
