package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3109_빵집 {
	static int R, C, cnt;
	static char[][] map;
	
	// 우상 - 우 - 우하
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		// 맵 정보 저장
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		cnt = 0;
		// 항상 첫 번째 열부터 시작
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean dfs(int r, int c) {
		map[r][c] = '-'; // 배관 연결
		
        for(int i = 0; i < 3; i++) { // 3방 탐색
            int nx = r + dr[i];
            int ny = c + dc[i];
            
            // 범위 내에 있으면서
            if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if(map[nx][ny] == '.') { // 갈 수 있는 길인 경우
                    // 마지막 열에 도착 시 연결 완료(true 반환)
                    if(ny == C - 1) return true;
                    // 다음 위치가 마지막 열에 도달할 수 있으면 완료(true 반환)
                    if(dfs(nx, ny)) return true; 
                }
            }
        }
        // 마지막 열에 도달할 수 없는 경우 false 반환
        return false;
    }   

}
