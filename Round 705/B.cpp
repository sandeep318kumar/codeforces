#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

int A[10];

bool check(int h, int m, int hi, int mi){
	string min = to_string(mi);
	string hour = to_string(hi);

	if(min.size() == 1){
		min = "0" + min;
	} 
	if(hour.size() == 1){
		hour = "0" + hour;
	} 

	string time = hour + min;
	string rev;
	for(int i = time.size() - 1;i>=0;i--){
		if(A[time[i] - '0'] != -1){
			rev.push_back(A[time[i] - '0'] + '0');
		} else{
			return false;
		}
	}
	
	// cout<<"reverse is: "<<rev<<"\n";
	int newh = (rev[0] - '0') * 10 + (rev[1]- '0');
	int newm = (rev[2] - '0') * 10 + (rev[3] - '0');

	if(newh < h && newm < m){
		return true;
	} else{
		return false;
	}

}
void solve()
{
    int h, m;
    cin>>h>>m;

    string s;
    cin>>s;

    memset(A, -1, sizeof(A));
    A[0] = 0;
    A[1] = 1;
    A[2] = 5;
    A[5] = 2;
    A[8] = 8;

    int hi = (s[0] - '0') * 10 + (s[1] - '0');
    int mi = (s[3] - '0') * 10 + (s[4] - '0');

    // cout<<h<<" "<<m<<" "<<hi<<" "<<mi<<endl;

    while(!check(h, m, hi, mi)){
    	mi++;
    	if(mi == m){
    		mi = 0;
    		hi++;
    	}
    	// hi = hi % h;
    	// mi = mi % m;
    	if(hi == h){
    		hi = 0;
    	}
    }
    string hour = to_string(hi);
    string min = to_string(mi);

    if(min.size() == 1){
		min = "0" + min;
	} 
	if(hour.size() == 1){
		hour = "0" + hour;
	}

    cout<<hour<<":"<<min<<endl;
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