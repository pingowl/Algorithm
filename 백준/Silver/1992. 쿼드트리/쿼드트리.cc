#include <bits/stdc++.h>
using namespace std;  

char a[65][65]; 
string s;
int n;
string go(int y, int x, int size){
    if(size==1) return string(1, a[y][x]);
    char b = a[y][x];
    string ret = "";
    for(int i=y; i<y+size; i++){
        for(int j=x; j<x+size; j++){
            if(b != a[i][j]){
                ret += '(';
                ret += go(y, x, size/2);
                ret += go(y, x + size/2, size/2);
                ret += go(y + size/2, x, size/2);
                ret += go(y + size/2, x +size/2, size/2);
                ret += ')';
                return ret;
            }
        }
    }
    return string(1,a[y][x]);
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s;
        for(int j=0; j<n; j++){
            a[i][j] = s[j];
        }
    }
    cout << go(0, 0, n) <<'\n';
    return 0;
}