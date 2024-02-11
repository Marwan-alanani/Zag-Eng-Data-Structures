#include <iostream>
using namespace std;
int main()
{
    int freq[26];
    string s;
    cin >> s;
    for (int i = 0; i < 26; i++)
    {
        freq[i] = 0;
    }
    for (int i = 0; i < s.length(); i++)
    {
        freq[s[i] - 97]++;
    }
    for (int i = 0; i < 26; i++)
    {
        for (int j = 0; j < freq[i]; j++)
        {
            cout << (char)(i + 97);
        }
    }
}