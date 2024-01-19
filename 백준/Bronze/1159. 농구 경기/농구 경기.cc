#include <bits/stdc++.h>
using namespace std;  

int n, abc[26];
string b, ans;
void solve(){ 
    for(int i=0; i<26; i++){
        if(abc[i]>=5) ans += char(i+'a');
    }
    if(ans=="") ans = "PREDAJA";
    cout << ans << "\n";
}


int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> n;
    for (int i=0; i<n; i++){
        cin >> b;
        abc[b[0]-'a']++;
    }
    
    solve();
    return 0;
}