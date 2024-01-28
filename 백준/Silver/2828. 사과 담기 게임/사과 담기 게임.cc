#include <bits/stdc++.h>
using namespace std;  

int n, m, j, a[20], ret, temp, now;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> n >> m >> j;
    for(int i=0; i<j; i++){
        cin >> a[i];
    }
    for(int i=0; i<j; i++){
        if( a[i] < now+1 ){
            temp = now+1 - a[i];
            now -= temp;
            ret += temp;
            continue;
        }
        else if (now+m < a[i]){
            temp = a[i] - (now+m);
            now += temp;
            ret += temp;
            continue;
        }
    }
    
    cout << ret << "\n";
    return 0;
}