#include <bits/stdc++.h>
using namespace std;

vector<pair<int,int>> v;
int n, ret, a, b;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> a >> b;
        v.push_back({a,b});
    }
    sort(v.begin(), v.end());
    for(pair<int,int> i: v){
        if(ret < i.first){
            ret = i.first;
        }
        ret += i.second;
    }
    cout << ret << "\n";
    return 0;
}