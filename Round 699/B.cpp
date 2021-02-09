#include<bits/stdc++.h>
using namespace std;

void solve(){
    int n, k;
    cin>>n>>k;
    vector<int>A(n);
    for(int i=0;i<n;i++)
        cin>>A[i];

    int ptr = 0;
    while(ptr < n - 1 && k > 0){
        if(A[ptr] >= A[ptr+1]){
            ptr++;
        } else{
            A[ptr]++;
            k--;
            if(k > 0)
                ptr = 0;
        }
    }
    // cout<<"Ptr is: "<<ptr<<endl;
    // for(auto &i: A){
    //     cout<<i<<" ";
    // }
    // cout<<endl;
    if(ptr == n-1 && k > 0)
        cout<<"-1\n";
    else cout<<ptr+1<<endl;
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        solve();
    }
    return 0;
}
