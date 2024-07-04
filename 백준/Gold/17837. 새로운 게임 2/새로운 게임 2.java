import java.util.*;
import java.io.*;
public class Main {
	
	static int n, k, ret=0;
	static int[][] a; 
	static Horse[] h;
	static ArrayList<Integer>[][] list;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n][n]; h = new Horse[k];
        list = new ArrayList[n][n];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		a[i][j] = Integer.parseInt(st.nextToken());
        		// 0:white, 1:red, 2:blue
        		list[i][j] = new ArrayList<Integer>();
        	}
        }
        int y, x, num;
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
    		y = Integer.parseInt(st.nextToken());
    		x = Integer.parseInt(st.nextToken());
    		num = Integer.parseInt(st.nextToken());
    		h[i]= new Horse(y-1,x-1,num-1);
    		// DIR 1:->, 2:<-, 3:up, 4:down
    		list[y-1][x-1].add(i);
        }
        while(true) {
        	ret++;
        	if(ret>1000) {
        		System.out.println("-1");
        		return;
        	}
        	move();
        }
	}
	
	public static class Horse{
		public int y,x,dir;
		public Horse(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
	
	public static void move() {
		int dy[] = {0,0,-1,1};
		int dx[] = {1,-1,0,0};
		for(int i=0; i<k; i++) {
			int ny = h[i].y + dy[h[i].dir];
			int nx = h[i].x + dx[h[i].dir];
//			if(ret<=3) {
//				System.out.println("i="+i+",dir:"+h[i].dir+",ny:"+ny+",nx:"+nx+",dy:"+dy[h[i].dir]+",y:"+h[i].y);
//			}
			if(ny<0 || nx<0 || ny>=n || nx>=n || a[ny][nx]==2) {
				if(h[i].dir %2==0) {
					h[i].dir++;//System.out.println(i+" DIR:"+h[i].dir);
				}else {
					h[i].dir--;//System.out.println(i+" DIR:"+h[i].dir);
				}
				ny = h[i].y + dy[h[i].dir];
				nx = h[i].x + dx[h[i].dir];
				if(ny<0 || nx<0 || ny>=n || nx>=n || a[ny][nx]==2) continue;
			}
			// 한칸 이동
			ArrayList<Integer> now = list[h[i].y][h[i].x]; // 주소 복사.shallow copy
			ArrayList<Integer> next = list[ny][nx];
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			// 위치 찾아서 tmp 로 옮기기
			for(int j=0; j<now.size(); j++) {
				if(now.get(j)==i) {
					for(int k=now.size()-1; k>=j;k--) {
						tmp.add(now.remove(k));
					}
				}
			}
			// 뒤집기
			if(a[ny][nx]!=1) Collections.reverse(tmp);
			// next로 옮기기 && h 배열 갱신
			for(int t=0; t<tmp.size(); t++) {
				next.add(tmp.get(t));
				h[tmp.get(t)].y = ny;
				h[tmp.get(t)].x = nx;
			}
			if(check()) {
				System.out.println(ret);
				System.exit(0);
			}
//			if(ret<=3){
//				System.out.println("RET:"+ret);
//				for(int j=0; j<n; j++) {
//					for(int k=0; k<n; k++) {
//						if(list[j][k].size()==0)
//							System.out.print(list[j][k].size()+" ");
//						else {
//							System.out.print(list[j][k].size()+"(");
//							for(int l: list[j][k]) {
//								System.out.print(l+"-"+h[l].dir+",");
//							}
//							System.out.print(")");
//						}
//					}
//					System.out.println();
//				}
//				System.out.println("=== H ===");
//				for(int j=0; j<n; j++) {
//					System.out.println("i="+j+" y:"+h[j].y+" x:"+h[j].x);
//					
//				}
//			}
		}
	}
	public static boolean check() {
		for(int i=0; i<k; i++) {
			if(list[h[i].y][h[i].x].size()>=4)
				return true;
		}
		return false;
	}
}