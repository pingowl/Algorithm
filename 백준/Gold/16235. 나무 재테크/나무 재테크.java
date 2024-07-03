import java.util.*;
import java.io.*;
public class Main {
	
	static final int[] dy = {-1,-1,0,1,1,1,0,-1};
	static final int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int n, m, k;
	static ArrayList<Integer>[][] tree;
	static int[][] soil, soilAdd;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	tree = new ArrayList[n][n];
    	soil = new int[n][n];
    	soilAdd = new int[n][n];
        
    	for(int i=0; i<n; i++) {        		
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			int a = Integer.parseInt(st.nextToken());
    			soilAdd[i][j] = a;
    			soil[i][j] = 5;
    			tree[i][j] = new ArrayList<Integer>();
    		}
    	}   
    	
		for(int j=1; j<=m; j++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
	    	int x = Integer.parseInt(st.nextToken());
	    	int a = Integer.parseInt(st.nextToken());
			tree[y-1][x-1].add(a);
		}
		for(int i=0; i<k; i++) {
			springSummer(); fall(); winter();
		}
		
		int ret = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ret += tree[i][j].size();
			}
		}		
		
        System.out.println(ret);
	}	
	
	public static void springSummer() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tree[i][j].size() == 0) continue;
				ArrayList<Integer> tmp = new ArrayList<>();
				Collections.sort(tree[i][j]);
				int dead = 0;
				for(int t: tree[i][j]) {
					if(soil[i][j]>=t) {
						soil[i][j] -=t;
						tmp.add(t+1);
					}else {
						dead += t / 2;
					}
				}
				tree[i][j] = tmp;
				soil[i][j] += dead;
			}
		}
	}
	
	public static void fall() {
		int ny, nx;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tree[i][j].size() ==0) continue;
				for(int t : tree[i][j]) {
					if(t%5!=0) continue;
					for(int k=0; k<8; k++) {
						ny = i + dy[k];
						nx = j + dx[k];
						if(ny<0 || nx<0 || ny>=n || nx>=n) continue;
						tree[ny][nx].add(1);
					}
				}				
			}
		}
	}
	
	public static void winter() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				soil[i][j] += soilAdd[i][j];
			}
		}
	}
}