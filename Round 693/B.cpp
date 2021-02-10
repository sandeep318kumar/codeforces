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
    ll n;
    cin>>n;
    
    ll sumA = 0, sumB = 0;
    ll one = 0, two = 0;
    for(ll i=0;i<n;i++){
        int x;
        cin>>x;
        (x == 1) ? sumA += x: sumB += x;
        (x == 1) ? one++ : two++;
    }
    // if(sumA == sumB){
    //     cout<<"Yes\n";
    //     return;
    // }
    // else if(one % 2 == 0 && two % 2 == 0){
    //     cout<<"Yes\n";
    //     return;
    // }
    // cout<<sumA<<", "<<sumB<<", "<<one<<", "<<two<<endl;
    if(sumA == sumB){
    	cout<<"Yes\n";
    	return;
    } else if( sumA > sumB){
    	if((sumA - sumB) % 2 == 0){
    		cout<<"Yes\n";
    		return;
    	}
    } else{
    	if(((sumB - sumA) % 4 == 0) || 
            ( sumA >= 2 && (sumB - sumA) % 2 == 0 ) ){
    		cout<<"Yes\n";
    		return;
    	}
    }
    cout<<"No\n";
    return;
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