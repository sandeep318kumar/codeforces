#include<bits/stdc++.h>
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

bool prime(int n){
    for(int i = 2;i<= sqrt(n);i++){
        if(n%i == 0)
            return false;
    }
    if(n != 1)
        return true;
    else return false;
}

bool compare(pi a, pi b){
    return a.first < b.first;
}

// magic numbers
void solve()
{
    ll n, k;
    cin>>n>>k;
    string s;
    cin>>s;

    vl A(26, 0);
    for(int i=0;i<s.size();i++){
        A[s[i] - 'A']++;
    }

    sort(A.begin(), A.end());
    // for(auto &i : A)
    //     cout<<i<<" ";
    // cout<<endl;

    ll sum = 0;
    for(int i=25;i>=0;i--){
        if(k > 0){
            if(A[i] <= k){
                sum += A[i] * A[i];
                k -= A[i];
            } else{
                sum += k * k;
                k = 0;
            }
        }
    }
    cout<<sum;
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