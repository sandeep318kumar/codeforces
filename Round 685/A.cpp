#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
ll solve(ll n)
{
    if( n <= 1)
        return 0;
    ll j = 0;
    for(ll k = 2;k<n;k++)
    {
        if(n%k == 0){
            j = k;
            break;
        }
    }
    if(j == 0)
        return 1 + solve(n-1);
    else
        return 1 + solve(j);
}
int main()
{
    int t;
    cin>>t;
    while(t--){
        ll n;
        cin>>n;
        cout<<solve(n)<<endl;
    }
    return 0;
}
