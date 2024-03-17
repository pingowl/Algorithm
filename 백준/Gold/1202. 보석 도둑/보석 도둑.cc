#include<bits/stdc++.h>
using namespace std; 
typedef long long ll;
ll n, k, ret, temp1, temp;
int main(){
	ios_base::sync_with_stdio(false);cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> k; 
	vector<pair<ll,ll>> v(n);
	vector<ll> v2(k); 
	for(int i = 0; i < n; i++){
		cin >> v[i].first >> v[i].second; 
	}
	for(int i = 0; i < k; i++) cin >> v2[i]; 
	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end());
	priority_queue<ll> pq; 
	
	int j = 0; 
	for(int i = 0; i < k; i++){
		while(j < n && v[j].first <= v2[i]) pq.push(v[j++].second);
		if(pq.size()){
			ret += pq.top(); pq.pop();
		}
	} 
	cout << ret << "\n"; 
	return 0;
}     