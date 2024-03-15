#include <bits/stdc++.h>
using namespace std;

priority_queue<int, vector<int>, greater<int>> pq; // min heap
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
        ret += i.second;
        pq.push(i.second);
        if(pq.size() > i.first){
            ret -= pq.top();
            pq.pop();
        }
    }
    cout << ret << "\n";
    return 0;
}