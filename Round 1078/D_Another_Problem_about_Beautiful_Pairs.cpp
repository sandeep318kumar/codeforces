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

typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<vi> vvi;
typedef vector<vl> vll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
// typedef for(int i = 0;i<n;i++) fori(n);

void solve()
{
    int n;
    cin>> n;
    vi A(n);
    for(int i = 0;i<n;i++) {
        cin>> A[i];
    }

    int ans = 0;
    int B = sqrt(n);
    // two cases. 
    // case 1. when a[i] <= B
    // a[i].a[j] = j - i
    // i = j - a[i].a[j]
    // i = j - x . a[j]
    // iterate over j from 1 - n
    // iterate x from 1 to B and find out i, a[i]

    for(ll x = 1;x<=B;x++) {
        for(int j = 0;j<n;j++) {
            // find out i value here.
            ll i = j - (ll)(x * A[j]);
            if(i >= 0 && i < n && x == A[i]) {
                ans++;
            }
        }
    }

    // 2. case when a[i] > B;
    // a[i].a[j] = j - i
    // j = i + a[i].a[j]
    // a[i] value will be from B < a[i] < n
    // j = i + a[i].k -> k value will be from 1 to n/B.
    // so iterate over i 1 to n. if a[i] > B then
    // iterate over k from 1 to n/B. and try to find out j & a[j]
    for(int i = 0;i<n;i++) {
        if(A[i] > B) {
            for(ll k = 1;k<= n / B;k++) {
                ll j = i + (ll)(A[i] * k);
                if(j >= 0 && j < n && A[j] == k) {
                    ans++;
                }
            }
        }
    }
    cout << ans << "\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif

    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}