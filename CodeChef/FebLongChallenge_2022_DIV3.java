// import java.lang.reflect.Array;
// import java.math.BigInteger;
// import java.nio.channels.AcceptPendingException;
// import java.nio.charset.IllegalCharsetNameException;
// import java.util.Collections;
// import java.util.logging.SimpleFormatter;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

/* docstring*/
class CodeChef {
    static Templates.FastScanner sc = new Templates.FastScanner();
    static PrintWriter fop = new PrintWriter(System.out);

    public static void main(String[] args) {
        try {
            // HELIUM3();
            // WCC();
            // NOFIX();
            XORPAL();
            // E();
        } catch (Exception e) {
            return;
        }
    }

    /* docstring */
    static void HELIUM3() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            int x = Integer.parseInt(sc.next());
            int y = Integer.parseInt(sc.next());

            if( x*y >= a*b){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }

        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void WCC() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            int x = Integer.parseInt(sc.next());
            String results = sc.next();
            int chef = 0;
            int carlsen = 0;
            int draw = 0;
            int n = results.length();
            for (int i = 0; i < n; i++) {
                char ch = results.charAt(i);
                if( ch == 'C') carlsen++;
                else if(ch == 'N') chef++;
                else draw++;
            }
            if(carlsen > chef){
                System.out.println(60*x);
            }
            else if(chef > carlsen){
                System.out.println(40*x);
            }
            else{
                System.out.println(55*x);
            }
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void NOFIX() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.next());
            int arr[] = sc.readArray(n);
            int count = 0;
            int index = 0;
            while(index < n){
                    if(arr[index] == index+count+1){
                        count++;
                    }
                    index++;
            }
            System.out.println(count);
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void XORPAL() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.next());
            String str = sc.next();
            int countOf_0 = 0;
            int countOf_1 = 0;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if(ch == '0') countOf_0++;
                else countOf_1++;
            }
            if(n%2 == 0){
                if( countOf_0 == 0 || countOf_1 == 0) System.out.println("Yes");
                else if( countOf_0 == countOf_1) System.out.println("Yes");
                else if( ( Math.max(countOf_0, countOf_1) - Math.min(countOf_0, countOf_1) ) % 2 == 0)
                    System.out.println("No");
                else System.out.println("No");
            }
            else{
                if(countOf_0 == 1 || countOf_1 == 1) System.out.println("Yes");
                else if( countOf_1 == 0) System.out.println("Yes");
                else if (countOf_0 == 0)
                    System.out.println("No");
                else if( ( countOf_0 - countOf_1 ) == 1 ) System.out.println("Yes");
                else System.out.println("No");
            }
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void E() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
        }
        fop.flush();
        fop.close();
    }
}

class Templates {

    // int tree[] = new int[4*n+1] ;
    // BuiltTree(A , 0 , n-1 , tree , 1);
    // int lazy[] = new int[4*n + 1] ;
    //
    // updateRangeLazy(tree , lazy , 0 , n-1 , 0 , 2 , 10 , 1);
    // updateRangeLazy(tree , lazy , 0 , n-1 , 0 , 4 , 10 , 1);
    //
    // fop.println(querylazy(tree , lazy , 0 , n-1 , 1 ,1 ,1));
    //
    // updateRangeLazy(tree, lazy , 0 , n-1 , 10 , 4 , 3 ,1);
    // fop.println(querylazy(tree , lazy , 0 , n-1 , 3 , 5 , 1 ));

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
    // segment tree

    // BuiltTree(A , 0 , n-1 , tree , 1);
    static void BuiltTree(int A[], int s, int e, int tree[], int index) {
        if (s == e) {
            tree[index] = A[s];
            return;
        }

        int mid = (s + e) / 2;
        BuiltTree(A, s, mid, tree, 2 * index);
        BuiltTree(A, mid + 1, e, tree, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
        return;

    }

    static int query(int tree[], int ss, int se, int qs, int qe, int index) {

        // complete overlap
        if (ss >= qs && se <= qe)
            return tree[index];

        // no overlap
        if (qe < ss || qs > se)
            return Integer.MAX_VALUE;

        // partial overlap
        int mid = (ss + se) / 2;
        int left = query(tree, ss, mid, qs, qe, 2 * index);
        int right = query(tree, mid + 1, se, qs, qe, 2 * index + 1);
        return Math.min(left, right);
    }

    static void update(int tree[], int ss, int se, int i, int increment, int index) {
        // i is the index of which we want to update the value

        if (i > se || i < ss)
            return;

        if (ss == se) {
            tree[index] += increment;
            return;
        }
        int mid = (ss + se) / 2;
        update(tree, ss, mid, i, increment, 2 * index);
        update(tree, mid + 1, se, i, increment, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);

    }

    static void updateRange(int tree[], int ss, int se, int l, int r, int inc, int index) {

        if (l > se || r < ss)
            return;

        if (ss == se) {
            tree[index] += inc;
            return;
        }

        int mid = (ss + se) / 2;
        updateRange(tree, ss, mid, l, r, inc, 2 * index);
        updateRange(tree, mid + 1, se, l, r, inc, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
        return;

    }
    // Lazy rnage Update

    static void updateRangeLazy(int tree[], int lazy[], int ss, int se, int l, int r, int increment, int index) {

        if (lazy[index] != 0) {
            tree[index] += lazy[index];

            if (ss != se) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }

        if (ss > r && se < l)
            return;

        if (ss >= l && se <= r) {
            tree[index] += increment;

            if (ss != se) {
                lazy[2 * index] += increment;
                lazy[2 * index + 1] += increment;
            }
            return;
        }

        int mid = (ss + se) / 2;
        updateRange(tree, ss, mid, l, r, increment, 2 * index);
        updateRange(tree, mid + 1, se, l, r, increment, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);

    }

    // min lazy query

    static int querylazy(int tree[], int lazy[], int ss, int se, int qs, int qe, int index) {

        if (lazy[index] != 0) {

            tree[index] += lazy[index];
            if (ss != se) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            lazy[index] = 0;
        }

        if (ss > qe || se < qs)
            return Integer.MAX_VALUE;

        if (ss >= qs && se <= qe)
            return tree[index];

        int mid = (ss + se) / 2;
        int left = querylazy(tree, lazy, ss, mid, qs, qe, 2 * index);
        int right = querylazy(tree, lazy, mid + 1, se, qs, qe, 2 * index + 1);

        return Math.min(left, right);

    }

    static void sieve(int n) {
        boolean[] flag = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (flag[i])
                continue;
            else
                for (int j = i * i; j <= n; j += i) {
                    flag[j] = true;
                }
        }

    }

    static int gcd(int a, int b) {
        if (b > a) {
            int tenp = b;
            b = a;
            a = tenp;
        }
        int temp = 0;
        while (b != 0) {
            a %= b;
            temp = b;
            b = a;
            a = temp;
        }
        return a;
    }

    static int power(int x, int y) {
        int res = 1; // Initialize result

        x = x % 1000000007; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % 1000000007;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % 1000000007;
        }
        return res;
    }

    static long gcdl(long a, long b) {
        if (b > a) {
            long tenp = b;
            b = a;
            a = tenp;
        }
        long temp = 0;
        while (b != 0) {
            a %= b;
            temp = b;
            b = a;
            a = temp;
        }
        return a;
    }

    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void reverse(int a[], int n) {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
    }
}
