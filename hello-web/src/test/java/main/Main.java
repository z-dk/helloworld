package main;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        long b = a * a;
        long count = Arrays.stream(new int[]{6}).filter(o -> o < 1).count();
        new int[]{(int) count};
        System.out.println(b);
        System.out.println(validSubstringCount("dcbdcdccb", "cdd"));
    }
    static int idx = 0;
    static PriorityQueue<Integer> index = new PriorityQueue<>();
    public static long validSubstringCount(String word1, String word2) {
        int l = word2.length();
        Map<Character, List<Integer>> base = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < l; i++) {
            char c = word2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int m = word1.length();
        for(int i = 0; i < m; i++) {
            char c = word1.charAt(i);
            List<Integer> pos = base.getOrDefault(c, new ArrayList<>());
            pos.add(i);
            base.put(c, pos);
        }
        return get(word1, map, base, idx, m);
    }

    private static int get(String word1, Map<Character, Integer> map, Map<Character, List<Integer>> base, int limit, int m) {
        int res = 0;
        int left = 1000000, right = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character c = entry.getKey();
            Integer ct = entry.getValue();
            List<Integer> pos = base.get(c);
            if (pos == null || pos.size() < ct || pos.get(pos.size() - ct) < limit) {
                return res;
            }
            int l1 = 0, r1 = 0;
            for(int i = 0; i < pos.size(); i++) {
                if (pos.size() - i < ct) {
                    return res;
                }
                if (pos.get(i) < limit) {
                    continue;
                }
                l1 = pos.get(i);
                r1 = pos.get(i + ct - 1);
                for (int j = i; j <= i + ct - 1; j++) {
                    index.offer(pos.get(j));
                }
                break;
            }
            left = Math.min(left, l1);
            right = Math.max(right, r1);
        }
        res = (left + 1 - limit) * (m - right);
        while(right < m) {
            index.poll();
            char c = word1.charAt(left);
            List<Integer> pos = base.get(c);
            int nr = find(pos, left) + map.get(c);
            if (nr >= pos.size()) {
                return res;
            }
            nr = pos.get(nr);
            index.offer(nr);
            nr = Math.max(nr, right);
            int nl = index.peek();
            int currct = (m - nr) * (nl - left);
            res += currct;
            left = nl;
            right = nr;
        }


        return res;
    }

    private static int find(List<Integer> pos, int val) {
        int l = 0, r = pos.size() - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            if(pos.get(mid) == val) {
                return mid;
            } else if (pos.get(mid) > val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }
        return mid;
    }

    public static long findMaximumNumber(long k, int x) {
        int pos = 0;
        long acc = 0, curr = 0;
        for(int i = 1; i <= 32; i++) {
            if (i % x == 0) {
                pos += (1 << (i - 1));
            }
        }
        long no = 1 << x;
        for(long i = 1; i <= Long.MAX_VALUE; i += no) {
            long ct = i & pos;
            curr = calc(ct);
            for (int j = 0; j < no; j++) {
                acc += curr;
                if (acc > k) {
                    return i + j - 1;
                }
            }
        }
        return 0;
    }

    public static long calc(long num) {
        long ct = 0;
        while (num > 0) {
            num &= (num - 1);
            ct++;
        }
        return ct;
    }

    boolean[][] foot;

    public static int maximizeGreatness(int[] nums) {
        List<Integer> orders = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        int res = 0;
        Integer pre = 0;
        for (int i = 1; i < orders.size(); i++) {
            Integer curr = orders.get(i);
            if (curr > orders.get(pre)) {
                res++;
                pre++;
            }
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
        foot = new boolean[m][n];
        int res = count(0, 0, m, n, k);
        return res;
    }

    public int count(int i, int j, int m, int n, int k) {
        int res = 0;
        if(valid(i, j, k)) {
            res++;
            if(i + 1 < m) {
                res += count(i + 1, j, m, n, k);
            }
            if(j + 1 < n) {
                res += count(i, j + 1, m, n, k);
            }
        }
        return res;
    }

    public boolean valid(int i, int j, int k) {
        int sum = 0;
        if(foot[i][j]) {
            return false;
        }
        int tempi = i, tempj = j;
        while(i != 0) {
            sum += i % 10;
            i = i / 10;
        }
        while(j != 0) {
            sum += j % 10;
            j /= 10;
        }
        if(sum <= k) {
            foot[tempi][tempj] = true;
        }
        return sum <= k;
    }

    public String minimumString(String a, String b, String c) {
        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.sort(Comparator.comparing(String::length).reversed().thenComparing(s -> s));
        String res = list.get(0);
        b = list.get(1);
        int next = findSameLast(res, b);
        res = concat(res, b, -2, "", next);
        c = list.get(2);
        int next2 = findSameLast(res, c);
        res = concat(res, c, next, b, next2);
        return res;
    }

    public String concat(String a, String b, int odx, String c, int idx) {
        String res = a;
        if(idx == -1) {
            String i = a + b;
            String j = b + a;
            res = i.compareTo(j) > 0 ? j : i;
            if(odx == -1) {
                odx = a.indexOf(c);
                odx =  odx == 0 ? c.length() : odx;
                String k = a.substring(0, odx) + b + a.substring(odx);
                res = res.compareTo(k) > 0 ? k : res;
            }
            return res;
        }
        return res + b.substring(idx);
    }

    public int findSameLast(String a, String b) {
        int m = a.length();
        int n = b.length();
        if(a.indexOf(b) != -1) {
            return n;
        }
        int left = 0, right = 0;
        while(left < m) {
            if(a.charAt(left) == b.charAt(right)) {
                left++;
                right++;
            } else {
                left = left - right + 1;
                right = 0;
            }
        }
        return right == 0 ? -1 : right;
    }

    public static int maxIncreasingGroups(List<Integer> usageLimits) {
        int rs = 0;
        int n = usageLimits.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (int) a).reversed());
        pq.addAll(usageLimits);
        while(true) {
            int curr = rs + 1;
            List<Integer> temp = new ArrayList<>();
            for(int i = 1; i <= curr; i++) {
                if (pq.isEmpty()) {
                    return rs;
                }
                int ct = pq.poll();
                if(ct > 0) {
                    temp.add(ct - 1);
                } else {
                    return rs;
                }
            }
            pq.addAll(temp);
            rs++;
        }
    }

}
