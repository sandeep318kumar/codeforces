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
    vector<int>cc(n+1, 0);
    if(n%2 != 0){
    	for(int i=1;i<=n;i++){
    		bool flag = true;
    		for(int j = i+1;j<=n;j++){
    			(flag) ? cout<<"1 ": cout<<"-1 ";
    			flag = !flag;
    		}
    	}
    	cout<<endl;
    } else{
    	// cout<<"i am odd\n";
    	// draw locations would be 1, 3, 5, 7
    	for(int i=1;i<=n;i++){
    		bool flag = true, flag2 = true;
    		bool draw = (i%2 != 0)? true : false;
    		for(int j = i+1;j<=n;j++){
    			if(draw){
    				cout<<"0 ";
    				cc[i]++;
    				cc[j]++;
    				draw = false;
    			} else{
    				if(i%2 != 0){
    					if(flag ){
	    					cout<<"1 ";
	    					cc[i] += 3;
	    				} else{
	    					cout<<"-1 ";
	    					cc[j] += 3;
	    				}
	    				flag = !flag;
    				} else{
    					if(flag ){
	    					cout<<"-1 ";
	    					cc[j] += 3;
	    				} else{
	    					cout<<"1 ";
	    					cc[i] += 3;
	    				}
	    				flag = !flag;
    				}
    				
    			}
    		}
    		// cout<<endl;
    	}
    	// cout<<endl;
    	// for(int i=1;i<=n;i++){
    	// 	cout<<i<<"-> "<<cc[i]<<", ";
    	// }
    	cout<<endl;
    }
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