import java.util.*;
import java.io.*;
public class Main {
	static int n, s[], t[];
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        s = new int[2]; 
        t = new int[2];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int t = toSecond(st.nextToken());
        	map.put(t,a-1);
        }
        int tmp=0;
        for(int time: map.keySet()) {
        	if(s[0]<s[1]) {
        		t[1] += time-tmp;
        	}else if(s[0]>s[1]) {
        		t[0] += time-tmp;
        	}
        	s[map.get(time)]++;
        	tmp = time;
        }
        if(s[0]<s[1]) {
    		t[1] += 48*60-tmp;
    	}else if(s[0]>s[1]) {
    		t[0] += 48*60-tmp;
    	}
        
        System.out.println(toClock(t[0]));
        System.out.println(toClock(t[1]));
	}
	
	static int toSecond(String t) {
		String[] sp = t.split(":");
		int m = Integer.parseInt(sp[0]);
		int s = Integer.parseInt(sp[1]);
		return m*60 + s;
	}
	static String toClock(int sec) {
		String m = Integer.toString(sec/60);
		String s = Integer.toString(sec % 60);
		m = (m.equals("0"))? "00": (m.length()==1 ? "0"+m : m);
		s = (s.equals("0"))? "00": (s.length()==1 ? "0"+s : s);
		return m + ":" + s;
	}
}