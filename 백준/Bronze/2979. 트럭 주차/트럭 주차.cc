#include <bits/stdc++.h>
#include <utility>
using namespace std;  

int a[3];
vector<pair<int, int>> v;
pair<int, int> p;
int psum[101];
int ans;

void solve(){ 
    for(pair<int, int> p: v){
        for (int i=p.first; i<p.second; i++){
            psum[i]++;
        }
    }
    int cnt=0;
    for (int i=0; i<3; i++){
        for(int j=0; j<101; j++){
            if(psum[j]==i+1) cnt++;
        }
        ans+= a[i]*cnt*(i+1);
        cnt = 0;
    }
}



int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    for (int i=0; i<3; i++) cin >> a[i];
    for (int i=0; i<3; i++){
        cin >> p.first >> p.second;
        v.push_back(p);
    }
    
    solve();
    cout << ans;
    return 0;
}