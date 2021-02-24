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
	vector<pair<int, int>>loc(n+1);
	for(int i=0;i<n;i++){
		cin>>A[i];
		loc[A[i]] = {i+1, n-i};

	}

	ll res1 = 0, res2 = 0;

	int q;
	cin>>q;
	for(int i=0;i<q;i++){
		int a;
		cin>>a;
		res1 += loc[a].first;
		res2 += loc[a].second;
	}
	cout<<res1<<" "<<res2;

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