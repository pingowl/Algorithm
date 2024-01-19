#include <bits/stdc++.h>
using namespace std;  

string word;
int ans, len;
void solve(){ 
    len = word.size();
    for (int i=0; i<len/2; i++){
        if(word[i]!=word[len-1-i]){
            ans = 0;
            return;
        }
    }
    ans = 1;
}



int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> word;
    
    solve();
    cout << ans;
    return 0;
}