package juc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        int left = 0, right = c.length-1;
        while(left < right) {
            if(c[left] - 'a' < 0 || c[left] - 'a' >= 26) {
                left++;
                continue;
            }
            if(c[right] - 'a' < 0 || c[right] - 'a' >= 26) {
                right--;
                continue;
            }
            if(c[left++] != c[right--]) {
                return false;
            }
        }
        return true;
    }

    public static int kthSmallest(int[][] mat, int k) {
        int size = mat.length;
        int len = mat[0].length;
        int[] pos = new int[size];
        int[] sum = new int[size*len];
        int s = 0;
        for(int i = 0; i < size; i++) {
            s += mat[i][pos[i]];
        }
        sum[0] = s;
        Set<Integer> set = new HashSet<>();
        for(int a = 1; a < k; a++) {
            int minIdx = -1;
            int mins = Integer.MAX_VALUE;
            for(int i = 0; i < size; i++) {
                s = sum[a-1];

                if(pos[i] + 1 >= len) {
                    continue;
                }
                s += mat[i][pos[i]+1];
                s -= mat[i][pos[i]];
                if(s < mins) {
                    minIdx = i;
                    mins = s;
                }
            }
            set.add(minIdx);
            pos[minIdx]++;
            sum[a] = mins;
        }
        return sum[k-1];
    }

    public static int nthUglyNumber(int n) {
        if (n == 0) {
            return 1;
        }
        List<Integer> rs = new ArrayList<>(n);
        int a = 2, b = 3, c = 5;
        int x = 1, y = 1, z = 1;
        rs.add(1);
        int pre = 1;
        for(int i = 1; i < n; i++) {
            int ax = a * rs.get(x-1);
            int by = b * rs.get(y-1);
            int cz = c * rs.get(z-1);
            if(ax == pre) {
                ax = a * rs.get(x++);
            }
            if(by == pre) {
                by = b * rs.get(y++);
            }
            if(cz == pre) {
                cz = c * rs.get(z++);
            }
            if(ax <= by) {
                if(ax <= cz) {
                    x++;
                    rs.add(ax);
                    pre = ax;
                } else {
                    z++;
                    rs.add(cz);
                    pre = cz;
                }
            } else {
                if(by <= cz) {
                    y++;
                    rs.add(by);
                    pre = by;
                } else {
                    z++;
                    rs.add(cz);
                    pre = cz;
                }
            }

        }
        return rs.get(n-1);
    }

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Arrays.sort(nums);

        UF uf = new UF(nums);
        boolean flag = nums[0] > 1;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (gcd(nums[i], nums[j])) {
                    uf.union(i, j);
                    flag = true;
                }
            }
        }
        return flag && uf.all(nums.length);
    }

    /**
     * 求最大公约数
     * @param m
     * @param n
     * @return
     */
    public int gcdFast(int m, int n) {
        // m和n的最大公约数
        int gcd = 1;
        // m和n都是偶数
        if ((m & 1) == 0 && (n & 1) == 0) {
            gcd = 2;
            m >>= 1;
            n >>= 1;
        }
        // m是偶数，n是奇数
        else if ((m & 1) == 0 && (n & 1) != 0) {
            m >>= 1;
        }
        // m是奇数，n是偶数
        else if ((m & 1) != 0 && (n & 1) == 0) {
            n >>= 1;
        }
        // m和n都是奇数
        else {
            int big = Math.max(m, n);
            int small = Math.min(m, n);
            int diff = big - small;
            return gcdFast(diff, small);
        }
        return gcd * gcdFast(m, n);
    }


    public boolean gcd(int m, int n) {
        if(m < n) {
            m = m ^ n;
            n = m ^ n;
            m = m ^ n;
        }
        m = m % n;
        while(n > 1) {
            m = m % n;
            if (m == 0) {
                break;
            }
            m = m ^ n;
            n = m ^ n;
            m = m ^ n;
        }
        return n > 1;
    }

    class UF {
        int[] root;
        int[] weight;
        int len;

        public UF(int[] nums) {
            len = nums.length;
            root = new int[len];
            weight = new int[len];
            int pre = nums[0],preIdx = 0;
            for(int i = 0; i < len; i++) {
                if(nums[i] == pre) {
                    root[i] = preIdx;
                    weight[preIdx]++;
                } else {
                    pre = nums[i];
                    preIdx = i;
                    root[i] = i;
                    weight[i] = 1;
                }
            }
        }

        public void union(int m, int n) {
            int s = find(m);
            int t = find(n);
            if (s == t) {
                return;
            }
            if (weight[s] > weight[t]) {
                root[t] = s;
                weight[s] += weight[t];
            } else {
                root[s] = t;
                weight[t] += weight[s];
            }
        }

        public int find(int m) {
            while(root[m] != m) {
                m = root[m];
            }
            return m;
        }

        public boolean connected(int m, int n) {
            return find(m) == find(n);
        }

        public boolean all(int len) {
            int rootWeight = weight[find(0)];
            return rootWeight == len;
        }
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] c = s.toCharArray();
        int pre = map.get(c[0]);
        int rs = 0;
        for(int i = 1; i < c.length; i++) {
            int num = map.get(c[i]);
            if (num > pre) {
                rs = rs + num - pre;
                if (i + 1 < c.length) {
                    pre = map.get(c[++i]);
                } else {
                    pre = 0;
                }
            } else {
                if (pre == 0) {
                    pre = num;
                } else {
                    rs = rs + pre;
                    pre = num;
                }
            }
        }
        return rs + pre;
    }

    public static long find(long left ,long right) {
        if (left >= right) {
            return left;
        }
        long mid = (left + right) / 2;
        if(mid > 1702766719) {
            right = mid;
        } else {
            left = mid + 1;
        }
        return find(left, right);
    }

    public static int minLength(String s) {
        if(s.length() < 2) {
            return s.length();
        }
        int rs;
        do {
            rs = s.length();
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        } while(rs != s.length());
        return rs;
    }

    public static int[][] mergeArray() {
        int[][] ints = {{1, 2}, {3, 4}};
        Arrays.sort(ints, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] an : ints) {
            if (list.isEmpty()) {
                list.add(an);
            } else {
                int[] last = list.get(list.size() - 1);
                if (last[1] >= an[0]) {
                    last[1] = Math.max(last[1], an[1]);
                } else {
                    list.add(an);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        if (c.length < 2) {
            return s;
        }
        int maxLen = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < c.length; i++) {
            int len = 1;
            for(int j = 1; i-j>=0 && i+j < c.length; j++) {
                if(c[i-j] == c[i + j]) {
                    len = 1 + j * 2;
                    if (len > maxLen) {
                        maxLen = len;
                        left = i - j;
                        right = i + j;
                    }
                } else {
                    break;
                }
            }
            if(i+1 < c.length && c[i] == c[i+1]) {
                for(int j = 1; i-j>=0 && i+j+1 < c.length; j++) {
                    if(c[i-j] == c[i + j + 1]) {
                        len = 2 + j * 2;
                        if (len > maxLen) {
                            maxLen = len;
                            left = i - j;
                            right = i + j + 1;
                        }
                    } else {
                        break;
                    }
                }
                if (maxLen < 2) {
                    maxLen = 2;
                    left = i;
                    right = i + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int rs = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            if (sum < target) {
                sum += nums[i];
                queue.offer(nums[i]);
            } else {
                while(sum >= target) {
                    rs = rs == 0 ? queue.size() : Math.min(queue.size(), rs);
                    sum -= queue.pop();
                }
                i--;
            }
        }
        while(sum >= target) {
            rs = rs == 0 ? queue.size() : Math.min(queue.size(), rs);
            sum -= queue.pop();
        }
        return rs;
    }


    public static int strStr(String haystack, String needle) {
        char[] needleChars = needle.toCharArray();
        char[] haystackChars = haystack.toCharArray();
        int[] needleIdx = buildArray(needleChars);

        int i = 0, j = 0;
        while (i < haystackChars.length && j < needleChars.length) {
            if (haystackChars[i] == needleChars[j]) {
                i++;
                j++;
            } else if (j > 0) {
                // 从前一个最长前缀后缀的位置开始匹配
                j = needleIdx[j - 1];
            } else {
                i++;
            }
        }
        return j == needleChars.length ? i - j : -1;
    }

    // 构造字符串最长前缀后缀数组
    public static int[] buildArray(char[] nums) {
        int len = nums.length;
        int[] rs = new int[len];
        rs[0] = 0;
        int i = 1, j = 0;
        while (i < len) {
            if (nums[i] == nums[j]) {
                rs[i++] = ++j;
            } else if (j > 0) {
                // 从前一个最长前缀后缀的位置开始匹配
                j = rs[j - 1];
            } else {
                rs[i++] = 0;
            }
        }
        return rs;
    }

    public static void rotate(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        k = k % len;
        if(k == 0) {
            return;
        }
        int fi = 0;
        int fv = nums[fi];
        boolean[] flag = new boolean[len];
        for(int i = 0; i < len; i++) {
            int ni = (fi + k) % len;
            if (flag[ni]) {
                fi = (fi + 1) % len;
                fv = nums[fi];
                i--;
                continue;
            }
            flag[ni] = true;
            fv = fv ^ nums[ni];
            nums[ni] = fv ^ nums[ni];
            fv = fv ^ nums[ni];
            fi = ni;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     * @param nums 待排序数组
     * @return 排序后的数组
     */
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int len = nums.length;
        int[] rs = new int[len];
        int[] tmp = new int[len];
        for (int i = 1; i < len; i *= 2) {
            for (int j = 0; j < len; j += 2 * i) {
                int start = j;
                int mid = Math.min(j + i, len);
                int end = Math.min(j + 2 * i, len);
                int k = start;
                int l = mid;
                int m = start;
                while (k < mid && l < end) {
                    if (nums[k] < nums[l]) {
                        tmp[m++] = nums[k++];
                    } else {
                        tmp[m++] = nums[l++];
                    }
                }
                while (k < mid) {
                    tmp[m++] = nums[k++];
                }
                while (l < end) {
                    tmp[m++] = nums[l++];
                }
                for (int n = start; n < end; n++) {
                    nums[n] = tmp[n];
                }
            }
        }
        return nums;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rs;
        }
        Arrays.sort(nums);
        Integer ni = nums[0];
        fi:for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return rs;
            }
            if (i > 0 && ni == nums[i]) {
                continue;
            }
            ni = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(ni + nums[j] > 0) {
                    continue fi;
                }
                if(nums[j-1] == nums[j] && j-1 != i) {
                    continue;
                }
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[k-1] == nums[k] && k-1 != j) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        rs.add(list);
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        break;
                    }
                }
            }
        }
        return rs;
    }

    public int matrixSum(int[][] nums) {
        int rs = 0;

        List<PriorityQueue<Integer>> queueList = new ArrayList<>();
        for (int[] num : nums) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Integer::intValue, Comparator.reverseOrder()));
            for (int i : num) {
                queue.add(i);
            }
            queueList.add(queue);
        }

        int l = nums[0].length;
        for (int i = 0; i < l; i++) {
            int max = 0;
            for (PriorityQueue<Integer> queue : queueList) {
                if (queue.size() > 0) {
                    max = Math.max(max, queue.poll());
                }
            }
            rs += max;
        }
        return rs;
    }

    public static String getMaxSubStr(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        String rs = "";
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                int currLen = i - start;
                if (maxLen < currLen) {
                    rs = s.substring(start, i);
                    maxLen = currLen;
                }
                int old = map.get(s.charAt(i));
                for (int j = start; j <= old; j++) {
                    map.remove(s.charAt(j));
                }
                start = old + 1;
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        if (maxLen < len - start) {
            rs = s.substring(start, len);
        }

        return rs;
    }

}
