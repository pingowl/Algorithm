#include <unordered_set>
#include <vector>

using namespace std;

int getNs(int N, int idx){
    // idx=1: NN
    int res = N;
    for(int i=0; i<idx; i++){
        res = res*10 + N;
    }
    return res;
}
int solution(int N, int number) {
    if(N == number) return 1;
    
    vector<unordered_set<int>> dp(8);
    dp[0].insert(N);
    
    for(int k=1; k<8; k++){
        dp[k].insert(getNs(N,k));
        
        for(int i=0; i<k; i++){
            int j = k-1-i;
            for(int a : dp[i]){
                for(int b: dp[j]){
                    dp[k].insert(a+b);
                    dp[k].insert(a*b);
                    if(a-b > 0) dp[k].insert(a-b);
                    if(a/b > 0) dp[k].insert(a/b);
                }
            }
        }
        if(dp[k].find(number) != dp[k].end())
            return k+1;
    }
    return -1;
}