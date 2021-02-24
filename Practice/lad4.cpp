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
    double lb, bh, lh;
    cin>>lb>>bh>>lh;

    double bdivl = (double)bh/lh;

    double l, b, h;
    l = sqrt(lb/bdivl);
    h = (double)lh/l;
    b = (double)bh/h;

    cout<<4*(l + h + b);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    // cout.tie(NULL);
    
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