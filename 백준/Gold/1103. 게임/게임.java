import java.util.*;
import java.io.*;
public class Main {
	
	static int n, m;
	static char[][] a;
	static boolean[][] visited;
	static int[][] d;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		
		// INPUT FILE
		//System.setIn(new FileInputStream("src/input.txt")); // =================
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        a = new char[n][m];
        visited = new boolean[n][m];
        d = new int[n][m];
        
        for(int i=0; i<n; i++) {
        		String line = br.readLine();
        		a[i] = line.toCharArray();
        }
        
		System.out.println(go(0,0));
	}
	
	public static int go(int y, int x) {
		visited[y][x] = true;
		int ret = 0;
		int val = a[y][x]-'0';
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i]*val;
			int nx = x + dx[i]*val;
			
			if(ny<0 || nx<0 || ny>=n || nx>=m || a[ny][nx]=='H') continue;
			if(visited[ny][nx] ) {
				System.out.println("-1");
				System.exit(0);
			}
			if(d[ny][nx] !=0) 
				ret = Math.max(ret, d[ny][nx]);
			else
				ret = Math.max(ret, go(ny, nx));
		}
		visited[y][x]=false;
		d[y][x] = ++ret;
		return ret;
	}
}
