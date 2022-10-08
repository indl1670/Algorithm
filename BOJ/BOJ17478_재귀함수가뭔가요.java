package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17478_재귀함수가뭔가요 {
	static String T = "";
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		Answer(N); // N만큼 재귀 호출
	}
	static void Answer(int N) {
		String tap = T;
		
		// N이 0이될 경우 마지막 응답 출력 후 종료
		if (N == 0) {
			System.out.println(tap + "\"재귀함수가 뭔가요?\"");
			System.out.println(tap +"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(tap + "라고 답변하였지.");
			return;
		}
		
		// 0이 아닐 경우 반복적으로 호출될 응답
		System.out.println(tap + "\"재귀함수가 뭔가요?\"");
		System.out.println(tap + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(tap + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(tap + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		// 재귀 횟수가 늘어날 수록 앞의 Tab 부분 String 변경
		T += "____";
		// 재귀 호출
		Answer(N-1);
		
		// 호출 완료 후 마무리 응답
		System.out.println(tap + "라고 답변하였지.");
	}

}
