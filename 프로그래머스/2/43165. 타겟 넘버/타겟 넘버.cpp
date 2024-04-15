#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> numbers, int target) {
    int cnt = 0;
    int n = numbers.size();
    for(int i=0; i<pow(2,n); i++){
        int tmp=0;
        for(int j=0; j<n; j++){
            if(i & (1<<j))
                tmp += numbers[j];
            else
                tmp -= numbers[j];
        }
        if(tmp==target) cnt++;
    }    
    return cnt;
}