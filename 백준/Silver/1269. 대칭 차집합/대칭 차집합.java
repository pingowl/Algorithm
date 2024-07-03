import java.util.*;
import java.io.*;
public class Main {
	
	static int a, b, ret;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        HashSet<Integer> s = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		int union = s.size();
		ret = union*2  -a -b;
		System.out.println(ret);
	}
}