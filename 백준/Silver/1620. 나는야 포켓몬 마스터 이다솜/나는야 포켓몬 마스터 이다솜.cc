#include <bits/stdc++.h>
using namespace std;  

int n, m;
string a[100001], b;
map<string, int> mp;
map<int, string> mp2;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

	cin >> n >> m;
    for (int i=1; i<=n; i++) {
        cin >> b;
        mp[b]=i;
        mp2[i]=b;
        a[i]=b;
    }
    for (int i=0; i<m; i++){
        cin >> b;
        if(!atoi(b.c_str())){
            cout << mp[b] << "\n";
        }
        else{
            cout << mp2[atoi(b.c_str())] << "\n";
        }
    }
    return 0;
}