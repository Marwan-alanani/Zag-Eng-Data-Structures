#include <iostream>
using namespace std;
int main()
{
    int freq[26];
    for (int i = 0; i < 26; i++)
    {
        freq[i] = 0;
    }
    string s;
    cin >> s;
    for (int i = 0; i < s.length(); i++)
    {
        freq[s[i] - 97]++;
    }
    for (int i = 0; i < 26; i++)
    {
        if (freq[i] == 0)
        {
            continue;
        }
        cout << (char)(i + 97) << " : " << freq[i] << endl;
    }
}