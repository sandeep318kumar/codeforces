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
    int n;
    cin>>n;
    vi A(n);
    for(int i = 0;i<n;i++){
        cin>>A[i];
    }

    int m = 10000;
    int ind = -1;
    for(int i=1;i<n;i++){
        // cout<<m<<", "<<abs(A[i] - A[i-1])<<endl;
        if(m > abs(A[i] - A[i-1])){
            // cout<<"Yes\n";
            m = abs(A[i] - A[i-1]);
            ind = i;
        }   
    }

    if(m > abs(A[n-1] - A[0])){
        m = abs(A[n-1] - A[0]);
        ind = n;
    }

    if(ind != n){
        cout<<ind<<" "<<ind+1;
    } else{
        cout<<n<<" "<<1;
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
    // while(t--)
        solve();
    return 0;
}