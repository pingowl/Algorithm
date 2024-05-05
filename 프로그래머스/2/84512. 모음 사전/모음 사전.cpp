#include <bits/stdc++.h>
using namespace std;

int solution(string word) {
    int answer = 0, n;
    n = word.size();
    string s = "AEIOU";
    int a[] = {781, 156, 31, 6, 1};
    answer += n;
    for(int i=0; i<n; i++){
        answer += a[i]*s.find(word[i]);
    }
    
    return answer;
}