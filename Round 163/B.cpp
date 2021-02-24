#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

// 5 2
// BGGBG
// GGBGB

// 4 1
// GGGB 
// GGGB

void solve()
{
	// 5 1
	// BGGBG

    ll n, t;
    cin>>n>>t;
    string s;
    cin>>s;

    for(int i = 0;i<t;i++){
    	int j = 0;
    	while(j < n - 1){
    		if(s[j] == 'B' && s[j+1] == 'G')
    			swap(s[j], s[j+1]), j += 2;
    		else
    			j += 1;
    	}
    }
    cout<<s<<endl;
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

    solve();
    return 0;
}