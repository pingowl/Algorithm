#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> v;
int n, ret, s, e, now;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s >> e;
        v.push_back({e,s});
    }
    sort(v.begin(), v.end()); 
    for(pair<int,int> i: v){
        if(now <= i.second){ 
            now = i.first;
            ret++;
        }
    }
    cout << ret << "\n";
    return 0;
}