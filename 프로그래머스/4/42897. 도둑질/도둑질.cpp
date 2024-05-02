#include <string>
#include <vector>

using namespace std;
int dp[1000001];
int solution(vector<int> money) {
    int answer = 0;
    int n = money.size();
    
    // 0번째 집 선택 O
    dp[0] = money[0];
    dp[1] = money[0];
    for(int i=2; i< n-1; i++){
        dp[i] = max(dp[i-1], dp[i-2] + money[i]);
    }
    answer = dp[n-2];
    
    // 0번째 집 선택 X
    dp[0] = 0;
    dp[1] = money[1];
    for(int i=2; i<= n-1; i++){
        dp[i] = max(dp[i-1], dp[i-2] + money[i]);
    }
    return answer = (answer < dp[n-1]) ? dp[n-1]: answer;
}