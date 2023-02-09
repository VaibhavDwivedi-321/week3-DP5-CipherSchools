#include <bits/stdc++.h>
using namespace std;

int t, n, ans;
string s;
map<char, int> cnt;

int main() {
    cin >> t;
    while (t--) {
        cin >> n >> s;
        cnt.clear();
        ans = 0;
        for (int i = 0; i < n; i++)
            cnt[s[i]]++;
        ans = min(n - cnt.size(), cnt.size());
        cout << ans << endl;
    }
    return 0;
}
