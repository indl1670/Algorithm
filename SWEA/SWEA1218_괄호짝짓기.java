package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1218_괄호짝짓기 {
	static int N;
	static char[] bracket;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			bracket = new char[N];
			bracket = br.readLine().toCharArray();
			
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				char c = bracket[i];
				
				// 입력이 닫는 괄호일 때, 여는 괄호와 닫는 괄호의 짝이 맞을 경우 pop
				if (c == ')' && stack.peek() == '(') stack.pop();
				else if (c == ']' && stack.peek() == '[') stack.pop();
				else if (c == '}' && stack.peek() == '{') stack.pop();
				else if (c == '>' && stack.peek() == '<') stack.pop();
				// 여는 괄호이거나 혹은 닫는 괄호일때 여는 괄호와 서로 짝이 맞지 않을 경우 push
				else {
					stack.push(c);
				}
			}
			
			// 스택이 비었는지 확인 - 비어있으면 1(유효함), 비어있지 않으면 0(유효하지 않음)
			System.out.println("#" + tc + " " + (stack.isEmpty() ? 1 : 0));
		}
	}

}
