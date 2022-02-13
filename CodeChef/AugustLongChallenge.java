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

    //  class to define user defined conparator
    static void compare(ArrayList<Pair> list) {
        // Comparator to sort the pair according to second element
        Collections.sort(list, new Comparator<Pair>() {
            @Override public int compare(Pair p1, Pair p2)
            {
                return p1.x - p2.x;
            }
        });
    }

    public static void main(String[] args) {
        try {
            // OLYRANK();
            // PROBDIFF();
            // CHFINVNT();
            // SPCTRIPS();
            CHARGE();
            // ARRFILL();
        } catch (Exception e) {
            return;
        }
    }

    /* docstring */
    static void OLYRANK() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 3; i++) {
                sum1 += sc.nextInt();
            }
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void PROBDIFF() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int arr[] = sc.readArray(4);
            Arrays.sort(arr);
            if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
                System.out.println(0);
            } else if ((arr[0] == arr[1] && arr[1] == arr[2]) || (arr[1] == arr[2] && arr[2] == arr[3])) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void CHFINVNT() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int N = sc.nextInt();
            int P = sc.nextInt();
            int K = sc.nextInt();
            int now = 0, day = 0, temp;
            now = (P % K) - 1;
            temp = ((N - 1) / K) * K;
            temp = N - 1 - temp;
            if (now > temp) {
                day += ((temp + 1) * ((N - 1) / K + 1)) + ((now - temp) * ((N - 1) / K));
            } else {
                day += (((N - 1) / K + 1)) * (now + 1);
            }
            for (int i = now + 1; i <= N; i += K) {
                day++;
                if (i == P) {
                    System.out.println(day);
                    break;
                }
            }
        }
        fop.flush();
        fop.close();
    }

    /* docstring */
    static void SPCTRIPS() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int N = sc.nextInt(), Tripllets = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = i; j <= N; j += i) {
                    if (j % i == 0) {
                        for (int j2 = i; j2 <= N; j2 += j) {
                            if (j2 % j == i) {
                                Tripllets++;
                            }
                        }
                    }
                }
            }
            System.out.println(Tripllets);
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

    static class Pair {
        int x;
        int y;
      
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }
  
    

    static void ARRFILL() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
        long N = sc.nextLong();
        long M = sc.nextLong();
        long temp = 1, ans = 0, count = N;
        ArrayList<Pair> value_list = new ArrayList<>();
        for(long i = 1; i <= M; i++) {
            value_list.add(new Pair((int)sc.nextLong(), (int)sc.nextLong()));
        }
        compare(value_list);
        for(int i = (int)M-1; i > -1 && count > 0; i--) {
            long x = (long)value_list.get(i).getX();
            long y = (long)value_list.get(i).getY();
            temp = (temp * y) / Templates.gcd((int)temp, (int)y);
            ans += (count - (N / temp)) * x;
            count = N / temp;
        }
        System.out.println(ans);
        }
        fop.flush();
        fop.close();
    }

    static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    static void CHARGE() throws IOException {
        int T = Integer.parseInt(sc.next());
        while (T-- > 0) {
            // Write Your Code...
            int N = sc.nextInt();
            int satisfied = 0;
            int total_time = 0;
            int charge_time[] = sc.readArray(N);
            int stop_time[] = sc.readArray(N);
            int initial_time = 0;
            int last_time = 0;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<N;i++){
                if(max < stop_time[i]){
                    max = stop_time[i];
                }
            }
            ArrayList<Integer> person = new ArrayList<>();
            ArrayList<Integer> start_time = new ArrayList<>();
            ArrayList<Integer> finish_time = new ArrayList<>();

            // ArrayList<Integer> time = new ArrayList<>();
            // ArrayList<Integer> index = new ArrayList<>();
            HashMap<Integer,Integer> hm = new HashMap<>();
            for(int i=0;i<N;i++){
                if(charge_time[i] < stop_time[i]){
                    hm.put(i+1,charge_time[i]);
                    // time.add(charge_time[i]);
                    // index.add(i+1);
                }
            }
            HashMap<Integer, Integer> hm1 = sortByValue(hm);
            for (HashMap.Entry<Integer, Integer> en : hm1.entrySet()) {
                total_time+=en.getValue();
                if(total_time <= max){
                    satisfied++;
                    person.add(en.getKey());
                    start_time.add(initial_time);
                    last_time = initial_time + en.getValue();
                    finish_time.add(last_time);
                    initial_time = last_time;
                }
                else{
                    break;
                }
            }

            // for(int j=0;j<index.size();j++){
            //     total_time+=hm.get(j);
            //     if(total_time < 60){
            //         satisfied++;
            //     }
            //     else{
            //         break;
            //     }
            // }
            System.out.println(satisfied);
            for(int j=0;j<person.size();j++){
                System.out.println(person.get(j)+" "+start_time.get(j)+" "+finish_time.get(j));
            }
            // int initial_time = 0;
            // for(int j=0;j<time.size();j++){
            //     System.out.println();
            // }

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
}
