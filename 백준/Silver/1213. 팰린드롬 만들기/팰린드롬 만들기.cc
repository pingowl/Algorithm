#include <bits/stdc++.h>
using namespace std;  

int abc[26], cnt, center;
string a, ans, temp;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    
    cin >> a;
    for (int i=0; i<a.size(); i++){
        abc[int(a[i]-'A')]++;
    }
    for (int i=0; i<26; i++){
        if(abc[i]%2==1) {
            cnt++;
            center = i;
        }
    }
    if(cnt>1){
        cout << "I'm Sorry Hansoo\n";
    }
    else{
        for(int i=0; i<26; i++){
            for(int j=0; j<abc[i]/2; j++) ans += char('A'+i);
        }
        temp = ans;
        reverse(temp.begin(), temp.end());
        if(cnt!=0){
            ans += char('A'+center);
        }
        ans += temp;
        cout << ans << "\n";
    }
    return 0;
}