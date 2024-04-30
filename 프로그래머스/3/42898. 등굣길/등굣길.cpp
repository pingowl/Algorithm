#include <bits/stdc++.h>
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int dp[101][101]; 
    memset(dp,-1,sizeof(int)*101*101);
    for(vector<int> v : puddles){
        dp[v[1]-1][v[0]-1]=0; // puddles
    }
    dp[0][0]=1;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(dp[i][j] != -1) continue;
            
            if(i==0)
                dp[i][j]=dp[i][j-1] % 1000000007;
            else if(j==0)
                dp[i][j]=dp[i-1][j] % 1000000007;
            else
                dp[i][j]=(dp[i][j-1] + dp[i-1][j]) % 1000000007; 
        }
    }    
    return dp[n-1][m-1];
}