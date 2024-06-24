import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int N;
	static double[] x = new double[10];
	static int[] m = new int[10];
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			for(int i=0; i<N; i++){
			    x[i] = sc.nextDouble();
			}
			for(int i=0; i<N; i++){
			    m[i] = sc.nextInt();
			}

            System.out.print("#"+test_case+" ");
            for(int i=0; i<N-1; i++){
                find(i, x[i], x[i+1]);
            }
            System.out.println();
		}
	}
	
	// 이분탐색
	static void find(int idx, double left, double right){
	    double mid = 0.0;
	    double sum = 0.0;
	    
	    // 오차가 10^-12보다 작아야하므로 100번 반복
	    for(int i=0; i<100; i++){
	        mid = (left+right)/2.0;
	        sum = 0.0;
	        // 왼쪽 인력 합 계산
	        for(int j=0; j<=idx; j++){
	            sum += calc(j, mid);
	        }
	        // 오른쪽 인력 합 계산
	        for(int j = N-1; j>idx; j--){
	            sum -= calc(j, mid);
	        }
	        
	        if(sum > 0.0) // 왼쪽힘>오른쪽힘 : 더 오른쪽으로 가야함 
	            left = mid;
            else if (sum <0.0) 
                right = mid;
	    }
	    
	    System.out.printf("%.10f ", mid);
	}
	
	// calculate F = G*m1*m2/(d*d)
	static double calc(int i, double mid){
	    return m[i] / Math.pow(x[i]-mid, 2.0);
	}
}