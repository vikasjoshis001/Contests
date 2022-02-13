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
import java.math.BigInteger;

/* docstring*/
class Main {
    static Templates.FastScanner sc = new Templates.FastScanner();
    static PrintWriter fop = new PrintWriter(System.out);
    public static void main(String[] args) {
        try {
            // ContestStart();
            // LoveSong();
            StableGroups();
            // D();
            // E();
        } catch (Exception e) {
            // System.out.println(e);
        }
    }

    /* docstring*/
    static void ContestStart() throws IOException{
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int n = sc.nextInt(), x=sc.nextInt(), t = sc.nextInt();
            Integer[] start = new Integer[n];
            Integer[] end = new Integer[n];
            start[0] = 0;
            end[0] = t;
            for(int i=1;i<n;i++){
                start[i] = i*x;
                end[i] = start[i] + t;
            }
            int sum = 0;
            for(int i=1;i<n;i++){
                for(int j=0;j<i;j++){
                    if(start[i]<=end[j]&&end[j]<=end[i]) sum+=1;
                }
            }
            fop.println(sum);

        }
        fop.flush();
        fop.close();
    }

    /* docstring*/
    static void LoveSong() throws IOException{
        // int T = Integer.parseInt(sc.next());
        // while (T-- > 0) {
            // Write Your Code...
            Integer n = sc.nextInt();
            Integer q = sc.nextInt();
            String song = sc.next();
            for(int i=0;i<q;i++){
                Integer l = sc.nextInt();
                Integer r = sc.nextInt();
                Integer sum = 0;
                for(int j=l-1;j<r;j++){
                    char ch = song.charAt(j);
                    sum+= Math.abs(96 - (int)ch);
                }
                fop.println(sum);
            // }
        }
        fop.flush();
        fop.close();
    }

    /* docstring*/
    static void StableGroups(){
        // int T = Integer.parseInt(sc.next());
        // while (T-- > 0) {
            // Write Your Code...
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int group = 1;
            int []arr = sc.readArray(n);
            // BigInteger k = s.nextBigInteger();
            // BigInteger x = s.nextBigInteger();
            // BigInteger group = 0;
            // BigInteger kCount = 0;
            // BigInteger []arr = new BigInteger[n];
            Arrays.sort(arr);
            for(int i=0;i<n-1;i++){
                if(arr[i+1] - arr[i] > x){
                        group+=1;
                }
            }
            System.out.println(group-k);
        // }
        fop.flush();
        fop.close();
    }

    /* docstring*/
    static void D() throws IOException{
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
        }
        fop.flush();
        fop.close();
    }
    
    /* docstring*/
    static void E() throws IOException{
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
}
