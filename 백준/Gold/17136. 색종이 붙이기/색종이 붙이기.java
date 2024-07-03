import java.util.*;
import java.io.*;
public class Main {
	
	static int[][] a = new int[10][10];
	static int ret = Integer.MAX_VALUE;
	static int[] b = new int[6];
	static final int n = 10;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {				
				if(Integer.parseInt(st.nextToken()) == 1) {
					a[i][j] = 1;
				}
			}
		}		
		
		dfs(0,0,0);		
		
		if(ret == Integer.MAX_VALUE) 
			ret = -1;
		System.out.println(ret);
	}	
	
	public static void dfs(int y, int x, int cnt) {
		if(cnt>=ret) return;
		if(x==10) {
			dfs(y+1,0,cnt);
			return;
		}
		if(y==10) {
			ret = Math.min(ret, cnt);
			return;
		}
		if(a[y][x]==0) {
			dfs(y,x+1,cnt);
			return;
		}
		for(int size=5; size>=1; size--){
			if(b[size]==5) continue;
			if(check(y,x,size)) {
				b[size]++;
				draw(y,x,size,0);
				dfs(y,x+size,cnt+1);
				draw(y,x,size,1);
				b[size]--;
			}
		}
	}
	
	public static boolean check(int y, int x, int siz) {
		if(y+siz>n || x+siz>n) return false;
		for(int i=y; i<y+siz; i++) {
			for(int j=x; j<x+siz; j++) {
				if(a[i][j]==0) return false;
			}
		}
		return true;
	}
	
	public static void draw(int y, int x, int size, int val) {
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				a[i][j] = val;
			}
		}
	}
}