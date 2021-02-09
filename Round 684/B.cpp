#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{
    ll t;
    cin>>t;
    while(t--){
        ll n, k;
        cin>>n>>k;
        deque<ll>q;
        ll A[n*k];
        for(ll i=0;i<n*k;i++){
            cin>>A[i];
            q.push_back(A[i]);
        }
        ll sum = 0;
        if(n == 2){
            ll i = 0;
            while(i < n * k){
                sum += A[i];
                i += 2;
            }
        }
        else{
            while( !q.empty()){
                ll A[n];
                ll mid = 0;
                if(n % 2 != 0)
                    mid = n / 2;
                else
                    mid = (n - 1)/2;
                for(ll i=0;i<mid;i++){
                    A[i] = q.front();
                    q.pop_front();
                }

                for(ll i=n-1;i>=mid;i--){
                    A[i] = q.back();
                    q.pop_back();
                }

                //cout<<A[mid]<<" ";
                sum += A[mid];
            }
        }
        cout<<sum<<endl;
    }
    return 0;
}
