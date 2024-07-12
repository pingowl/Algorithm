import java.util.*;
import java.io.*;
public class Main {
	static int n, order[], like[][], a[][];
	static int dy[] = {-1,0,1,0}, dx[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        like = new int[n*n+1][4];
        a = new int[n][n];
        order = new int[n*n];
        for(int i=0; i<n*n; i++) {
        	st = new StringTokenizer(br.readLine());
        	order[i]= Integer.parseInt(st.nextToken());
        	for(int j=0; j<4; j++) {
        		like[order[i]][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<n*n; i++) {
        	findSeat(order[i]);
        }
        
        System.out.println(calcLikes());
	}
	static void findSeat(int stu) {
		int y=-1, x=-1, likeMax=-1, emptyMax=-1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]!=0) continue;
				
				int likes = getLikesCnt(i,j,stu);
				int emps = getEmptyCnt(i,j);
				
				if(likes > likeMax || (likes == likeMax && emps > emptyMax)) {
					emptyMax = emps;
					likeMax = likes;
					y = i; x = j;					
				}
			}
		}
		a[y][x] = stu;
	}
	static int getLikesCnt(int y, int x, int stu) {
		int ny, nx, cnt=0;
		for(int i=0; i<4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if(ny<0 || nx<0 || ny>=n || nx>=n || a[ny][nx]==0) continue;
			for(int j=0; j<4; j++) {
				if(a[ny][nx] == like[stu][j]) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
	static int getEmptyCnt(int y, int x) {
		int ny, nx, cnt=0;
		for(int i=0; i<4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if(ny>=0 && nx>=0 && ny<n && nx<n && a[ny][nx]==0)
				cnt++;
		}
		return cnt;
	}
	static int calcLikes() {
		int sum = 0, cnt;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cnt = getLikesCnt(i,j,a[i][j]);
				if(cnt==0) continue;
				else if(cnt==1) sum +=1;
				else if(cnt==2) sum +=10;
				else if(cnt==3) sum +=100;
				else if(cnt==4) sum +=1000;
			}
		}
		return sum;
	}
}