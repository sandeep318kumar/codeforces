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
    int n, k;
    cin>>n>>k;
    string s;
    cin>>s;


    int cc = 0;
    bool flag = false;

    int i = 0, j = n-1;
    while(i < j && cc < k){
    	if(s[i] == s[j]){
    		cc++;
    	} else{
    		flag = true;
    		break;
    	}
    	i++;
    	j--;
    }

    if(flag || ( cc != k)){
    	cout<<"NO\n";
    } else if( cc == k && ( i <= j)){
    	cout<<"Yes\n";
    } else{
    	cout<<"No\n";
    }
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