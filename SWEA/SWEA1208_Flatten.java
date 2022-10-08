package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1208_Flatten {
	static int D, ans;
	static PriorityQueue<Integer> max = new PriorityQueue<>();
	static PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			max.clear();
			min.clear();
			
			D = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				int box = Integer.parseInt(st.nextToken());
				max.offer(box);
				min.offer(box);
			}
			
			Dump(0);
			
			System.out.println("#" + tc + " " + ans);
		}

	}
	static void Dump(int depth) {
		if (depth == D) {
			ans = min.peek() - max.peek();
			return;
		}
		
		int tempMin = max.poll();
		int tempMax = min.poll();
		
		min.offer(tempMax - 1);
		max.offer(tempMin + 1);
		
		Dump(depth+1);
	}

}
