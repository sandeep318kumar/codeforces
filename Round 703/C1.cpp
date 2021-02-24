#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

int ask(int l, int r){
    if( l >= r)
        return -1;
    int ans;
    cin>>ans;
    cout<<"? "<<l+1<<" "<<r+1<<endl;
    cout.flush();
    return ans;
}

void solve()
{
    int n;
    cin>>n;

    int l = 0, r = n;
    while( r - l > 1){
        int m = l + (r - l)/2;
        int sm = ask(l, r - 1);
        if(sm < m){
            if(sm == ask(l, m-1)){
                r = m;
            } else{
                l = m+1;
            }
        } else{
            if(sm == ask(m, r-1)){
                l = m+1;
            } else{
                r = m;
            }
        }
    }
    cout<<"! "<<r<<endl;
    cout.flush();
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    #endif

    // ll t;
    // cin>>t;
    // while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    // }
    return 0;
}