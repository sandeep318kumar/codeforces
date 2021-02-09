#include<bits/stdc++.h>
using namespace std;

void solve(){

    int x, y;
    cin>>x>>y;
    string s;
    cin>>s;

    int u = 0, l = 0, r = 0, d = 0;
    for(int i=0;i<s.size();i++){
        if(s[i] == 'U')
            u++;
        else if(s[i] == 'D')
            d++;
        else if(s[i] == 'R')
            r++;
        else 
            l++;
    }

    while(1){
        int px = 0, py = 0;
            
        px += r - l;
        py += u - d;
        // cout<<"U is: "<<u<<" R is: "<<r<<" L is: "<<l<<" D is: "<<d<<endl;
        // cout<<"px and py are: "<<px<<" "<<py<<endl;
        if(px == x && py == y){
            cout<<"Yes\n";
            return;
        } else {
            int hori = px - x;
            int vert = py - y;
            // cout<<"Hori is: "<<hori<<" Vert is: "<<vert<<endl;
            if( (hori > 0 && r < hori) || (hori < 0 && l < -hori) 
               || (vert > 0 && u < vert) || (vert < 0 && d < -vert) ){
                cout<<"No\n";
                return;
            }

            if(hori > 0)    r -= hori;
            else    l += hori;
            if(vert > 0)    u -= vert;
            else    d += vert;
        }
    }
}
int main()
{
    int t;
    cin>>t;
    while(t--){ 
        solve();
    }
    return 0;
}
