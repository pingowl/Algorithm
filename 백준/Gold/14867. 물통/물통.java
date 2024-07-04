import java.util.*;
import java.io.*;
public class Main {
	
	static int a,b,c,d;
	static Map<Pair, Integer> m = new HashMap<>();
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(0,0));
	}
	
	public static int bfs(int x, int y) {
		Pair p = new Pair(x,y);
		m.put(p,1);
		q.add(p);
		while(!q.isEmpty()) {
			Pair p2 = q.poll();
			x = p2.x;
			y = p2.y;
			
			enqueue(a,y,m.get(p2));
			enqueue(x,b,m.get(p2));
			enqueue(0,y,m.get(p2));
			enqueue(x,0,m.get(p2));
			enqueue(Math.min(a, x+y), Math.max(x+y-a, 0),m.get(p2));
			enqueue(Math.max(x+y-b,0), Math.min(b, x+y),m.get(p2));
		}
		Pair target = new Pair(c,d);
		if (m.containsKey(target)) return m.get(target)-1;
		else 
			return -1;
	}
	
	public static void enqueue(int x, int y, int d) {
		if(x<0 || y<0 || x>a || y>b) return;
		Pair p = new Pair(x,y);
		if(m.containsKey(p)) return;
		m.put(p, d+1);
		q.add(p);
	}
	
	public static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o==null || getClass() != o.getClass()) return false;
			Pair p = (Pair) o;
			return x==p.x && y==p.y;
		}
		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
	}
}