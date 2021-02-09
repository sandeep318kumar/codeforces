#include<bits/stdc++.h>
using namespace std;

int check(vector<int> v){
    int n = v.size();
    for(int i = 1;i<n-1;i++){
        if(v[i] < v[i-1] && v[i] < v[i+1])
            return i+1;
    }
    return 0;
}
void solve()
{
    int n;
    cin>>n;
    vector<int>A(n);
    for(int i=0;i<n;i++)
        cin>>A[i];
    if(n <= 100){
        // just check for local min and print values
        int localmin = check(A);
        for(int i=1;i<=n;i++){
            cout<<"? "<<i<<endl;
        }
        cout<<"! "<<localmin<<endl;
    } else{
        int i = 0;
        while(i < n){
            // now check first 100 then next 100
            vector<int>v;
            for(int j=0;j<100 && i<n;j++){
                v.push_back(A[i]);
                i++;
                j++;
            }
            int local = check(v);
            if(local != 0){
                // means here we have local min found so break
                for(int i=1;i<=n;i++){
                    cout<<"? "<<i<<endl;
                    fflush(stdout);
                }
                cout<<"! "<<local + ((n/100)*100)<<endl;
                fflush(stdout);
                break;
            }
        }
    }
}
int main()
{
    // int t;
    // cin>>t;
    // while(t--){ 
        solve();
        fflush(stdout);
    // }
    return 0;
}
