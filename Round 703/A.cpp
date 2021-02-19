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
    vector<ll>A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }
    if(A[0] == 0){
    	cout<<"No\n";
    	return ;
    }

    int d = A[0] - A[n-1];
    if(d > 0){
    	A[n-1] += d;
    	A[0] -= d;

    } 
    if(( d == 0 && A[0] != 0 )){
    	A[n-1] += 1;
    	A[0] -= 1;
    }

    int i = 1, j = n-2;
    while(i < j){
    	cout<<i<<", "<<j<<endl;
    	// for ballancing A[1]
    	if(A[i] <= A[i-1]){
    		cout<<"first\n";
    		if(A[i] == A[i-1] && A[i-1] != 0){
    			A[i]++;
    			A[i-1]--;
    		} 
 			int d1 = A[i-1] - A[i];
 			if(A[i-1] != 0 && d1 > 0){
 				A[i] += d1;
 				A[i-1] -= d1;
 			}
    	}

    	// for balancing A[n-1]
    	if(A[j] >= A[j+1]){
    		cout<<"second\n";
    		if(A[j] == A[j+1] && A[j] != 0){
    			A[j+1]++;
    			A[j]--;
    		}

    		int d2 = A[j] - A[j+1];
    		if(A[j] != 0 && d2 > 0){
    			A[j+1] += d2;
    			A[j] -= d2;
    		}
    	}


    	// now balacing A[i], A[j]
    	if(A[i] >= A[j]){
    		cout<<A[i]<<", "<<A[j]<<endl;
    		cout<<"Here\n";
    		if(A[i] == A[j] && A[i] != 0){
    			A[i]--;
    			A[j]++;
    		}

    		int d3 = A[i] - A[j];
    		if(A[i] != 0 && d3 > 0){
    			A[j] += d3;
    			A[i] -= d3;
    		}
    		cout<<A[i]<<", "<<A[j]<<endl;
    	}

    	if(A[i] <= A[i-1]){
    		cout<<"first1\n";
    		if(A[i] == A[i-1] && A[i-1] != 0){
    			A[i]++;
    			A[i-1]--;
    		} 
 			int d1 = A[i-1] - A[i];
 			if(A[i-1] != 0 && d1 > 0){
 				A[i] += d1;
 				A[i-1] -= d1;
 			}
    	}

    	// for balancing A[n-1]
    	if(A[j] >= A[j+1]){
    		cout<<"second1\n";
    		if(A[j] == A[j+1] && A[j] != 0){
    			A[j+1]++;
    			A[j]--;
    		}

    		int d2 = A[j] - A[j+1];
    		if(A[j] != 0 && d2 > 0){
    			A[j+1] += d2;
    			A[j] -= d2;
    		}
    	}
    	// increase
    	i++;
    	j--;
    }

    // d = A[0] - A[n-1];
    // if(d > 0){
    // 	A[n-1] += d;
    // 	A[0] -= d;

    // } 
    // if(( d == 0 && A[0] != 0 )){
    // 	A[n-1] += 1;
    // 	A[0] -= 1;
    // }

    // i = 1, j = n-2;
    // while(i < j){
    // 	// cout<<i<<", "<<j<<endl;
    // 	// for ballancing A[1]
    // 	if(A[i] <= A[i-1]){
    // 		// cout<<"first\n";
    // 		if(A[i] == A[i-1] && A[i-1] != 0){
    // 			A[i]++;
    // 			A[i-1]--;
    // 		} 
 			// int d1 = A[i-1] - A[i];
 			// if(A[i-1] != 0 && d1 > 0){
 			// 	A[i] += d1;
 			// 	A[i-1] -= d1;
 			// }
    // 	}

    // 	// for balancing A[n-1]
    // 	if(A[j] >= A[j+1]){
    // 		// cout<<"second\n";
    // 		if(A[j] == A[j+1] && A[j] != 0){
    // 			A[j+1]++;
    // 			A[j]--;
    // 		}

    // 		int d2 = A[j] - A[j+1];
    // 		if(A[j] != 0 && d2 > 0){
    // 			A[j+1] += d2;
    // 			A[j] -= d2;
    // 		}
    // 	}


    // 	// now balacing A[i], A[j]
    // 	if(A[i] >= A[j]){
    // 		// cout<<A[i]<<", "<<A[j]<<endl;
    // 		// cout<<"Here\n";
    // 		if(A[i] == A[j] && A[i] != 0){
    // 			A[i]--;
    // 			A[j]++;
    // 		}

    // 		int d3 = A[i] - A[j];
    // 		if(A[i] != 0 && d3 > 0){
    // 			A[j] += d3;
    // 			A[i] -= d3;
    // 		}
    // 		// cout<<A[i]<<", "<<A[j]<<endl;
    // 	}
    // 	// increase
    // 	i++;
    // 	j--;
    // }

    for(auto &i:A){
    	cout<<i<<" ";
    }
    // cout<<endl;
    bool flag = true;
    for(int i=1;i<n;i++){
    	if(A[i] <= A[i-1]){
    		flag = false;
    		break;
    	}
    }
    if(flag){
    	cout<<"Yes\n";
    } else{
    	cout<<"No\n";
    }
}

void solve1()
{
	ll n;
    cin>>n;
    vector<ll>A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }
    // if(A[0] == 0){
    // 	cout<<"No\n";
    // 	return ;
    // }

    for(int i = 0;i<n;i++){
    	for(int j = 0;j<n-1;j++){
    		if(A[j] >= A[j+1]){
    			int d = A[j] - A[j+1];
    			if(d == 0 && A[j] != 0){
    				A[j] -= 1;
    				A[j+1] += 1;
    			}

    			if(d > 0 && A[j] != 0){
    				A[j] -= d;
    				A[j+1] += d;
    			}
    		}
    	}
    }
    bool flag = true;
    for(int i=1;i<n;i++){
    	if(A[i] <= A[i-1]){
    		flag = false;
    		break;
    	}
    }
    if(flag){
    	cout<<"Yes\n";
    } else{
    	cout<<"No\n";
    }
}
void solve2(){
	ll n;
    cin>>n;
    vector<ll>A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }
    ll sum = 0;
    for(int i = 0;i<n;i++){
    	sum += A[i];
    	// cout<<sum<<", "<<i<<" ";
    	if(i > sum - i){
    		cout<<"No\n";
    		return;
    	}
    }
    cout<<"Yes\n";
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve2();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}