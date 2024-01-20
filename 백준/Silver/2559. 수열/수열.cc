#include <bits/stdc++.h>
using namespace std;  

int n, k, a[100000], psum[100000], temp, now;

int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

	cin >> n >> k;
    for (int i=0; i<n; i++) {
        cin >> a[i];
        temp +=a[i];
        psum[i]=temp;
    }
    now = psum[k-1];
    for (int i=k; i<n; i++){
        temp = 0;
        temp = psum[i] - psum[i-k]; 
        if(temp>now) now = temp;
    }
    cout << now;
    return 0;
}