package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1873_상호의배틀필드 {
	static int T, H, W, N;
	static char[][] map;
	static char[] cmd;
	// ^: 상, v: 하, <: 좌, >: 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			int startX = 0, startY = 0, dir = 0;
			
			// .: 평지, *: 벽돌, #: 강철, -: 물
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					switch(map[i][j]) { // 시작 지점 찾기
					case '^':
						startX = i;
						startY = j;
						dir = 0;
						break;
					case 'v':
						startX = i;
						startY = j;
						dir = 1;
						break;
					case '<':
						startX = i;
						startY = j;
						dir = 2;
						break;
					case '>':
						startX = i;
						startY = j;
						dir = 3;
						break;
					default:
						break;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			// U: 방향 위쪽 & 이동, D: 방향 아래쪽 & 이동, L: 방향 왼쪽 & 이동, R: 방향 오른쪽 & 이동, S: 현재방향 & 포탄발사
			cmd = new char[N];
			cmd = br.readLine().toCharArray();
			
			BattleField(startX, startY, dir);
			
			sb.append("#").append(tc).append(" ");
			for (int a = 0; a < H; a++) {
				for (int b = 0; b < W; b++) {
					sb.append(map[a][b]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static void BattleField(int x, int y, int dir) {
		int nx = 0, ny = 0;
		
		for (int i = 0; i < N; i++) {	
			switch(cmd[i]) {
			case 'U':
				dir = 0; // 방향 위쪽
				map[x][y] = '.'; // 이미 왔던 길은 평지로
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') { // 전차가 갈 수 있는 길인 경우
					// 위쪽으로 한칸 이동 후 방향 전환
					x = nx; 
					y = ny;
					map[x][y] = '^';
				} else { // 전차가 갈 수 없는 길인 경우
					map[x][y] = '^'; // 방향만 전환
				}
				break;
			case 'D':
				dir = 1;
				map[x][y] = '.'; // 이미 왔던 길은 평지로
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') { // 전차가 갈 수 있는 길인 경우
					// 아쪽으로 한칸 이동 후 방향 전환
					x = nx; 
					y = ny;
					map[x][y] = 'v';
				} else { // 전차가 갈 수 없는 길인 경우
					map[x][y] = 'v'; // 방향만 전환
				}
				break;
			case 'L':
				dir = 2;
				map[x][y] = '.'; // 이미 왔던 길은 평지로
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') { // 전차가 갈 수 있는 길인 경우
					// 왼쪽으로 한칸 이동 후 방향 전환
					x = nx; 
					y = ny;
					map[x][y] = '<';
				} else { // 전차가 갈 수 없는 길인 경우
					map[x][y] = '<'; // 방향만 전환
				}
				break;
			case 'R':
				dir = 3;
				map[x][y] = '.'; // 이미 왔던 길은 평지로
				nx = x + dx[dir];
				ny = y + dy[dir];
				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') { // 전차가 갈 수 있는 길인 경우
					// 위쪽으로 한칸 이동 후 방향 전환
					x = nx; 
					y = ny;
					map[x][y] = '>';
				} else { // 전차가 갈 수 없는 길인 경우
					map[x][y] = '>'; // 방향만 전환
				}
				break;
			case 'S':
				nx = x + dx[dir];
				ny = y + dy[dir];
				
				while (true) {
					if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
						if (map[nx][ny] == '#') // 강철인 경우 그대로 종료
							break;
						else if (map[nx][ny] == '*') {// 벽돌인 경우
							map[nx][ny] = '.'; // 벽돌을 평지로 변환 후 종료
							break;
						} else { // 평지나 물일 경우 패스
							nx += dx[dir];
							ny += dy[dir];
						}
					} else break;
					
				}
				break;
			}
		}
		return;
	}
}
