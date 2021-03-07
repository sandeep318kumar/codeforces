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

   set<int>st;
   for(int i=n;i>=1;i--){
	   	if(i > k){
	   		st.insert(i);
	   	} else{
	   		break;
	   	}
   }

  
   for(int i=k-1;i>=1;i--){
   		if(st.count(k - i) == 0){
   			st.insert(i);
   		}
   }

   cout<<st.size()<<endl;
   for(auto &i: st){
   		cout<<i<<" ";
   }
   cout<<endl;
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