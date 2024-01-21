#include <bits/stdc++.h>
using namespace std;  

typedef long long ll;
ll a, b, c;

ll f(ll a , ll b){
    if(b==1) return a%c;
    ll r = f(a,b/2);
    r = (r*r)%c;
    if(b%2) r = r*a%c;// 홀수
    return r;
}

int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> a >> b >> c;
    cout << f(a,b) << "\n";
    return 0;
}