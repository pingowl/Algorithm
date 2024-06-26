#include <string>
#include <vector>
using namespace std;

int solution(vector<vector<int>> triangle) {
    int length = triangle.size() - 1;
    int answer = 0;
    int dp[501][501];
    dp[0][0] = triangle[0][0];
    
    for(int i = 1 ; i <= length ; i++) {
        for(int j = 0 ; j <= i ; j++) {
            if(j == 0) { 
                dp[i][j] = dp[i-1][j];
            }
            else if(j == i) { 
                dp[i][j] = dp[i-1][j-1];
            }
            else {
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]);
            }
            dp[i][j] += triangle[i][j];
        }
    }
    
    answer = dp[length][0];
    for(int i = 1 ; i <= length ; i++) {
        if(dp[length][i] > answer) {
            answer = dp[length][i];
        }
    }
    
    return answer;
}