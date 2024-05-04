#include <bits/stdc++.h>
#define INF int(10000000)
#define MINF int(-10000000)
using namespace std;

int solution(vector<string> arr)
{
    int n, m;
    n = arr.size(); m = n/2 +1;
    int max_dp[101][101], min_dp[101][101];
    memset(max_dp, -1000000, sizeof(max_dp));
    memset(min_dp, 1000000, sizeof(min_dp));
    
    for(int s = 0; s <m; s++){
        for(int i=0; i<m-s; i++){
            int j = i + s;
            if(s == 0 ){
                max_dp[i][j] = stoi(arr[2 * i]);
                min_dp[i][j] = stoi(arr[2 * i]);
                continue;
            }
            for(int k=i; k<j; k++){
                if( arr[k*2+1] == "+"){
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);

                }
                else {
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                }
            }
        }

    }

    return max_dp[0][m-1];
}