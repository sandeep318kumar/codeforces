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
    ll n, x;
    cin>>n>>x;
    vector<ll>A(n);
    ll sum = 0;
    ll max_value = 0;
    for(ll i=0;i<n;i++){
        cin>>A[i];
        max_value += ceil(A[i]/(double)x);
        sum += A[i];
    }
    ll min_value = ceil(sum/(double)x);
    cout<<min_value<<" "<<max_value<<endl;
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