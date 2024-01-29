#include <bits/stdc++.h>
using namespace std;  

string s;
char a[]={'a','e','i','o','u'}, pre;
int flag, vcnt, ccnt, contains_vowel;

bool is_vowel(char c){
    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
    return false;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
	while(1){
	    cin >> s;
	    if(s.compare("end")==0) break;
	    vcnt=0; ccnt=0; contains_vowel=0; flag=0;
	    for(int i=0; i<s.size(); i++){
	        char c = s[i];
	        if(is_vowel(c)) {vcnt++; contains_vowel=1; ccnt=0;}
	        else {ccnt++;vcnt=0;}
	        if(ccnt==3 || vcnt==3) flag=1;
	        if(i!=0 && pre==c && c!='e' && c!='o') flag=1;
	        if(flag==1)break;
	        pre = c;
	    }
	    if(contains_vowel==0) flag=1;
	    if(flag==1) cout <<"<"<<s<<"> is not acceptable.\n";
	    else cout <<"<"<<s<<"> is acceptable.\n";
	}
	
    return 0;
}