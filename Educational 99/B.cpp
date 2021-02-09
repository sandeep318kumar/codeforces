#include<bits/stdc++.h>
using namespace std;

int jump(int k, int x, int i){
    if(k == x)
        return 0;
    if(k > x + 1)
        return INT_MAX;

    if(k < (0 - x))
        return INT_MAX;
    
    return 1 + min(jump(k-1, x, i+1), jump(k+i, x, i+1));
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int x;
        cin>>x;
        int i = 1, k = 0;
        cout<<jump(k, x, i)<<endl;
        
    }
    return 0;
}
