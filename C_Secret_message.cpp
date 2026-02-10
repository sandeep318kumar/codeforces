 #ifndef _GLIBCXX_NO_ASSERT
  #include <cassert>
  #endif
  #include <cctype>
  #include <cerrno>
  #include <cfloat>
  #include <ciso646>
  #include <climits>
  #include <clocale>
  #include <cmath>
  #include <csetjmp>
  #include <csignal>
  #include <cstdarg>
  #include <cstddef>
  #include <cstdio>
  #include <cstdlib>
  #include <cstring>
  #include <ctime>

  #if __cplusplus >= 201103L
  #include <ccomplex>
  #include <cfenv>
  #include <cinttypes>
  #include <cstdbool>
  #include <cstdint>
  #include <ctgmath>
  #include <cwchar>
  #include <cwctype>
  #include <exception>
  #include <stdexcept>
  #endif

  // C++
  #include <algorithm>
  #include <bitset>
  #include <complex>
  #include <deque>
  #include <exception>
  #include <fstream>
  #include <functional>
  #include <iomanip>
  #include <ios>
  #include <iosfwd>
  #include <iostream>
  #include <istream>
  #include <iterator>
  #include <limits>
  #include <list>
  #include <locale>
  #include <map>
  #include <memory>
  #include <new>
  #include <numeric>
  #include <ostream>
  #include <queue>
  #include <set>
  #include <sstream>
  #include <stack>
  #include <stdexcept>
  #include <streambuf>
  #include <string>
  #include <typeinfo>
  #include <utility>
  #include <valarray>
  #include <vector>

  #if __cplusplus >= 201103L
  #include <array>
  #include <atomic>
  #include <chrono>
  #include <condition_variable>
  #include <forward_list>
  #include <future>
  #include <initializer_list>
  #include <mutex>
  #include <random>
  #include <ratio>
  #include <regex>
  #include <scoped_allocator>
  #include <system_error>
  #include <thread>
  #include <tuple>
  #include <typeindex>
  #include <type_traits>
  #include <unordered_map>
  #include <unordered_set>
  #endif
using namespace std;

typedef long long int ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;

void check(vector<string> &A, int n, int k, vector<string> &ans, string curr, int i) {
    if(i == n) {
        // found one strip.
        ans.push_back(curr);
        return;
    }

    for(int j = 0;j<k;j++) {
        curr = curr + A[j][i];
        check(A, n, k, ans, curr, i+1);
        curr.pop_back();
    }
}

int informativity(string s) {
    int ans = 0, n = s.length();
    for(int l = 1;l <= n;l++) {
        if(n % l != 0) continue;
        int i = 0;
        string first = s.substr(i, l);
        bool flag = true;
        while(i + l <= n) {
            string comp = s.substr(i, l);
            i += l;
            if(first != comp) {
                flag = false;
                break;
            }
        }
        if(flag) return l;
    }
    return n;
}

void solve()
{
    int n, k;
    cin>>n>>k;
    vector<string> A(k);
    for(int i=0;i<k;i++){
        cin>>A[i];
    }
    vector<vector<bool>> mp(n, vector<bool>(26, false));
    for(int i = 0;i<k;i++) {
        for(int j = 0;j<n;j++) {
            char a = A[i][j];
            mp[j][a - 'a'] = true;
        }
    }

    vector<int> divisors;
    for(int i = 1;i*i <= n;i++) {
        if(n % i == 0) {
            divisors.push_back(i);
            if(i * i != n) divisors.push_back(n/i);
        }
    }
    sort(divisors.begin(), divisors.end());
    int best_d = n;

    for(int d : divisors) {
        // lets check for this d.
        bool flag = true;

        for(int r = 0;r < d && flag;r++) {
            vector<bool>common(26, true);
            for(int i = r;i<n;i+=d) {
                for(int c = 0;c < 26;c++) {
                    common[c] = common[c] && mp[i][c];
                }
            }

            // check if atleast one character is true or not.
            bool any = false;
            for(int c = 0;c< 26;c++) {
                if(common[c]) {
                    any = true;
                    break;
                }
            }
            if(!any) {
                // no character there.
                flag = false;
            }
        }
        if(flag) {
            best_d = d;
            break;
        }
    }
    string res(n, 'a');

    // now we need to construct a repeating string of d size => total size will be n.
    for(int r = 0;r<best_d;r++) {

        // find a common character for this position of r.
        // it should be there at these positions r, r+d, r+2d..
        vector<bool> common(26, true);
        for(int i = r;i<n;i+=best_d) {
            for(int c = 0;c<26;c++) {
                common[c] = common[c] && mp[i][c];
            }
        }
        char shared = 'a';
        // now find the commmon character.
        for(int c = 0;c<26;c++) {
            if(common[c]) {
                shared += c;
                break;
            }
        }


        // now we need to put this shared chars at r, r+d, r+2d...
        for(int i = r;i<n;i+=best_d) {
            res[i] = shared;
        }
    }

    cout << res << "\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}