import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CodeChef {
    public static void main(String[] args) {
        try {
            FastScanner sc = new FastScanner();
            int T = Integer.parseInt(sc.next());
            while (T-- > 0) {
                // Write Your Code...

                int A = sc.nextInt();
                int B = sc.nextInt();
                if (A == B) {
                    System.out.println(0);
                } else {
                    int min = Math.min(A, B);
                    int max = Math.max(A, B);
                    int X = max - 1;
                    // System.out.println("X = "+X);


                    // int X = sc.nextInt();
                    // int A =13;
                    // int B = 6;
                    // int X = 7;
                    float A1 = (X - A);
                    float B1 = (B - X);

                    double ans1 = (B1 / 2);
                    double ans2 = (A1 / 2);
                    // System.out.println(ans1);
                    // System.out.println(ans2);

                    int ans = (int) Math.ceil(ans1) + (int) Math.ceil(ans2);
                    System.out.println(ans);
                }
            }
        } catch (Exception e) {
            //
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}