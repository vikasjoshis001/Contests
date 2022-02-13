#include <stdio.h>
int main()
{
    int s, t, a, b, m, n, c, d, apple = 0, orange = 0;
    int arr1[m];
    int arr2[n];
    scanf("%d %d", &s, &t);
    scanf("%d %d", &a, &b);
    scanf("%d %d", &m, &n);

    for (int i = 0; i < m; i++)
    {
        scanf("%d", &c);
        if (c + a >= s && c + a <= t)
        {
            apple++;
        }
    }

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &d);
        if (d + b >= s && d + b <= t)
        {
            orange++;
        }
    }
    printf("%d\n%d", apple, orange);
}