#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

void solve()
{
    int n;
    cin>>n;
    vi A(n);
    for(int i=0;i<n;i++){
        cin>>A[i];
    }
    
    vi B(n);
    int m = 0;
    for(int i=0;i<n;i++){
        m = max(A[i], m);
        B[i] = m;
    }
    
    // cout<<"Hello\n";
    vi ans;
    int j = n;
    for(int i=n-1;i>=0;i--){
        if(A[i] == B[i]){
            for(int k = i;k<j;k++){
                ans.push_back(A[k]);
            }
            j = i;
        }
    }

    for(auto &s:ans)
        cout<<s<<" ";
    cout<<endl;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}