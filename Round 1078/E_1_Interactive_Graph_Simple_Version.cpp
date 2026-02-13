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

vector<pi> edges;
vector<ll> dp(35);
vector<int> vis(35);

vector<int> query(ll k) {
    cout << "? " << k << endl;
    cout.flush();
    int q;
    cin>> q;
    if(q <= 0) return {};
    vector<int> path(q);
    for(int i = 0;i<q;i++) {
        cin>> path[i];
    }
    return path;
}

ll dfs(int u, ll index, const vector<int> &pre) {
    if(vis[u]) return dp[u];
    
    ll count = 1;
    ll current = index + 1;
    while(true) {
        auto path = query(current);
        if(path.size() == 0 || path.size() < pre.size() + 2) break;

        bool ok = true;
        for(int i = 0;i<pre.size();i++) {
            if(pre[i] != path[i]) {
                ok = false;
                break;
            }
        }
        if(!ok || path[pre.size()] != u) {
            break;
        }

        int v = path[pre.size() + 1];
        edges.push_back({u, v});
        ll sz = 0;
        if(vis[v]) {
            sz = dp[v];
        } else {
            vi npre = pre;
            npre.push_back(u);
            sz = dfs(v, current, npre);
        }
        count += sz;
        current += sz;
    }

    vis[u] = 1;
    dp[u] = count;
    return count;
}
void solve()
{
    int n;
    cin>> n;

    fill(vis.begin(), vis.end(), 0);
    fill(dp.begin(), dp.end(), 0);
    edges.clear();

    ll index = 1;
    for(int i = 1;i<=n;i++) {
        if(vis[i]) index += dp[i];
        else index += dfs(i, index, {});
    }

    cout<< "! " << edges.size() << endl;
    for(auto i: edges) {
        cout << i.first << " " << i.second << endl;
    }
    cout.flush();
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

    ll t;
    cin>>t;
    while(t--){ 
        solve();
        // cerr<<"time taken : "<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
    }
    return 0;
}