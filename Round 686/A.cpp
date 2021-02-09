#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for(int i=0;i<n;i++)
            A[i] = n - i;

        if(n%2 != 0)
        {
            int m = n/2;
            int t = A[0];
            A[0] = A[m];
            A[m] = t;
        }
        for(int i=0;i<n;i++)
            cout<<A[i]<<" ";
        cout<<endl;
    }
    return 0;
}
