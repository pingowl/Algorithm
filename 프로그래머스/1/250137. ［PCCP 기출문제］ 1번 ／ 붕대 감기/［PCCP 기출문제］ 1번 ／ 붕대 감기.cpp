#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int ans = health;
    int l = attacks.size(); 
    int j=0, cnt=0;
    for(int i=1; i<= attacks[l-1][0]; i++){
        if(j<l && attacks[j][0]==i){
            ans -= attacks[j][1];
            cnt=0; j++;
        }
        else {
            cnt++;
            if(cnt==bandage[0]) {
                ans += bandage[2];
                cnt=0;
            }
            ans += bandage[1];
            if(ans >= health) {
                ans = health;
                cnt=0;
            }
        }
        
        if(ans <= 0) {
            ans=-1;
            break;
        }    
    }
    return ans;
}