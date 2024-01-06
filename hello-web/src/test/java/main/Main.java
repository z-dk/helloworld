package main;

import com.zdk.hello.util.CommonServiceUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(CommonServiceUtil.queryWeatherByCityCode(110112));
    }

    boolean[][] foot;

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
