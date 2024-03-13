#include <bits/stdc++.h>
using namespace std;

string a, b, ret;
stack<char> s;
int main() {
    cin >> a >> b;
    for(char c : a){
        s.push(c);
        if( s.size() >= b.size() && s.top() == b[b.size()-1]){
            string tmp;
            for(int i=0; i<b.size(); i++){
                tmp += s.top();
                s.pop();
            }
            reverse(tmp.begin(), tmp.end());
            if( tmp != b){
                for(char cc: tmp){
                    s.push(cc);
                }
            }
        }
    }
    if(s.size()==0) cout << "FRULA\n";
    else {
        while(s.size()){
            ret += s.top();
            s.pop();
        }
        reverse(ret.begin(), ret.end());
        cout << ret << "\n";
    }
    return 0;
}
