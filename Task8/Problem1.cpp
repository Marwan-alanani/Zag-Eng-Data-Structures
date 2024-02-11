#include <iostream>
using namespace std;
int main()
{
    int N, M;
    cin >> N >> M;
    int freq[M];
    for (int i = 0; i < M; i++)
    {
        freq[i] = 0;
    }
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        freq[num - 1]++;
    }
    for (int i = 0; i < M; i++)
    {
        cout << freq[i] << endl;
    }
}