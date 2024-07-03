import java.util.*;
import java.io.*;
public class Main {
	
	static int t, n, m, ret;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        t = Integer.parseInt(br.readLine());
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[] a = new int[n]; int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
            	a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
            	b[i] = Integer.parseInt(st.nextToken());
            
            Arrays.sort(a); Arrays.sort(b);
            ret = 0;
            for(int i=n-1; i>=0; i--) {
            	if(a[i]<b[0]) break;
            	for(int j=m-1; j>=0; j--) {
            		if(a[i]>b[j]) {
            			ret += j+1;
            			break;
            		}
            	}
            }
            
            System.out.println(ret);
        }
	}
}