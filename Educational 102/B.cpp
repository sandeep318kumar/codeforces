#include<bits/stdc++.h>
using namespace std;
string repeat(string s){
    for(int i=1;i<=s.size();i++){
        string str = s.substr(0, i);
        // cout<<str<<" ";
        bool flag = true, f1 = false;
        int j = 0, k = i;
        for(;k <= s.size() - str.size();k+=str.size()){
            f1 = true;
            string str2 = s.substr(k, str.size());
            if(str != str2){
                flag = false;
                break;
            }
        }
        if(flag && f1){
            return str;
        }
    }
    return s;
}
int lcm(int a, int b){
    int mp;
    if(a > b)
        mp = a ; 
    else
        mp = b;
    while(1)
    {
        if((mp%a == 0) && (mp%b == 0))
            break;
        else
            mp++;
    }
    return mp;
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 

        string a, b, aa, bb;
        cin>>a>>b;
        int la = a.size(), lb = b.size();
        for(int i=0;i<lb/__gcd(la, lb);i++)
            aa += a;
        for(int i=0;i<la/__gcd(la, lb);i++) 
            bb += b;
        if(aa == bb)
            cout<<aa<<endl;
        else 
            cout<<-1<<endl;

        // string s, t;
        // cin>>s>>t;

        // string s1 = repeat(s);
        // string t1 = repeat(t);

        // // cout<<s1<<" "<<t1<<endl;

        // if(s1 == t1){
        //     int l = lcm(s.size()/s1.size(), t.size()/t1.size());
        //     string res = "";
        //     for(int i=0;i<l;i++){
        //         res += s1;
        //     }
        //     cout<<res<<endl;
        // } else{
        //     cout<<"-1\n";
        // }
    }
    return 0;
}
