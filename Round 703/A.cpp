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
    while(i < p)
        i += a;

    while(j < p)
        j += b;

    while(k < p)
        k += c;

    cout<<min(i-p, min(j-p, k-p))<<endl;

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

    ll t;
    cin>>t;
    while(t--)
        solve();
    return 0;
}