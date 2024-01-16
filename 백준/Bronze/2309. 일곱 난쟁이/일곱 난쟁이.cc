#include <bits/stdc++.h>
using namespace std;

int a[9];
int main() {
    for( int i=0; i<9; i++){
        cin >> a[i]; 
    }
    int sum = 0;
    for (int i=0; i<9; i++){
        for (int j=i+1; j<9; j++){
            sum =0;
            for (int k=0; k<9; k++){
                if(k==i || k==j){
                    continue;
                }
                sum +=a[k];
            }
            if (sum==100){
                a[i]=0; a[j]=0;
                sort(a, a+9);
                for (int p=2; p<9; p++){
                    cout <<  a[p] << "\n";
                }
                break;
            }
        }
    }

    return 0;
}