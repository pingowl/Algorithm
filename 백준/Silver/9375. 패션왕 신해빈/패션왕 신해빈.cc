#include <bits/stdc++.h>
using namespace std;  

int t, n, ans;
string a, b;
map<string, int> mp;
vector<string> v;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

	cin >> t;
    for(int i=0; i<t; i++){
        cin >> n;
        ans=1;
        for (int j=0; j<n; j++){
            cin >> a >> b;
            auto it = mp.find(b);
            if(it == mp.end()) {
                mp[b]=1;
                v.push_back(b);
            }
            else {
                mp[b]++;
            }
        }
        for(int j=0; j<v.size(); j++){
            ans *= mp[v[j]] +1;
        }
        ans--; 
        cout << ans << "\n";
        mp.clear(); v.clear();
    }
    return 0;
}