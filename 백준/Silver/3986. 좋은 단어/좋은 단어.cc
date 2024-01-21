#include <bits/stdc++.h>
using namespace std;  

string s;
int n, cnt;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> s;
        stack<char> st;
        for( char c: s){
            if(st.size() && st.top()==c) st.pop();
            else st.push(c);
        }
        if(st.size()==0) cnt++;
    }
    
    cout << cnt << "\n";
    return 0;
}