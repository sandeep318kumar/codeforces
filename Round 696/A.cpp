#include<bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin>>t;
    while(t--){ 
        int n;
        cin>>n;
        string b;
        cin>>b;
        string a;
        a.push_back('1');
        char prev = (b[0] == '1') ? '2' : '1';

        for(int i=1;i<b.size();i++){
            if(prev == '0'){
                if(b[i] == '1'){
                    a.push_back('1');
                    prev = '2';
                } else {
                    a.push_back('1');
                    prev = '1';
                }
            } else if(prev == '1'){
                if(b[i] == '1'){
                    a.push_back('1');
                    prev = '2';
                } else {
                    a.push_back('0');
                    prev = '0';
                }
            } else{
                if(b[i] == '1'){
                    a.push_back('0');
                    prev = '1';
                } else {
                    a.push_back('1');
                    prev = '1';
                }
            }
        }
        cout<<a<<endl;
    }
    return 0;
}
