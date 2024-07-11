import java.util.*;
import java.io.*;
public class Main {
	
	static int n;
	static double a[], ans;
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("src/input.txt")); // INPUT FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        a = new double[n];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	a[i] = Double.parseDouble(st.nextToken());
        }
        double b=a[0];
        ans = b;
        for(int i=1; i<n; i++) {
        	if(a[i] > b*a[i]) b = a[i];
        	else b*= a[i];
        	ans = Math.max(ans, b);
        }
        System.out.println(String.format("%.3f",ans + 0.00001));
	}
}