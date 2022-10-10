package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2164_카드2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> cards = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			cards.offer(i);
		}
		
		while(cards.size() != 1) { // 남는 카드가 1장일 경우 종료
			cards.poll(); // 제일 위에 있는 카드 버림
			
			// 다음 제일 위에 있는 카드를 제일 아래로 옮김
			int next = cards.poll();
			cards.offer(next);
		}
		
		System.out.println(cards.poll());

	}

}
