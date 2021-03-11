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

    vector<ll>x, y;

    for(int i=0;i<2*n;i++){
    	int a, b;
    	cin>>a>>b;
    	if(a == 0) y.push_back(abs(b));
        else    x.push_back(abs(a));
    }
    cout<<setprecision(16);
    double sum = 0;

    sort(x.begin(), x.end());
    sort(y.begin(), y.end());

    for(int i=0;i<n;i++){
        double s = (x[i] * x[i]) + (y[i] * y[i]);
        double s1 = sqrt(s);
        sum += s1;
    }
    cout<<sum<<endl;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll t;
    cin>>t;
    while(t--)
        solve();
    return 0;
}