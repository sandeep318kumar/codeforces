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
    int n, m;
    cin>>n>>m;
    string s, t;
    cin>>s>>t;
       // s.push_back('#');
    sort(s.begin(), s.end());
    sort(t.begin(), t.end());

    vi ans;
    vi res;
    int j = n;

    int l = n - m + 1;
    string part = s.substr(l);
    int k  = s.find(m[0]);
    ans.push_back(k);
    res.push_back(k);

    for(int i=1;i<m;i++){
        char a = t[i];
        int len = n - (m - i) + 1;
        string p = s.substr(k+1, len);
        
    }


    int m1 = 0;
    for(int i = 1;i<ans.size();i++){  
        m1 = max(m1, ans[i] - ans[i-1]);
    }
    cout<<m1;
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