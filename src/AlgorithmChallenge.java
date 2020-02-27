import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AlgorithmChallenge {

    public static void main(String[] args) {
//        fibonaci(10);
//        fizzbazz(100);
//        System.out.println(minimumConcat("xyz", "xzyxz"));
//        bfs();
//        dfs(true);
//        sortNumbersByFrequency();
//        missingWords();
//        longestLengthSubarray();
//        numOffices();
//        biggestTable();
//        maxHistogram(new ArrayList<>(Arrays.asList(6, 2, 5, 4, 5, 1, 6)));
//        stockMax();
//        sockMerchant();
//        countingValleys();
//        jumpingOnClouds();
//        repeatedString();
//        hourglassSum();
//        rotLeft();
//        minimumBribes();
//        minimumSwaps();
//        arrayManipulation();
//        checkMagazine();
//        twoStrings();
//        sherlockAndAnagrams();
//        countTriplets();
//        freqQuery();
//        countSwaps();
        maximumToys();
    }

    public static void fibonaci(int n) {
        int fin1 = 1, fin2 = 1, fin = 0;

        for (int i = 1; i <= n; i++) {
            if (1 == i || 2 == i) {
                System.out.println(1);
                continue;
            }

            fin = fin1 + fin2;
            fin1 = fin2;
            fin2 = fin;
            System.out.println(fin);
        }
    }

    public static void fizzbazz(int n) {

        for (int i = 1; i <= n; i++) {
            if (0 == i % 15) {
                System.out.println("fizzbazz:" + i);
                continue;
            }
            if (0 == i % 3) {
                System.out.println("fizz:" + i);
            }
            if (0 == i % 5) {
                System.out.println("bazz:" + i);
            }
        }

    }

    public static int minimumConcat(String initial, @NotNull String goal) {

        String prevSubInitial = "";
        int prevInitialInd = 0;

        List<String> concat = new ArrayList<>();

        for (int i = 0; i < goal.length(); i++) {

            String subGoal = goal.substring(i, i + 1);

            if (!initial.contains(subGoal)) {
                return -1;
            }

            for (int j = 0; j < initial.length(); j++) {

                String subInitial = initial.substring(j, j + 1);
                if (subInitial.equals(subGoal)) {
                    if (!prevSubInitial.isEmpty() && prevInitialInd > j) {
                        concat.add(prevSubInitial);
                        prevSubInitial = "";
                    }
                    prevSubInitial = prevSubInitial.concat(subInitial);
                    if ((j == initial.length() - 1) && (i == goal.length() - 1)) {
                        concat.add(prevSubInitial);
                        prevSubInitial = "";
                    }
                    prevInitialInd = j;
                    break;
                }
            }
        }

        return concat.size();
    }

    public static void bfs() {
        int nov = 5;
        int s = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        list.add(1, new ArrayList<Integer>());
        list.add(2, new ArrayList<Integer>(Collections.singleton(4)));
        list.add(3, new ArrayList<Integer>());
        list.add(4, new ArrayList<Integer>());

        boolean[] vis = new boolean[nov];
        for (int i = 0; i < nov; i++)
            vis[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        vis[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            ArrayList<Integer> integers = list.get(s);
            for (Integer integer : integers) {
                if (!vis[integer]) {
                    vis[integer] = true;
                    queue.add(integer);
                }
            }
        }

    }

    public static void dfs(boolean isRecursive) {
        int src = 0;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList<Integer>(Arrays.asList(1, 2)));
        list.add(1, new ArrayList<Integer>(Collections.singleton(2)));
        list.add(2, new ArrayList<Integer>(Arrays.asList(0, 3)));
        list.add(3, new ArrayList<Integer>(Collections.singleton(3)));

        boolean[] vis = new boolean[list.size()];
        for (int i = 0; i < vis.length; i++)
            vis[i] = false;

        if (isRecursive) {
            dfsRecursive(src, list, vis);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        vis[src] = true;

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            System.out.print(pop + " ");

            ArrayList<Integer> integers = list.get(pop);
            for (Integer integer : integers) {
                if (vis[integer])
                    continue;
                vis[integer] = true;
                stack.push(integer);
            }
        }
    }

    private static void dfsRecursive(@NotNull Integer s, @NotNull ArrayList<ArrayList<Integer>> list, @NotNull boolean[] vis) {
        System.out.print(s + " ");
        vis[s] = true;
        ArrayList<Integer> integers = list.get(s);
        for (Integer integer : integers)
            if (!vis[integer])
                dfsRecursive(integer, list, vis);
    }

    public static void sortNumbersByFrequency() {
        int[] numbers = {1, 3, 2, 5, 2, 5, 2, 4, 9, 6};

        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            Integer integer = map.getOrDefault(number, 0);
            map.put(number, integer + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByKey()));

        LinkedHashMap<Integer, Integer> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)
                        -> e1, LinkedHashMap::new));
    }

    public static void missingWords() {
        String t = "I love programming, pizza, coke and chips";
        String s = "I programming, chips";

        String[] tt = t.replace(",", "").split(" ");

        List<String> miss = new ArrayList<>();
        for (String t1 : tt) {
            if (!s.contains(t1)) {
                miss.add(t1);
            }
        }
        System.out.println(miss);
    }

    public static void longestLengthSubarray() {
        int[] arr = {5, 6, 10, 12, 3, 5, 4, 8, 9, 1, 2};
        int longestLength = 1, incr = 1;
        for (int i = 1; i < arr.length; i++) {
            incr = arr[i] > arr[i - 1] ? ++incr : 1;
            if (incr > longestLength) {
                longestLength++;
            }
        }
        System.out.println(longestLength);
    }

    public static void numOffices() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        list.add(1, new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0)));
        list.add(2, new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0)));
        list.add(3, new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1)));

        int result = 0;
        ArrayList<ArrayList<Boolean>> vis = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            vis.add(new ArrayList<>(Arrays.asList(false, false, false, false, false)));
        }
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> integers = list.get(i);
            for (int j = 0; j < integers.size(); j++) {
                Integer cur = integers.get(j);
                if (!vis.get(i).get(j) && 1 == cur) {
                    drawOffice(list, i, j, vis);
                    result++;
                }
                vis.get(i).set(j, true);
            }
        }
        System.out.println(result);
    }

    private static void drawOffice(ArrayList<ArrayList<Integer>> list, int i, int j, ArrayList<ArrayList<Boolean>> vis) {
        if (i < 0 || j < 0 || i >= list.size() || j >= list.get(0).size())
            return;
        if (vis.get(i).get(j))
            return;
        vis.get(i).set(j, true);
        if (0 == list.get(i).get(j))
            return;
        drawOffice(list, i + 1, j, vis);
        drawOffice(list, i, j + 1, vis);
    }

    public static void biggestTable() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(0, new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1)));
        list.add(1, new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1)));
        list.add(2, new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        list.add(3, new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0)));

        int result = maxHistogram(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            ArrayList<Integer> columns = list.get(i);
            for (int j = 0; j < columns.size(); j++)
                if (1 == list.get(i).get(j))
                    list.get(i).set(j, list.get(i - 1).get(j) + 1);
            result = Math.max(result, maxHistogram(list.get(i)));
        }
        System.out.println(result);
    }

    private static int maxHistogram(ArrayList<Integer> columns) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int pop, top_area;
        int i = 0;
        while (i < columns.size()) {
            if (stack.isEmpty() || columns.get(stack.peek()) <= columns.get(i))
                stack.push(i++);
            else {
                pop = stack.pop();
                top_area = columns.get(pop) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (max < top_area)
                    max = top_area;
            }
        }

        while (!stack.isEmpty()) {
            pop = stack.pop();
            top_area = columns.get(pop) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (max < top_area)
                max = top_area;
        }
        return max;
    }

    public static void stockMax() {
        List<Integer> prices = new ArrayList<>();
        prices.add(4);
        prices.add(4);
        prices.add(3);
        prices.add(4);
        prices.add(5);
        prices.add(6);
        prices.add(8);
        prices.add(10);
        prices.add(6);

        int profit = 0;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < prices.size()) {
            if (stack.isEmpty() || prices.get(stack.peek()) < prices.get(i) || hasMax(i, prices, stack.peek())) {
                stack.push(i++);
                continue;
            }
            Integer sell = prices.get(stack.pop());
            while (!stack.isEmpty()) {
                Integer buy = prices.get(stack.pop());
                profit += sell - buy;
            }
        }
        if (!stack.isEmpty()) {
            Integer sell = prices.get(stack.pop());
            while (!stack.isEmpty()) {
                Integer buy = prices.get(stack.pop());
                profit += sell - buy;
            }
        }
        System.out.println(profit);
        stockMax2(prices);
    }

    private static boolean hasMax(int i, List<Integer> prices, Integer peek) {
        for (int j = i; j < prices.size(); j++) {
            if (prices.get(j) > prices.get(peek)) {
                return true;
            }
        }
        return false;
    }

    public static void stockMax2(List<Integer> prices) {

        int numStock = prices.size();
        List<Integer> maxSoFar = new ArrayList<>(prices);
        int max = Integer.MIN_VALUE;
        for (int i = numStock - 1; i >= 0; --i) {
            max = Math.max(max, prices.get(i));
            maxSoFar.set(i, max);
        }

        long profit = 0;
        for (int i = 0; i < numStock; i++) {
            if (!maxSoFar.get(i).equals(prices.get(i))) {
                profit += maxSoFar.get(i) - prices.get(i);
            }
        }

        System.out.println(profit);
    }

    static void sockMerchant() {
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int n = ar.length;
        boolean[] vis = new boolean[ar.length];

        int socks = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            vis[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (vis[j]) continue;

                if (ar[i] == ar[j]) {
                    vis[j] = true;
                    socks++;
                    break;
                }
            }
        }
        System.out.println(socks);
    }

    static void countingValleys() {
        String s = "UDUUUDUDDD";
        int n = s.length();
        int c = 0, level = 0;

        for (int i = 0; i < n; i++) {
            String cur = s.substring(i, i + 1);
            if ("D".equals(cur))
                level--;
            if ("U".equals(cur))
                level++;
            if (0 == level && "U".equals(cur))
                c++;
        }

        System.out.println(c);
    }

    static void jumpingOnClouds() {
        int[] c = {0, 0, 0, 0, 1, 0};
        int jumps = 0;

        for (int i = 0; i < c.length - 1; i++) {
            if (i < c.length - 2 && 0 == c[i + 2]) {
                jumps++;
                i++;
                continue;
            }
            jumps++;
        }
        System.out.println(jumps);
    }

    static long repeatedString() {
        String s = "aba";
        long n = 10;
        if (!s.contains("a")) {
            return 0;
        }
        if (n == s.length() || 1 == s.length()) {
            return n;
        }
        long c = 0;
        long sl = s.length();

        for (int i = 0; i < s.length(); i++) {
            if ("a".charAt(0) == s.charAt(i))
                c += 1;
        }

        long total = n / sl * c;
        long mod = n % sl;
        for (int i = 0; i < mod; i++) {
            if ("a".charAt(0) == s.charAt(i))
                total++;
        }

        System.out.println(total);
        return total;
    }

    static int hourglassSum() {
        int[][] arr = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}};
        int maxSum = Integer.MIN_VALUE;

        int a, b, c, d, e, f, g, h;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                a = arr[i][j];
                b = arr[i][j + 1];
                c = arr[i][j + 2];
                d = arr[i + 1][j + 1];
                e = arr[i + 2][j];
                f = arr[i + 2][j + 1];
                g = arr[i + 2][j + 2];
                h = a + b + c + d + e + f + g;
                maxSum = Math.max(maxSum, h);
            }
        }
        System.out.println(maxSum);
        return maxSum;
    }

    static int[] rotLeft() {
        int[] a = {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
        int d = 13;
        int n = a.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if ((i + d) >= n) {
                res[i] = a[i + d - n];
            } else
                res[i] = a[i + d];
        }
        return res;

//        int i = 0, prev = 0, cur;
//        while (a[n - 1] != d) {
//            cur = a[i];
//            if (0 == i) {
//                a[i] = a[n - 1];
//                prev = cur;
//                i++;
//                continue;
//            }
//            a[i] = prev;
//            prev = cur;
//            i++;
//            if (i == n)
//                i = 0;
//
//        }
    }

    static void minimumBribes() {

        int[] q = {2, 5, 1, 3, 4};
        int c = 0;
        int n = q.length;
        int[] state = new int[n];
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            state[i] = i + 1;
        }
        while (!Arrays.equals(q, state)) {
            for (int i = 0; i < n - 1; i++) {
                if (q[i] < q[i + 1]) {
                    continue;
                }
                if (steps[q[i] - 1] >= 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                steps[q[i] - 1]++;
                q[i] = q[i] + q[i + 1];
                q[i + 1] = q[i] - q[i + 1];
                q[i] = q[i] - q[i + 1];
                c++;
            }
        }
        System.out.println(c);
    }

    static int minimumSwaps() {
        int[] arr = {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
        int c = 0, n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            if (i < arr[i] - 1) {
                swap(arr, i, arr[i] - 1);
                c++;
                i--;
            }
        }

        System.out.println(c);
        return c;
    }

    private static void swap(int[] arr, int i, int o) {
        arr[o] = arr[i] + arr[o];
        arr[i] = arr[o] - arr[i];
        arr[o] = arr[o] - arr[i];
    }

    static long arrayManipulation() {
        int n = 10;
        int[][] queries = {
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}};
        long[] arr = new long[n];

        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1];
            int k = query[2];

            arr[a] += k;
            if (b < n)
                arr[b] -= k;
        }
        long res = 0, sum = 0;
        for (long el : arr) {
            sum += el;
            res = Math.max(res, sum);
        }
        System.out.println(res);
        return res;
    }

    static void checkMagazine() {
        String[] magazine = {"give", "me", "one", "grand", "today", "today", "night"};
        String[] note = {"give", "one", "grand", "today", "today"};

        Hashtable<Integer, String> ht = new Hashtable<>();
        for (int i = 0; i < magazine.length; i++) {
            ht.put(i, magazine[i]);
        }
        Collection<String> values = ht.values();
        for (String s : note) {
            if (!values.contains(s)) {
                System.out.println("No");
                return;
            }
            values.remove(s);
        }
        System.out.println("Yes");
    }

    static String twoStrings() {
        String s1 = "hi";
        String s2 = "world";

        if (Pattern.compile("[" + s2 + "]").matcher(s1).find()) {
            return "YES";
        }
        return "NO";
    }

    static int sherlockAndAnagrams() {
        String s = "kkkk";
        int n = s.length();
        int res = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                substring = new String(chars);
                Integer value = map.getOrDefault(substring, 0);
                if (value > 0)
                    res += value;
                map.put(substring, ++value);
            }
        }
        return res;
    }

    static long countTriplets() {
        List<Long> arr = new ArrayList<>(Arrays.asList(1L, 5L, 5L, 5L, 25L, 25L, 125L));
        long r = 5;
        long res = 0;
        HashMap<Long, Long> map = new HashMap<>();
        HashMap<Long, Long> tp = new HashMap<>();
        for (Long el : arr) {
            if (el % r == 0 && tp.containsKey(el / r))
                res += tp.get(el / r);

            if (tp.containsKey(el)) {
                tp.put(el, tp.get(el) + map.get(el / r));
            } else if (el % r == 0 && map.containsKey(el / r)) {
                tp.put(el, map.get(el / r));
            }
            Long mapVal = map.getOrDefault(el, 0L);
            map.put(el, ++mapVal);
        }
        System.out.println(res);
        return res;
    }

    static List<Integer> freqQuery() {
        List<List<Integer>> queries = getFreqQueries();
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> valMap = new HashMap<>();
        final int INSERT = 1, REMOVE = 2, QUERY = 3;
        int operation, data, freqVal, val, newVal;
        for (List<Integer> query : queries) {
            operation = query.get(0);
            data = query.get(1);
            if (INSERT == operation) {
                val = valMap.getOrDefault(data, 0);
                if (0 == val) {
                    freqVal = freqMap.getOrDefault(1, 0);
                    freqMap.put(1, ++freqVal);
                } else {
                    freqMap.put(val, freqMap.get(val) - 1);
                    freqVal = freqMap.getOrDefault(val + 1, 0);
                    freqMap.put(val + 1, ++freqVal);
                }
                valMap.put(data, ++val);
            } else if (REMOVE == operation) {
                if (valMap.containsKey(data)) {
                    val = valMap.get(data);
                    newVal = Math.max(val - 1, 0);
                    valMap.put(data, newVal);
                    freqMap.put(val, freqMap.get(val) - 1);
                    freqVal = freqMap.getOrDefault(newVal, 0);
                    freqMap.put(newVal, ++freqVal);

                }
            } else if (QUERY == operation) {
                if (freqMap.containsKey(data) && freqMap.get(data) > 0)
                    res.add(1);
                else
                    res.add(0);
            }
        }
        System.out.println(res);
        return res;
    }

    private static List<List<Integer>> getFreqQueries() {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 3));
        queries.add(Arrays.asList(2, 3));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(1, 4));
        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 5));
        queries.add(Arrays.asList(1, 4));
        queries.add(Arrays.asList(3, 2));
        queries.add(Arrays.asList(2, 4));
        queries.add(Arrays.asList(3, 2));
        return queries;
    }

    static void countSwaps() {
        int[] a = {1, 2, 3};
        int n = a.length;
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    c++;
                }
            }
        }
        System.out.println("Array is sorted in " + c + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);

    }

    static int maximumToys() {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        int res = 0;

        Arrays.sort(prices);
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
            if (total > k) {
                res = i;
                break;
            }
        }
        System.out.println(res);
        return res;
    }
}
