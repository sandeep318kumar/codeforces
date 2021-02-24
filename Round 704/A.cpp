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
    ll a, b, c, p;
    cin>>p>>a>>b>>c;

    ll i = 0, j = 0, k = 0;
    (p % a == 0) ? i = a * (p/a) : i = (a*(p/a) + a);
    (p % b == 0) ? j = b * (p/b) : j = (b*(p/b) + b);
    (p % c == 0) ? k = c * (p/c) : k = (c*(p/c) + c);

    cout<<min(i-p, min(j-p, k-p))<<endl;    
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}