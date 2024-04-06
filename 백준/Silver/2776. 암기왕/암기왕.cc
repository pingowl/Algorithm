#include <bits/stdc++.h>
using namespace std;
int t, n, m, a;

int chk(int a, vector<int> &v){
    int l=0, r=n-1, mid;
    while(l<=r){
        mid = (l+r)/2;
        if(v[mid] < a) l = mid+1;
        else if(v[mid] > a) r = mid-1;
        else return 1;
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> t;
    while(t--){
        vector<int> v;
        cin >> n;
        for(int i=0; i<n; i++) {cin >> a; v.push_back(a);}
        sort(v.begin(), v.end());
        cin >> m; 
        for(int i=0; i<m; i++) {cin >> a; cout << chk(a,v) << "\n";}
    }
    return 0;
}