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
    ll mod = 1e9+7;
    ll x, y, n;
    cin>>x>>y>>n;

    ll c;
    ll A[6] = { x - y, x, y, y - x, -x, -y};

    // for(auto &i: A){
    //     cout<<i<<" ";
    // } 
    // cout<<endl;

    c = (A[n%6] % mod + mod) % mod;
    // c = c % mod;
    cout<<c<<endl;
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
    // while(t--)
        solve();
    return 0;
}