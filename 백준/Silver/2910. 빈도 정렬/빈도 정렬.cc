#include <bits/stdc++.h>
using namespace std;  

int n, c, a, b[1000];
map<int, int> mp, mp_first;
vector<pair<int, int>> v;
bool cmp(pair<int,int> a, pair<int, int> b){
    if(a.first==b.first){
        return mp_first[a.second] < mp_first[b.second];
    }
    return a.first > b.first;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
	cin >> n >> c; 
	for(int i = 0; i < n; i++){
		cin >> a; mp[a]++;
		if(mp[a]==1) mp_first[a] = i+1;
	} 
	// mp- key:숫자 ,value:빈도
	// 빈도 기준으로 정렬
	for(auto it: mp){
	    v.push_back({it.second, it.first});
	}
	sort(v.begin(), v.end(), cmp);
    for(auto it: v){
        for(int i=0; i<it.first; i++){
            cout << it.second << " ";
        }
    }
	
    return 0;
}