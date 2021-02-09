#include<bits/stdc++.h>
using namespace std;

bool check(vector<int>A, int d){
    for(int i:A){
        if(i > d)
            return true;
    }
    return false;
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int n, d;
        cin>>n>>d;
        vector<int>A(n);
        for(int i=0;i<n;i++)
            cin>>A[i];
        
        if(check(A, d) == false){
            cout<<"YES\n";
        } else{
            sort(A.begin(), A.end());
            int sum = A[0] + A[1];
            if(sum <= d)
                cout<<"YES\n";
            else cout<<"NO\n";
        }
    }
    return 0;
}
