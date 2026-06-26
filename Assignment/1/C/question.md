C. Fast Sum

time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

Forbidden Keywords for the Quiz: sort, open, file, creat(, fstream, thread, process, system(, exec(

Your friend is trying to solve the following problem. You are given TT test cases. For each test case, you are given an integer NN. You have to find out the summation of 1 to N. More formally, your friend has to calcuate

∑x\=1x\=Nx∑x\=1x\=Nx

Your friend wrote the following code in Python to solve it:

```
T = int(input())for _ in range(T):    N = int(input())    sum = 0    for i in range(1, N + 1):        sum += i    print(sum)
```

Same code in Java:

```
import java.util.Scanner;public class Solution {    public static void main(String[] args) {        Scanner sc = new Scanner(System.in);        int T = sc.nextInt();         for (int t = 0; t < T; t++) {            int N = sc.nextInt();              int sum = 0;            for (int i = 1; i <= N; i++)                sum += i;            System.out.println(sum);        }    }}
```

However, the code is not passing the online judge due to some unknown errors for large values of N.

Since you are currently studying CSE221 and have learned about time complexity, help your friend come up with a more efficient solution.

Input

The first line contains a single integer T (1≤T≤104)(1≤T≤104) — the number of test cases.

The next T lines each contain a single integer N (1≤N≤106)(1≤N≤106).

Output

For each test case, print a single integer — the summation from 1 to N.

Example

Input

Copy

5
2
5
10
12
100

Output

Copy

3
15
55
78
5050