#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

// 2 
// 1 2

// 2
// 2 1 2
// 1 1 2


// 3 
// 3 1
// 1 3

// 3
// 2 2 3
// 1 1 3
// 1 1 2

void print(vvi A){
	for(auto i:A){
		for(auto j: i){
			cout<<j<<" ";
		}
		cout<<endl;
	}
	cout<<endl;
}

void solve()
{
    int n;
    cin>>n;
    vvi ans;
    vvi A(n, vi(n, 0));
    vi row(n, 0);
    vi col(n, 0);
    for(int i = 0;i<n-1;i++){
    	int x, y;
    	cin>>x>>y;
    	--x;
    	--y;
    	A[x][y] = 1;
    	row[x]++;
    	col[y]++;
    }

    // print(A);
    while(n > 1){
    	// checing the col which is 0
    	if(col[n-1] != 0){
    		// cout<<"Last column is not null\n";
    		// print(A);
    		// needs to replace col
    		int tar = 0;
    		for(int i = 0;i<n;i++){
    			if(col[i] == 0){
    				tar = i;
    				break;
    			}
    		}
    		// replacing the col
    		for(int i = 0;i<n;i++){
    			swap(A[i][tar], A[i][n-1]);
    		}
    		ans.push_back({2, tar+1, n});
    	}

    	// now needs to replace row
    	// cout<<"checking for row\n";
    	// print(A);
    	int tar = -1;
    	for(int i = 0;i<n;i++){
    		if(row[i] >= 1){
    			tar = i;
    			break;
    		}
    	}
    	// replacing the row
    	if(tar != n-1){
	    	for(int i = 0;i<n;i++){
	    		swap(A[tar][i], A[n-1][i]);
	    	}
   	 	}	
    	ans.push_back({1, tar+1, n});

    	// update the col and row values
    	for(int i = 0;i<n;i++){
    		col[i] = 0;
    		row[i] = 0;
    	}
    	n--;
    	for(int i=0;i<n;i++){
    		for(int j = 0;j<n;j++){
    			if(A[i][j] == 1){
    				row[i]++;
    				col[j]++;
    			}
    		}
    	}
    }
    cout<<ans.size()<<"\n";
    for(int i = 0;i<ans.size();i++){
    	cout<<ans[i][0]<<" "<<ans[i][1]<<" "<<ans[i][2]<<"\n";
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

    // ll t;
    // cin>>t;
    // while(t--){ 
        solve();
        cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    // }
    return 0;
}